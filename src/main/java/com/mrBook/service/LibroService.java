package com.mrBook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrBook.entity.Libro;
import com.mrBook.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
public class LibroService {
	@Autowired
	private LibroRepository libroRepository;

	@Transactional
	public Optional<Libro> findOne(int id) {
		return this.libroRepository.findById(id);
	}

	@Transactional
	public List<Libro> findAll() {
		return this.libroRepository.findAll();
	}

	@Transactional
	public void create(Libro libro) {
		this.libroRepository.save(libro);
	}

	@Transactional
	public boolean update(Libro libro, int id) {
		Optional<Libro> libroBD = this.findOne(id);
		boolean res = false;

		if (libroBD.isPresent()) {
			Libro l = libroBD.get();
			l.setAutor(libro.getAutor());
			l.setCantidad(libro.getCantidad());
			l.setGenero(libro.getGenero());
			l.setIsbn(libro.getIsbn());
			l.setTitulo(libro.getTitulo());

			this.libroRepository.save(l);
			res = true;
		}
		return res;
	}

	@Transactional
	public boolean delete(int id) {
		boolean res = false;
		Optional<Libro> libroO = this.findOne(id);
		
		if (libroO.isPresent()) {
			this.libroRepository.delete(libroO.get());
			res = true;
		}

		return res;
	}

}
