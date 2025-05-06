package com.mrBook.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reserva extends DomainEntity{
	@NotBlank
	private Date fechaInicio;
	
	@NotBlank
	private Date fechaFin;
	
	private boolean reservaFinalizada;
	
	@ManyToOne
	private Libro libroReservado;
	
	@NotNull
	private Usuario usuarioReserva;

	public Reserva() {
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isReservaFinalizada() {
		return reservaFinalizada;
	}

	public void setReservaFinalizada(boolean reservaFinalizada) {
		this.reservaFinalizada = reservaFinalizada;
	}

	public Libro getLibroReservado() {
		return libroReservado;
	}

	public void setLibroReservado(Libro libroReservado) {
		this.libroReservado = libroReservado;
	}

	public Usuario getUsuarioReserva() {
		return usuarioReserva;
	}

	public void setUsuarioReserva(Usuario usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}
}
