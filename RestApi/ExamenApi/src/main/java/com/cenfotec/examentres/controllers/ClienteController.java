package com.cenfotec.examentres.controllers;



(import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examentres.model.Cliente;

import com.cenfotec.examentres.repository.ClienteRepository;


@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
	
	private ClienteRepository repository;
	
	
	ClienteController(ClienteRepository clienteRepository) {
		 this.repository = clienteRepository;
		 }

	



}
