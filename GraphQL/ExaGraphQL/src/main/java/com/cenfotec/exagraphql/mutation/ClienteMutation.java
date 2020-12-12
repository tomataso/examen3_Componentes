package com.cenfotec.exagraphql.mutation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.exagraphql.entities.Cliente;
import com.cenfotec.exagraphql.services.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class ClienteMutation implements GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;

	public Cliente createVehicle(String nombre, String apellidos, String domicilio, String dirCobro, String tarjeta, String mes, String anno) {
		return this.clienteService.createCliente(nombre, apellidos, domicilio, dirCobro, tarjeta, mes, anno);
	}
	
	public boolean deleteVehicle(int id) {
		return this.clienteService.deleteCliente(id));
	}

}
