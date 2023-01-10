import { useState } from "react";
import Header from "../../components/Header";
import SideNav from "../../components/SideNav";
import api from "../../services/API";
import { toast } from 'react-toastify';
import './clientes.css'

function Clientes() {

    const [nomeFantasia, setNomeFantasia] = useState();
    const [cnpj, setCnpj] = useState();
    const [endereco, setEndereco] = useState();

    const handleSubmit = (evt) => {
        evt.preventDefault();

        let json = JSON.stringify({ nome: nomeFantasia, cnpj: cnpj, endereco: endereco });
        
        api.post('clientes', json, {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then((response) => {
            toast.success("cliente cadastrado com sucesso");
          }).catch((err)=>{
            toast.error("Ocorreu um erro ao cadastrar cliente, contatar suporte")
          });
    }

    return (
        <div>
            <SideNav />
            <div className="containerPrincipal">
                <Header title='Clientes' icone='fa fa-user fa-lg' />

                <div className="bodyClientes">
                    <form action="" method='POST' onSubmit={handleSubmit}>
                        <h3>Nome</h3>
                        <input type="text" value={nomeFantasia} onChange={e => setNomeFantasia(e.target.value)} placeholder="Digite o Nome Fantasia" />
                        <h3>CNPJ</h3>
                        <input type="text" value={cnpj} onChange={e => setCnpj(e.target.value)} placeholder="Digite o CNPJ" />
                        <h3>Endereço</h3>
                        <input type="text" value={endereco} onChange={e => setEndereco(e.target.value)} placeholder="Digite o seu endereço" />
                        <input type="submit" className="salvarCliente" value="Salvar"/>
                    </form>

                </div>

            </div>
        </div>
    )
} export default Clientes;