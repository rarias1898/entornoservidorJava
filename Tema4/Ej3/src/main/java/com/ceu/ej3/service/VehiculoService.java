package com.ceu.ej3.service;

import com.ceu.ej3.model.Vehiculo;

import com.ceu.ej3.repository.VehiculoRepository;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    @Transactional
    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        return repository.addVehiculo(vehiculo);
    }

    public Vehiculo getVehiculoById(int id) {
        return repository.getVehiculoById(id);
    }

	public List<Vehiculo> getVehiculos() {
		return repository.getVehiculos();
	}

	@Transactional
	public void updateVehiculo(Vehiculo updatedVehiculo) {
		repository.updateVehiculo(updatedVehiculo);	
	}

	@Transactional
	public void deleteVehiculo(int id) {
		repository.deleteVehiculo(id);
	}

	@Transactional
	public Vehiculo updateEstado(int id, Vehiculo updatedVehiculo) {
		return repository.updateEstado(id, updatedVehiculo);
	}

	@Transactional
	public Vehiculo updateKm(int id, Vehiculo updateVehiculo) {
		return repository.updateKm(id, updateVehiculo);
	}

	public List<Vehiculo> getVehiculosByEstado(String estado) {
		return repository.getVehiculosByEstado(estado);
	}

	public List<Vehiculo> getVehiculosByYear(int anyoInicio, int anyoFin) {
		return repository.getVehiculosByYear(anyoInicio, anyoFin);
	}
}
