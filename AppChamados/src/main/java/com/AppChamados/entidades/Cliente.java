package com.AppChamados.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cnpj;
	private String endereco;
	private String nome;
	@OneToMany(mappedBy = "chamadoCliente", cascade = CascadeType.ALL)
	List<Chamado> listaChamados;
	
	public Cliente(){
		
	}
	
	public Cliente(String cnpj,String endereco,String nome){
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome= nome;
		
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public List<Chamado> getListaChamados() {
		return listaChamados;
	}
	public void setListaChamados(List<Chamado> listaChamados) {
		this.listaChamados = listaChamados;
	}
}
