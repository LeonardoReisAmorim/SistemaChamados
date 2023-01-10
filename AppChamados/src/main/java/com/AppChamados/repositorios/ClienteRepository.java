package com.AppChamados.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;


import com.AppChamados.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String Nome);
	Cliente findByCnpj(String Cnpj);
	
}
