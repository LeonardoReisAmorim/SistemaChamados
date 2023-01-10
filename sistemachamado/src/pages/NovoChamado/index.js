import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"
import Header from "../../components/Header";
import SideNav from "../../components/SideNav";
import api from "../../services/API";
import { toast } from 'react-toastify';
import './novochamado.css'


function Novochamado() {

    const { id } = useParams();
    const [clientes, setClientes] = useState([]);
    const [assunto, setAssunto] = useState("");
    const [status, setStatus] = useState("");
    const [cliente, setCliente] = useState(0);
    const history=useNavigate();

    useEffect(() => {
        async function loadClientes() {
            await api.get("/clientes")
                .then((response) => setClientes(response.data))
                .catch((err) => console.log("ocorreu erro interno " + err));
        }

        loadClientes();
    }, [])

    const handleSubmit = (evt) => {
        evt.preventDefault();

        let json = JSON.stringify({ idcliente: Number(cliente), assunto: assunto, status: status, data: new Date().toLocaleDateString(), idusuario: id });

        console.log(json);

        api.post('chamados', json, {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then((response) => {
            response.data != null ? history("/chamados") : toast.error("Ocorreu um erro interno")
          })
          .catch((err)=> console.log("erro: "+err));
    }

    return (
        <div>
            <SideNav />
            <div className="containerPrincipal">
                <Header title='Novo Atendimento' icone='fa fa-flag-o fa-lg' />
                <div className="bodynovoChamado">
                    <form action="" method='POST' onSubmit={handleSubmit}>
                        <h3>Cliente</h3>
                        <div className="select">
                            <select value={cliente} onChange={e => setCliente(e.target.value)}>
                                <option value="">Selecione o cliente</option>
                                {clientes.map((item) => {
                                    return (
                                        <option value={item.id}>{item.nome}</option>
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
                        <input type="text" value={status} onChange={e => setStatus(e.target.value)} />
                        <div className="cadastrarnovochamado">
                            <input  type="submit" value="Cadastrar" />
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    )

} export default Novochamado