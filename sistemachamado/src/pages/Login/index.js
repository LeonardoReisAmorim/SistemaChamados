import { useRef } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useUserAuth } from '../../contexts/auth';
import './login.css'
import minhaImagem from '../../files/logoLogin.png'
import { toast } from 'react-toastify';

function Login() {

    const email = useRef();
    const senha = useRef();
    const { signIn } = useUserAuth();
    const history=useNavigate();

    async function handleSubmit(evt) {
        evt.preventDefault();
           
        try {
            await signIn(
              email.current.value,
              senha.current.value
            );
            history('/perfil');
        } catch(error) {
            switch(error.code) {
              case 'auth/user-not-found': toast.error('Usuário não encontrado!');       break;
              case 'auth/wrong-password': toast.error('Senha incorreta!');              break;
              case 'auth/invalid-email':  toast.error('E-mail inválido!');              break;
              default:                    toast.error('Ocorreu um erro desconhecido!'); break;
            }
        }
    }

    return (
        <div className='container'>
            <div className='logo'>
                <img src={minhaImagem}  className='imgLogin'/>
                <div className='inputLogin'>
                    <h1 className='entrarlogo'>Entrar</h1>
                    <form action="" method='POST' onSubmit={handleSubmit}>
                        <input type="text" ref={ email } placeholder="email@email.com"/>
                        <input type="password" ref={ senha } required placeholder="•••••••"/>
                        <input type="submit" value="Acessar"/>
                    </form>
                    <Link to="/novousuario" className='criarConta'><strong>Criar uma conta</strong></Link>
                </div>
            </div>
        </div>
    );
} export default Login;