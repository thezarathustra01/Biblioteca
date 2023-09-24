package com.example.biblioteca.controller;

import com.example.biblioteca.model.*;
import com.example.biblioteca.exception.*;
import com.example.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/")
public class BibliotecaController {
 @Autowired
 LibroRepository libroRepository;
 @Autowired
 AutoreRepository autoreRepository;
 	//Get All Libri
	@GetMapping("/libri")
	public List<Libro> getLibri() {
		return libroRepository.findAll();
	}
	//Get All Autore
	@GetMapping("/autori")
	public List<Autore> getAutori() {
		return autoreRepository.findAll();
	}
	// Create a new Libro
	@PostMapping("/libri")
	public Libro createLibro(@Valid @RequestBody Libro libro) {
		return libroRepository.save(libro);
	}
	// Create a new Autore
	@PostMapping("/autori")
	public Autore createAutore(@Valid @RequestBody Autore autore) {
		return autoreRepository.save(autore);
	}
	// Get a Single Libro
	@GetMapping("/libri/{id}")
	public Libro getLibroById(@PathVariable(value = "id") Long libroId) {
		return libroRepository.findById(libroId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", libroId));
	}
	// Get a Single Autore
	@GetMapping("/autori/{id}")
	public Autore getAutoreById(@PathVariable(value = "id") Long autoreId) {
		 return autoreRepository.findById(autoreId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", autoreId));
	}
	// Update a Libro
	@PutMapping("/libri/{id}")
	public Libro updateLibro(@PathVariable(value = "id") Long libroId, @Valid @RequestBody Libro libroDetails) {
		Libro libro= libroRepository.findById(libroId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", libroId));
	 	libro.setTitolo(libroDetails.getTitolo());
	 	libro.setPrezzo(libroDetails.getPrezzo());
	 	Libro updatedNote = libroRepository.save(libro);
	 	return updatedNote;
	}
	// Update a Autore
	@PutMapping("/autori/{id}")
	public Autore updateAutore(@PathVariable(value = "id") Long autoreId, @Valid @RequestBody Autore autoreDetails) {
		Autore autore= autoreRepository.findById(autoreId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", autoreId));
		autore.setNomeecog(autoreDetails.getNomeecog());
		autore.setLuogonascita(autoreDetails.getLuogonascita());
		Autore updatedNote = autoreRepository.save(autore);
		return updatedNote;
	}
	// Delete a Libro
	@DeleteMapping("/libri/{id}")
	public ResponseEntity<?> deleteLibro(@PathVariable(value = "id") Long libroId) {
		Libro libro = libroRepository.findById(libroId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", libroId));
		libroRepository.delete(libro);
		return ResponseEntity.ok().build();
	}
	// Delete a Autore
		@DeleteMapping("/autori/{id}")
		public ResponseEntity<?> deleteAutore(@PathVariable(value = "id") Long autoreId) {
			Autore autore = autoreRepository.findById(autoreId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", autoreId));
			autoreRepository.delete(autore);
			return ResponseEntity.ok().build();
		}
}
