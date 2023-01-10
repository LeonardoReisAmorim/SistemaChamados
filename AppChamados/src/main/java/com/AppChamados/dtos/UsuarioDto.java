package com.AppChamados.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.AppChamados.entidades.Chamado;
import com.AppChamados.entidades.Cliente;
import com.AppChamados.entidades.Usuario;
import com.AppChamados.repositorios.UsuarioRepository;


public class UsuarioDto {

	private String id;
	private String nome;
	private String email;
	private String senha;
	List<ChamadoDto> listaChamados;
	private byte[] foto;
	
	
	
	public UsuarioDto() {}

	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.listaChamados = ChamadoDto.converte(usuario.getListaChamados());
	}
	
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
	
	public List<ChamadoDto> getListaChamados() {
		return listaChamados;
	}

	public void setListaChamados(List<ChamadoDto> chamados) {
		this.listaChamados = chamados;
	}
	
	public Usuario getUsuario() {
		Usuario usuario=new Usuario();
		usuario.setId(id);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		return usuario;
	}
	
	
	public static List<UsuarioDto> converte (List<Usuario> lista) {
		 return lista.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	public static UsuarioDto Converte1Usuario(Usuario usuario) {
		UsuarioDto usuarioDto =new UsuarioDto();
		usuarioDto.id = usuario.getId();
		usuarioDto.nome = usuario.getNome();
		usuarioDto.email = usuario.getEmail();
		usuarioDto.senha = usuario.getSenha();
		if(usuario.getListaChamados()!=null) {
			usuarioDto.listaChamados = ChamadoDto.converte(usuario.getListaChamados());
		}
		return usuarioDto;
	}
	
	public  Usuario AtualizarUsuario(UsuarioRepository repository,String id) {
		Usuario usuario = repository.getReferenceById(id);
		usuario.setEmail(email);
		//usuario.setId(id);
		usuario.setNome(nome);
		//usuario.setSenha(senha);
	    	
	    return usuario;
		
	}
	
}
