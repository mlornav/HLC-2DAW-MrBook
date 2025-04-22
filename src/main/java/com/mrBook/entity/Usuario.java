package com.mrBook.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends Actor{

	@OneToMany
	private List<Reserva> reservas;
	
	public Usuario() {
		super();
	}	
}
