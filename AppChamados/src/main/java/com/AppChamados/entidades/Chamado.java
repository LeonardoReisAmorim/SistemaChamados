package com.AppChamados.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="chamados")
public class Chamado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Cliente chamadoCliente;
	@ManyToOne
	private Usuario chamadoUsuario;
	@Enumerated(EnumType.STRING)
	private Assunto assunto;
	private String status;
	private String data;
	
	
	public Chamado (){} 
	public Chamado(Assunto assunto,String status,String data){
		this.assunto = assunto;
		this.status = status;
		this.data = data;
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Usuario getUsuario() {
		return chamadoUsuario;
	}
	public void setUsuario(Usuario usuario) {
		this.chamadoUsuario = usuario;
	}
	
	public Cliente getCliente() {
		return chamadoCliente;
	}
	public void setCliente(Cliente cliente) {
		this.chamadoCliente = cliente;
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

	
	
}
