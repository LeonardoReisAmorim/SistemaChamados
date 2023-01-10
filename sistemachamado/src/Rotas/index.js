import { Route, Routes } from "react-router-dom";
import Chamados from "../pages/Chamados";
import Clientes from "../pages/Clientes";
import EditarChamado from "../pages/EditarChamado";
import Login from "../pages/Login";
import Novochamado from "../pages/NovoChamado";
import NovoUsuario from "../pages/NovoUsuario";
import Perfil from "../pages/Perfil";



function Rotas(){

    return(
        <Routes>
            <Route path="/" element={<Login/>}></Route>
            <Route path="/novousuario" element={<NovoUsuario/>}></Route>
            <Route path="/perfil" element={<Perfil/>}></Route>
            <Route path="/clientes" element={<Clientes/>}></Route>
            <Route path="/chamados" element={<Chamados/>}></Route>
            <Route path="/novochamado/:id" element={<Novochamado/>}></Route>
            <Route path="/editarchamado/:id" element={<EditarChamado/>}></Route>
        </Routes>
    );

}export default Rotas;