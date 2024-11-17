package com.ceu.ej4.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej4.model.Hotel;
import com.ceu.ej4.repository.HotelRepository;

import jakarta.transaction.Transactional;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repository;

	@Transactional
	public Hotel addHotel(Hotel nuevoHotel) {
		return repository.addHotel(nuevoHotel);
	}

	public List<Hotel> getHotels() {
		return repository.getHotels();
	}

	public Hotel getHotelById(int id) {
		return repository.getHotelById(id);
	}

	@Transactional
	public void updateHotelByid(Hotel updatedHotel) {
		repository.getHotelById(updatedHotel.getId());
		
		repository.updateHotelByid(updatedHotel);
	}

	@Transactional
	public void deleteHotelById(int id) {
		Hotel hotel = getHotelById(id);
		
		if (hotel != null) {
			repository.deleteHotelById(hotel);			
		}
	}

	public List<Hotel> getHotelesByEstrellas(int eMin, int eMax) {
		return repository.getHotelesByEstrellas(eMin, eMax);
	}

	public Optional<Hotel> getHotelByTelefono(String telefono) {
		return getHotels().stream()
				.filter(h -> h.getTelefono().contains(telefono))
				.findFirst();
	}

	@Transactional
	public void deleteHotelByName(String nombre) {
		List<Hotel> listaHoteles = getHotels();
		
		for(Hotel hotel : listaHoteles) {
			if (hotel.getNombre().contains(nombre)) {
				deleteHotelById(hotel.getId());
			}
		}
	}

	@Transactional
	public List<Hotel> addListaHoteles(List<Hotel> listaHoteles) {
		List<Hotel> misHoteles = getHotels();
		Set<String> nombres = misHoteles.stream()
				.map(x -> x.getNombre())
				.collect(Collectors.toSet());
		
		for (Hotel hotel : listaHoteles) {
			if (nombres.contains(hotel.getNombre())) {
				return null;
			}else {
				addHotel(hotel);
			}
		}
		return listaHoteles;
	}
}
