package com.cenfotec.exagraphql.query;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.exagraphql.entities.Cliente;
import com.cenfotec.exagraphql.services.ClienteService;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class ClienteQuery implements GraphQLQueryResolver {

	@Autowired
	private ClienteService clienteService;

	public List<Cliente> getVehicles(int count) {
		return this.clienteService.getAllClientes(count);
		
	
	}

	public Optional<Cliente> getVehicle(int id) {
		return this.clienteService.getCliente(id);
		
	}

}