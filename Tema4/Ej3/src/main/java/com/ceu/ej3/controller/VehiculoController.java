package com.ceu.ej3.controller;

import com.ceu.ej3.model.Vehiculo;
import com.ceu.ej3.service.VehiculoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @PostMapping
    public ResponseEntity<Vehiculo> addVehiculo(@RequestBody Vehiculo vehiculo) {
        service.addVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable int id) {
        Vehiculo v1 = service.getVehiculoById(id);
        return ResponseEntity.ok(v1);
    }
    
    @GetMapping
    public ResponseEntity<List<Vehiculo>> getVehiculos() {
    	List<Vehiculo> v1 = service.getVehiculos();
    	return ResponseEntity.ok(v1);
    }
    
    @PutMapping
    public ResponseEntity<Void> updateVehiculo(@RequestBody Vehiculo updatedVehiculo) {
    	service.updateVehiculo(updatedVehiculo);
    	return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable int id) {
    	service.deleteVehiculo(id);
    	return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/update-estado/{id}")
    public ResponseEntity<Vehiculo> updateEstado(@PathVariable int id, @RequestBody Vehiculo updatedVehiculo) {
    	Vehiculo vehiculo = service.updateEstado(id, updatedVehiculo);
    	return ResponseEntity.ok(vehiculo);
    }
    
    @PatchMapping("/update-km/{id}")
    public ResponseEntity<Vehiculo> updateKm(@PathVariable int id, @RequestBody Vehiculo updateVehiculo) {
    	Vehiculo vehiculo = service.updateKm(id, updateVehiculo);
    	return ResponseEntity.ok(vehiculo);
    }
    
    @GetMapping("/by-estado/{estado}")
    public ResponseEntity<List<Vehiculo>> getVehiculosByEstado(@PathVariable String estado) {
    	List<Vehiculo> v1 = service.getVehiculosByEstado(estado);
    	return ResponseEntity.ok(v1);
    }
    
    @GetMapping("/by-anyo/{anyoInicio}/{anyoFin}")
    public ResponseEntity<List<Vehiculo>> getVehiculosByYear(@PathVariable int anyoInicio, @PathVariable int anyoFin) {
    	List<Vehiculo> v1 = service.getVehiculosByYear(anyoInicio, anyoFin);
    	return ResponseEntity.ok(v1);
    }
}
