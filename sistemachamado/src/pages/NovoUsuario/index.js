import { Link, useNavigate } from 'react-router-dom';
import './novousuario.css'
import minhaImagem from '../../files/logoLogin.png'
import { useRef } from 'react';
import api from '../../services/API';
import { toast } from 'react-toastify';
import { useUserAuth } from '../../contexts/auth';


function NovoUsuario(){

    const nome  = useRef();
    const email = useRef();
    const senha = useRef();
    const { signUp } = useUserAuth();
    const history=useNavigate();

    async function handleSubmit(evt) {
        evt.preventDefault();

        try {
            await signUp(
                email.current.value,
                senha.current.value
            ).then(response => {
                api.post('/usuarios', {
                    id:   response.user.uid,
                    nome: nome.current.value
                });
            });
            history(`/perfil`);
          } catch(error) {
            switch(error.code) {
              case 'auth/invalid-email':        toast.error('E-mail inválido!');              break;
              case 'auth/weak-password':        toast.error('Senha inválida!');               break;
              case 'auth/email-already-in-use': toast.error('E-mail já está em uso!');        break;
              default:                          toast.error('Erro interno'); break;
            }
          }
    }

    return(
        <div className='containerN'>
            <div className='logoN'>
                <img src={minhaImagem} alt='logoLogin' className='imgLoginN'/>
                <div className='inputLoginN'>
                    <h1 className='entrarlogoN'>Nova Conta</h1>
                    <form action="" method='POST' onSubmit={handleSubmit}>
                        <input type="text" ref={ nome } placeholder="Seu nome"/>
                        <input type="text" ref={ email } placeholder="email@email.com"/>
                        <input type="password" ref={ senha } required placeholder="•••••••"/>
                        <input type="submit" value="Cadastrar"/>
                    </form>
                    <Link to="/" className='criarContaN'><strong>Já possui uma conta? Entre aqui</strong></Link>
                </div>
            </div>
        </div>
    )
}export default NovoUsuario;