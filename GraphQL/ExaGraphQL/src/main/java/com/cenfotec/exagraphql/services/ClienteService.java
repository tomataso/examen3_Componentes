package com.cenfotec.exagraphql.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.exagraphq.entities.Cliente;
import com.cenfotec.exagraphql.repositories.ClienteRepository;


@Service
public class ClienteService {
	
	
	@Autowired
	ClienteRepository clienteRepo;

	public List<Cliente> getAllClientes(int count) {
		return this.clienteRepo.findAll().stream().limit(count).collect(Collectors.toList());
	}

	public Optional<Cliente> getCliente(int id) {
		return this.clienteRepo.findById(id);
	}

	public Cliente createCliente(String nombre, String apellidos, String domicilio, String dirCobro, String tarjeta, String mes , String anno ) {
		
		Cliente cliente = new Cliente();
		
		
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setDomicilio(domicilio);
		cliente.setDirCobro(dirCobro);
		cliente.setTarjeta(tarjeta);
		cliente.setMes(mes);
		cliente.setAnno(anno);
		

		return this.clienteRepo.save(cliente);
	}
	
	
	public boolean deleteCliente(int id) {
		this.clienteRepo.deleteById(id);
		return true;
	}

	

}
