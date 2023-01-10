package com.AppChamados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppChamados.dtos.ClienteDto;
import com.AppChamados.entidades.Cliente;
import com.AppChamados.repositorios.ClienteRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<ClienteDto> listar(){
		return ClienteDto.converte(repository.findAll());
	}
	
	@GetMapping("/{nome}")
	public ClienteDto listarp(@PathVariable String nome){
		
		return ClienteDto.Converte1Cliente(repository.findByNome(nome));
		
	}
	
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto clienteDto) {
		Cliente cliente =clienteDto.converteToCliente();
		Cliente clienteSave = repository.save(cliente);
		ClienteDto clienteDtoSave = ClienteDto.Converte1Cliente(clienteSave);
		return new ResponseEntity<ClienteDto>(clienteDtoSave,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
