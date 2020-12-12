package com.cenfotec.examentres.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Producto {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 private String nombreP;
	 private int precio;
	 
		@ManyToOne
	    @JoinColumn(name="orden_id", nullable=false)
		private Orden Orden;
	 // -----------------------------------------------------------
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Orden getOrden() {
		return Orden;
	}
	public void setOrden(Orden orden) {
		Orden = orden;
	}
	public Producto(Long id, String nombreP, int precio, com.cenfotec.examentres.model.Orden orden) {
		super();
		this.id = id;
		this.nombreP = nombreP;
		this.precio = precio;
		Orden = orden;
	}
	public Producto() {
		super();
	}

	 
	
}
