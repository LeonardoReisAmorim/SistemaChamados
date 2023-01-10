package com.AppChamados.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.AppChamados.entidades.Assunto;
import com.AppChamados.entidades.Chamado;
import com.AppChamados.entidades.Usuario;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
	
	public List<Chamado>findByAssunto(String assunto);
	public List<Chamado>findByChamadoUsuario(Usuario u);
	public List<Chamado>findByStatus(String status);
	public List<Chamado>findByChamadoClienteNome(String clienteNome);
	public List<Chamado>deleteById(long id);
	public Chamado getReferenceById(long id);
}
