package com.mrBook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrBook.entity.Libro;
import com.mrBook.service.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {
	@Autowired
	private LibroService libroService;

	@GetMapping("/{id}")
	public ResponseEntity<Libro> findOne(@PathVariable int id) {
		Optional<Libro> libroO = this.libroService.findOne(id);
		if (libroO.isPresent()) {
			return ResponseEntity.ok(libroO.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Libro>> findAll() {
		return ResponseEntity.ok(libroService.findAll());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Libro> delete(@PathVariable int id) {
		Optional<Libro> libroO = this.libroService.findOne(id);
		if (libroO.isPresent()) {
			libroService.delete(id);
			return ResponseEntity.ok(libroO.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
