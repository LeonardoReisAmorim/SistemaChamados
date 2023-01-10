package com.AppChamados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppChamados.dtos.ChamadoDto;
import com.AppChamados.entidades.Chamado;
import com.AppChamados.repositorios.ChamadoRepository;
import com.AppChamados.repositorios.ClienteRepository;
import com.AppChamados.repositorios.UsuarioRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UsuarioRepository Usuariorepository;
	
	@GetMapping
	public List<ChamadoDto> listar() {
		return ChamadoDto.converte(repository.findAll());
	}
	
	@GetMapping("/idusuario/{id}")
	public List<ChamadoDto> listarPorUsuario(@PathVariable String id) {
		return ChamadoDto.converteChamadoporUsuario(id, Usuariorepository, repository);
	}
	
	
	@GetMapping("/{nome}")
	public List<ChamadoDto> listarPorCliente(@PathVariable String nome) {
		return ChamadoDto.converte(repository.findByChamadoClienteNome(nome));
	}
	
	
	@GetMapping("/status/{status}")
	public List<ChamadoDto> listarPorStatus(@PathVariable String status) {
	 return ChamadoDto.converte(repository.findByStatus(status));
	 }
	
	@GetMapping("/idchamado/{id}")
	public ChamadoDto listarPorStatus(@PathVariable long id) {
	 return ChamadoDto.converte1chamado(repository.getReferenceById(id));
	 }
	
	@PostMapping
	public ResponseEntity<ChamadoDto> cadastrar( @RequestBody  ChamadoDto chamadoDto) {
			Chamado chamado= chamadoDto.getChamado(clienteRepository, Usuariorepository);
			repository.save(chamado);
			return new ResponseEntity<ChamadoDto>(chamadoDto,HttpStatus.CREATED);}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ChamadoDto> Atualizar( @RequestBody  ChamadoDto chamadoDto, @PathVariable long id) {
		Chamado chamado= chamadoDto.AtualizarChamado(repository,clienteRepository,Usuariorepository, id);
		repository.save(chamado);
		return new ResponseEntity<ChamadoDto>(chamadoDto,HttpStatus.CREATED);}
	
		
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		repository.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	 }

}
