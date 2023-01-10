package com.AppChamados.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.AppChamados.entidades.Cliente;

public class ClienteDto {
	
	private long id;
	private String nome;
	private String cnpj;
	private String endereco;
	List<ChamadoDto> listaChamados;
	
	public ClienteDto(Cliente cliente) {
	    this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cnpj = cliente.getCnpj();
		this.endereco = cliente.getEndereco();
	}
	
	public ClienteDto() {
	}
	
	//converte uma lista Cliente para liasta ClienteDto
	public static List<ClienteDto> converte(List<Cliente> lista) {
		 return lista.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	

	public static ClienteDto Converte1Cliente(Cliente cliente) {
		
			ClienteDto clienteDto =new ClienteDto();
			clienteDto.setCnpj(cliente.getCnpj());;
			clienteDto.setEndereco(cliente.getEndereco());
			clienteDto.setId(cliente.getId());
			clienteDto.setNome(cliente.getNome());
			return clienteDto;
	
	}
	
	//convert dto pra cliente - para post
	public Cliente converteToCliente() {
		Cliente cliente=new Cliente();
		cliente.setCnpj(cnpj);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		return cliente;
	}


	
	public Cliente getCliente() {
		Cliente cliente=new Cliente();
		cliente.setCnpj(cnpj);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		cliente.setId(id);
		return cliente;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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

	public List<ChamadoDto> getListaChamados() {
		return listaChamados;
	}

	public void setListaChamados(List<ChamadoDto> chamados) {
		this.listaChamados = chamados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
