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

import com.cenfotec.examentres.model.Orden;
import com.cenfotec.examentres.repository.OrdenRepository;

@RestController
@RequestMapping({"/ordenes"})
public class OrdenController {

		
	private OrdenRepository repository;

	OrdenController(OrdenRepository ordenRepository) {
		this.repository = ordenRepository;
	}
	

	
	@GetMapping
	public List findAll(){
	 return repository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Orden> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record ->
	ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Orden create(@RequestBody Orden orden){
	 return repository.save(orden);
	}

	@PutMapping(value="/{id}")
	 public ResponseEntity<Orden>
	update(@PathVariable("id") long id, @RequestBody Orden orden){
	 return repository.findById(id)
			 .map(record -> {
				 record.setCantidad(orden.getCantidad());
				 record.setImagen(orden.getImagen());
				 
				 // Revisar
				 record.setProductos(orden.getProductos());

				 Orden updated = repository.save(record);
				 return ResponseEntity.ok().body(updated);
				 
			 }).orElse(ResponseEntity.notFound().build());
	 }
	
	
	
	@DeleteMapping(path ={"/{id}"})
	 public ResponseEntity<?> delete(@PathVariable("id") long id) {
	 return repository.findById(id)
			 .map(record -> {
				 repository.deleteById(id);
				 return ResponseEntity.ok().build();
			 }).orElse(ResponseEntity.notFound().build());
	 }
	
}
