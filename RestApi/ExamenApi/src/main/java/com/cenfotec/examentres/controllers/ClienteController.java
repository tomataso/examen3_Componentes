package com.cenfotec.examentres.controllers;



import java.util.List;
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

	// --------------------------------------------------------------------------
	
	@GetMapping
	public List findAll(){
	 return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable
	long id){
	 return repository.findById(id)
	 .map(record ->
	ResponseEntity.ok().body(record))
	 .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente){
	 return repository.save(cliente);
	}
	
	
	@PutMapping(value="/{id}")
	 public ResponseEntity<Cliente>
	update(@PathVariable("id") long id,
			@RequestBody Cliente cliente){
		return repository.findById(id)
				.map(record -> {
					
					record.setNombre(cliente.getNombre());
					record.setApellidos(cliente.getApellidos());
					record.setDomicilio(cliente.getDomicilio());
					record.setCobro(cliente.getCobro());
					record.setTarjeta(cliente.getTarjeta());
					record.setMes(cliente.getMes());
					record.setAnno(cliente.getAnno());
					
					Cliente updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
	 }).orElse(ResponseEntity.notFound().build());
	 }

	
	
	@DeleteMapping(path ={"/{id}"})
	 public ResponseEntity<?> delete(@PathVariable("id")
	long id) {
	 return repository.findById(id)
			 .map(record -> {
				 repository.deleteById(id);
				 return ResponseEntity.ok().build();
	 }).orElse(ResponseEntity.notFound().build());
	 }

	
	
	
	
}
