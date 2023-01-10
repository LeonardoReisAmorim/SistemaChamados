package com.AppChamados.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.AppChamados.entidades.Assunto;
import com.AppChamados.entidades.Chamado;
import com.AppChamados.entidades.Cliente;
import com.AppChamados.entidades.Usuario;
import com.AppChamados.repositorios.ChamadoRepository;
import com.AppChamados.repositorios.ClienteRepository;
import com.AppChamados.repositorios.UsuarioRepository;

public class ChamadoDto {
	
	private long id;
	private String cliente;
	private Assunto assunto;
	private String status;
	private String data;
	private String idusuario;
	private long idcliente;


	ChamadoDto(){}
	
	ChamadoDto(Chamado chamado){
		this.id = chamado.getId();
		this.cliente = chamado.getCliente().getNome();
		this.assunto = chamado.getAssunto();
		this.status = chamado.getStatus();
		this.data = chamado.getData();
		this.idcliente = chamado.getCliente().getId();
	}
	
	// converte chamado para chamadoDto
	public static List<ChamadoDto> converte(List<Chamado> lista){
		 return lista.stream().map(ChamadoDto::new).collect(Collectors.toList());
	}
	
	public static List<ChamadoDto> converteChamadoporUsuario(String id, UsuarioRepository usuarioRepository, ChamadoRepository Chamadorepository){
		Usuario usuario = usuarioRepository.getReferenceById(id);
		List<Chamado> lista = Chamadorepository.findByChamadoUsuario(usuario);
		return lista.stream().map(ChamadoDto::new).collect(Collectors.toList());
	}
	
	//converte Dto para chamado
	public  Chamado getChamado(ClienteRepository repository, UsuarioRepository usuariorepository) {
		 Chamado chamado= new Chamado();
		 	chamado.setAssunto(this.assunto);
		 	chamado.setData(this.data);
		 	chamado.setStatus(this.status);
	    	Cliente cliente = repository.getReferenceById(this.idcliente);
	    	chamado.setCliente(cliente);
	    	Usuario usuario = usuariorepository.getReferenceById(this.idusuario);
	    	chamado.setUsuario(usuario);
	    	return chamado;
		
	}
	
	public static ChamadoDto converte1chamado(Chamado chamado) {
		ChamadoDto chamadodto = new ChamadoDto(chamado);
		return chamadodto;
	}

	public  Chamado AtualizarChamado(ChamadoRepository repository,ClienteRepository clienteRepository, UsuarioRepository usuariorepository, long id) {
		 Chamado chamado= repository.getReferenceById(id);
		 	chamado.setAssunto(this.assunto);
		 	chamado.setData(this.data);
		 	chamado.setStatus(this.status);
	    	Cliente cliente = clienteRepository.getReferenceById(this.idcliente);
	    	chamado.setCliente(cliente);
	    	Usuario usuario = usuariorepository.getReferenceById(this.idusuario);
	    	chamado.setUsuario(usuario);
	    	return chamado;
		
	}
	
	
	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	
	
	

}
