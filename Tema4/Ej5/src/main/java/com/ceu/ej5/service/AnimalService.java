package com.ceu.ej5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej5.model.Animal;
import com.ceu.ej5.repository.AnimalRepository;

import jakarta.transaction.Transactional;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	@Transactional
	public Animal addAnimal(Animal newAnimal) {
		return repository.addAnimal(newAnimal);
	}

	public List<Animal> getAnimales() {
		return repository.getAnimales();
	}

	public Animal getAnimalById(int id) {
		return repository.getAnimalById(id);
	}

	@Transactional
	public void updateAnimal(Animal updatedAnimal) {
		repository.updateAnimal(updatedAnimal);
	}

	@Transactional
	public void deleteAnimal(int id) {
		Animal animal = getAnimalById(id);
		
		if (animal != null) {
			repository.deleteAnimal(animal);
		}
	}

	public List<Animal> getAnimalesByEspecie(String especie) {
		return repository.getAnimalesByEspecie(especie);
	}

	public List<Animal> getAnimalesByEdad(int edad) {
	    return repository.getAnimalesByEdad(edad);
	}

	public List<Animal> getAnimalesRecientes(int anyo) {
		return repository.getAnimalesRecientes(anyo);
	}
}
