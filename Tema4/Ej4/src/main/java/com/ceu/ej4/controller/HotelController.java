package com.ceu.ej4.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej4.model.Hotel;
import com.ceu.ej4.service.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel nuevoHotel) {
		Hotel hotel = service.addHotel(nuevoHotel);
		
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels() {
		List<Hotel> listaHoteles = service.getHotels();
		
		if (listaHoteles == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaHoteles);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
		Hotel hotel = service.getHotelById(id);
		
		return ResponseEntity.ok(hotel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateHotelByid(@PathVariable int id, @RequestBody Hotel updatedHotel) {
		updatedHotel.setId(id);
		service.updateHotelByid(updatedHotel);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable int id) {
		service.deleteHotelById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/estrellas/{eMin}/{eMax}")
	public ResponseEntity<List<Hotel>> getHotelesByEstrellas(@PathVariable int eMin, @PathVariable int eMax) {
		List<Hotel> listaHoteles = service.getHotelesByEstrellas(eMin, eMax);
		
		if (listaHoteles == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(listaHoteles);
		}
	}
	
	@GetMapping("/telefono/{telefono}")
	public ResponseEntity<Optional<Hotel>> getHotelByTelefono(@PathVariable String telefono) {
		Optional<Hotel> hotel = service.getHotelByTelefono(telefono);
		
		return ResponseEntity.ok(hotel);
	}
	
	@DeleteMapping("/nombre/{nombre}")
	public ResponseEntity<Void> deleteHotelByName(@PathVariable String nombre) {
		service.deleteHotelByName(nombre);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/lista")
	public ResponseEntity<List<Hotel>> addListaHoteles(@RequestBody List<Hotel> listaHoteles) {
		List<Hotel> listaH = service.addListaHoteles(listaHoteles);
		
		if (listaH == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(listaH);
	}
}
