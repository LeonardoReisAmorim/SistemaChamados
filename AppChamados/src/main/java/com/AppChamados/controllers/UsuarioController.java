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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppChamados.dtos.ChamadoDto;
import com.AppChamados.dtos.ClienteDto;
import com.AppChamados.dtos.UsuarioDto;
import com.AppChamados.entidades.Chamado;
import com.AppChamados.entidades.Usuario;
import com.AppChamados.repositorios.UsuarioRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@GetMapping
	public List<UsuarioDto> ListarUsuarios() {
		return UsuarioDto.converte(repository.findAll());
	}
	
	@GetMapping("/{nome}")
	public UsuarioDto ListarUsuariosPorNome(@PathVariable String nome) {
		return UsuarioDto.Converte1Usuario(repository.findByNome(nome));
	}
	
	@GetMapping("id/{id}")
	public UsuarioDto ListarUsuariosPorId(@PathVariable String id) {
		return UsuarioDto.Converte1Usuario(repository.getReferenceById(id));
	}
	
	@GetMapping("/{email}/{senha}")
	public UsuarioDto ListarUsuariosPorEmailSenha(@PathVariable String email, @PathVariable String senha) {
		return UsuarioDto.Converte1Usuario(repository.findByEmailAndSenha(email, senha));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto userForm) {
		Usuario usuario=userForm.getUsuario();
		Usuario usuarioSave = repository.save(usuario);
		UsuarioDto userSave = UsuarioDto.Converte1Usuario(usuarioSave);
		return new ResponseEntity<UsuarioDto>(userSave,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> Atualizar( @RequestBody  UsuarioDto usuarioDto, @PathVariable String id) {
		Usuario usuario =  usuarioDto.AtualizarUsuario(repository,id);
		repository.save(usuario);
		return new ResponseEntity<UsuarioDto>(usuarioDto,HttpStatus.CREATED);}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable String id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
