import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"
import Header from "../../components/Header";
import SideNav from "../../components/SideNav";
import api from "../../services/API";
import { useUserAuth } from '../../contexts/auth';
import { toast } from 'react-toastify';
import './editarchamado.css'

function EditarChamado() {

    const { user } = useUserAuth();
    const { id } = useParams();
    const [clientes, setClientes] = useState([]);
    const [assunto, setAssunto] = useState("");
    const [status, setStatus] = useState("");
    const [cliente, setCliente] = useState(0);
    const [chamado, setChamado] = useState({});
    const history = useNavigate();

    useEffect(() => {

        async function loadChamado() {
            await api.get(`/chamados/idchamado/${id}`)
                .then((response) => setChamado(response.data))
                .catch((err) => console.log(err));

        }

        loadChamado();
        setStatus(chamado.status);
        setCliente(chamado.idcliente);
        setAssunto(chamado.assunto);
    }, [chamado.assunto, chamado.idcliente, chamado.status, id])

    useEffect(() => {
        async function loadClientes() {
            await api.get("/clientes")
                .then((response) => setClientes(response.data))
                .catch((err) => console.log(err));
        }
        loadClientes();
    }, [])



    const handleSubmit = (evt) => {
        evt.preventDefault();

        let json = JSON.stringify({ idcliente: Number(cliente), assunto: assunto, status: status, data: new Date().toLocaleDateString(), idusuario: user.uid });

        console.log(json);

        api.put(`chamados/${id}`, json, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response) => {
            response.data != null ? history("/chamados") : toast.error("Ocorreu um erro interno");
        })
            .catch();
    }


    return (
        <div>
            <SideNav />
            <div className="containerPrincipal">
                <Header title='Editar Atendimento' icone='fa fa-flag-o fa-lg' />
                <div className="bodyeditarChamado">
                    <form action="" method='POST' onSubmit={handleSubmit}>
                        <h3>Cliente</h3>
                        <div className="select">
                            <select value={cliente} onChange={e => setCliente(e.target.value)} onmou>
                                <option value="">Selecione o cliente</option>
                                {clientes.map((item) => {
                                    return (
                                        <option key={item.id} value={item.id}>{item.nome}</option>
                                    )
                                })}
                            </select>
                        </div>
                        <h3>Assunto</h3>
                        <div className="select">
                            <select value={assunto} onChange={e => setAssunto(e.target.value)}>
                                <option value="">Selecione o assunto</option>
                                <option value="Suporte">Suporte</option>
                                <option value="Manutenção">Manutenção</option>
                                <option value="Reparo">Reparo</option>
                            </select>
                        </div>
                        <h3>Status</h3>
                        <input type="text" defaultValue={chamado.status} onChange={e => setStatus(e.target.value)} />
                        <div className="cadastrarnovochamado">
                            <input type="submit" value="Editar" />
                        </div>

                    </form>
                </div>
            </div>
        </div>
    )

} export default EditarChamado;