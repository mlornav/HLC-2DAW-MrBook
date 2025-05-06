package com.mrBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrBook.entity.Reserva;
import com.mrBook.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;

	public Optional<Reserva> findOne(int id) {
		return this.reservaRepository.findById(id);
	}
	
	public List<Reserva> findAll() {
		return this.reservaRepository.findAll();
	}
	
	public void create (Reserva reserva) {
		//TODO:Usuario Logueado
		//reserva.setUsuarioReserva(null);
		this.reservaRepository.save(reserva);
	}
	
	public boolean finalizarReserva (int id) {
		boolean res = false;
		Optional<Reserva> reservaO = this.findOne(id);
		
		if (reservaO.isPresent()) {
			reservaO.get().setReservaFinalizada(true);
			this.reservaRepository.save(reservaO.get());
			res = true;
		}

		return res;
	}
	
	public boolean delete (int id) {
		boolean res = false;
		Optional<Reserva> reservaO = this.findOne(id);
		
		if (reservaO.isPresent()) {
			this.reservaRepository.delete(reservaO.get());
			res = true;
		}

		return res;
	}
}
