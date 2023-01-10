import { Link } from "react-router-dom";
import './sidenav.css'
import minhaImagem from '../../files/logoLogin.png'

function SideNav() {

    return (
        <div className="nav-side-menu">
            <div className="brand"><img src={minhaImagem} alt="imagem do usuario"/></div>
            <i className="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
            <div className="menu-list">
                <ul id="menu-content" className="menu-content collapse out">
                    <li>
                        <Link to="/chamados"><i className="fa fa-home fa-lg"></i> Chamados</Link>
                    </li>
                    <li>
                        <Link to="/clientes"><i className="fa fa-user fa-lg"></i> Clientes</Link>
                    </li>
                    <li>
                        <Link to={"/perfil"}><i className="fa fa-cog fa-lg"></i> Configurações</Link>
                    </li>
                </ul>
            </div>
        </div>
    );
} export default SideNav;