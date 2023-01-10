import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../components/Header";
import SideNav from "../../components/SideNav";
import api from "../../services/API";
import { useUserAuth } from '../../contexts/auth';
import { toast } from 'react-toastify';
import './chamados.css'

function Chamados() {

    const { user } = useUserAuth();
    const [chamados, setChamados] = useState([]);
    const history=useNavigate();

    useEffect(() => {
        async function loadChamados() {
            await api.get('/chamados/idusuario/' + user.uid)
                .then((response) => setChamados(response.data))
                .catch((err) => {
                    toast.error("ops! ocorreu um erro" + err);
                });
        }
        loadChamados();
    }, [])

    function NavegarEditarChamado(idchamado) {
        history(`/EditarChamado/${idchamado}`);
    }

    function NavegarNovoChamado(){
        history(`/novochamado/${user.uid}`);
    }

    return (
        <div>
            <SideNav />
            <div className="containerPrincipal">

                <Header title='Atendimentos' icone='fa fa-flag-o fa-lg' />

                <div className="flexbutton"><button className="novochamado" onClick={()=>NavegarNovoChamado()}><i className="fa fa-plus fa-lg"></i> Novo Chamado</button></div>
                <div className="bodychamados">
                    <table>
                        <tr>
                            <th>Cliente</th>
                            <th>Assunto</th>
                            <th>Status</th>
                            <th>Cadastrados em</th>
                            <th>#</th>
                        </tr>
                        {chamados.map((item) => {
                            return (
                                <tr key={item.id}>
                                    <td>{item.cliente}</td>
                                    <td>{item.assunto}</td>
                                    <td><div className="columnstatus"><div className="statuschamado">{item.status}</div></div></td>
                                    <td>{item.data}</td>
                                    <td><div className="acoes"><div className="editarchamado" onClick={() => NavegarEditarChamado(item.id)}><i className="fa fa-pencil fa-lg"></i></div></div></td>
                                </tr>
                            )
                        })}
                    </table>
                </div>

            </div>
        </div>
    )
} export default Chamados