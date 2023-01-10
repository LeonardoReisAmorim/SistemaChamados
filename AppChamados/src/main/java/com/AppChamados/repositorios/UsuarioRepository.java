package com.AppChamados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppChamados.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByNome(String nome);
	Usuario findByEmailAndSenha(String email, String Senha);
}
