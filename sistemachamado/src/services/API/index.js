import axios from "axios";

//Base URL: http://localhost:8080
//CHAMADOS GET
//Rota para todos os chamados: chamados
//Rota para os chamados por nome: chamados/{Nome}
//Rota para os chamados por status: chamados/status/{status}
//CHAMADOS POST
//Rota cadastrar um chamado: chamados
//CHAMADOS PUT
//Rota atualizar um chamado: chamados/{id}
//CHAMADOS DELETE
//Rota atualizar um chamado: chamados/{id}

//CLIENTE GET
//Rota para todos os clientes: clientes
//Rota para os clientes por nome: clientes/{nome}
//CLIENTE POST
//Rota cadastrar um cliente: clientes
//CLIENTE PUT *CRIAR*
//Rota atualizar um cliente: clientes/{id}
//CLIENTE DELETE
//Rota atualizar um cliente: clientes/{id}

//USUARIOS GET
//Rota para todos os clientes: usuarios
//Rota para os usuarios por nome: usuarios/{nome}
//CLIENTE POST
//Rota cadastrar um usuario: usuarios
//CLIENTE PUT *CRIAR*
//Rota atualizar um usuario: usuarios/{id}
//CLIENTE DELETE
//Rota atualizar um usuario: usuarios/{id}


const api = axios.create({
    baseURL: "http://localhost:8080",
});

export default api;