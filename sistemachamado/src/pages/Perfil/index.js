import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../components/Header";
import SideNav from "../../components/SideNav";
import api from "../../services/API";
import minhaImagem from '../../files/logoLogin.png'
import { useUserAuth } from '../../contexts/auth';
import './perfil.css'
import { toast } from "react-toastify";




function Perfil() {

    const { user, logOut } = useUserAuth();
    const [nome, setNome]   = useState();
    const [email, setEmail] = useState();
    const [usuario, setUsuario] = useState();
    const history=useNavigate();

    useEffect(() => {
        setEmail(user.email);
        api.get(`/usuarios/id/${user.uid}`)
        .then(response =>{
            setNome(response.data.nome);
            setUsuario(response.data);
        });

    }, [])

    async function AtualizarPerfil(){
        var usuarioAlterado=usuario;
        if(nome){
            usuarioAlterado.nome = nome;
        }
        if(email){
            usuarioAlterado.email = email;
        }
        setUsuario(usuarioAlterado);

        let json = JSON.stringify(usuario);

        console.log(json);

        api.put(`/usuarios/${user.uid}`, json, {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then((response) => {
            response.data != null ? toast.success("usuario atualizado com sucesso") : toast.error("Ocorreu um erro interno");
          })
          .catch((err)=> console.log("erro: "+err));
    }

    async function sair(){
        try {
            await logOut();
            history('/');
        } catch(error) {
            toast.error('Ocorreu um erro ao tentar deslogar!');
        }
    }

    return (
        <div>
            <SideNav/>
            <div className="containerPrincipal">

                <Header title='Meu perfil' icone='fa fa-cog fa-lg' />
                <div className="bodyPerfil">
                    <img src={minhaImagem} alt="foto de perfil" className="imgPerfil"/>
                    <h3>Nome</h3>
                    <input type="text" value={ nome } onChange={ (e) => setNome(e.target.value) }/>
                    <h3>Email</h3>
                    <input type="text" value={ email } disabled={ true }/>
                    <button className="salvarPerfil" onClick={()=>AtualizarPerfil()}>Salvar</button>
                </div>

                <div className="footerPerfil">
                    <button className="sair" onClick={()=>sair()}>Sair</button>
                </div>
            </div>
        </div>
    );
} export default Perfil;