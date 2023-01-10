package com.AppChamados.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity(name="usuarios")
public class Usuario {
	@Id
	private String id;
	@Lob
    private byte[] foto;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy = "chamadoUsuario", cascade = CascadeType.ALL) 
	List<Chamado> listaChamados;
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Chamado> getListaChamados() {
		return listaChamados;
	}
	public void setListaChamados(List<Chamado> listaChamados) {
		this.listaChamados = listaChamados;
	}
	
}
