package com.ej9_11.controller;

import com.ej9_11.model.Alumnos;
import com.ej9_11.model.Direccion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class AlumnoController {

    private List<Alumnos> alumnos = new ArrayList<>();

    public AlumnoController() {
        Alumnos a1 = new Alumnos(1, "Angel", "rarias1898@ceuandalucia.es", 28, "Segundo DAW", new Direccion("guadiamar", "41930", "Sevilla"));
        Alumnos a2 = new Alumnos(2, "Pablo", "pablo@ceuandalucia.es", 27, "Primero DAW", new Direccion("guadiamar", "41930", "Huelva"));
        Alumnos a3 = new Alumnos(3, "Raul", "raul@ceuandalucia.es", 28, "Segundo DAM", new Direccion("guadiamar", "41930", "Cadiz"));
        Alumnos a4 = new Alumnos(4, "Rafa", "rafa@ceuandalucia.es", 22, "Primero DAM", new Direccion("guadiamar", "41940", "Sevilla"));

        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a3);
        alumnos.add(a4);
    }

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumnos>> getAlumnos() {

        if (alumnos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/alumnos/{email}")
    public ResponseEntity<Alumnos> getAlumno(@PathVariable String email) {

        for (Alumnos alumno : alumnos) {
            if (alumno.getEmail().equalsIgnoreCase(email)){
                return ResponseEntity.ok(alumno);
            }
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/alumnos/create")
    public ResponseEntity<String> createAlumno(@RequestBody Alumnos newAlumno) {

        for (Alumnos alumno : alumnos) {
            if (alumno.getId() == newAlumno.getId()) {
                return ResponseEntity.badRequest().body("El id ya está en uso");
            }

            alumnos.add(newAlumno);
            return ResponseEntity.ok("Alumno Añadido correctamente");
        }

        return null;
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<String> updateAlumno(@PathVariable int id, @RequestBody Alumnos updatedAlumno) {

        for (Alumnos alumno : alumnos) {
            if (alumno.getId() == id){
                alumno.setNombre(updatedAlumno.getNombre());
                alumno.setEmail(updatedAlumno.getEmail());
                alumno.setEdad(updatedAlumno.getEdad());
                alumno.setCurso(updatedAlumno.getCurso());
                alumno.setDireccion(updatedAlumno.getDireccion());
                
                //Direccion nuevaDireccion = updatedAlumno.getDireccion();
                //alumno.setDireccion(nuevaDireccion);


                return ResponseEntity.ok("Alumno modificado correctamente");
            }
        }


        return ResponseEntity.notFound().build();
    }
    
    @PatchMapping("/alumnos/{id}")
    public ResponseEntity<Void> updateSAlumno(@PathVariable int id, @RequestBody Alumnos updatedAlumno) {
    	for (Alumnos alumno : alumnos) {
    		if (alumno.getId() == id) {
    			if (updatedAlumno.getNombre() != null) {
    				alumno.setNombre(updatedAlumno.getNombre());
    			}
    			if (updatedAlumno.getEmail() != null) {
    				alumno.setEmail(updatedAlumno.getEmail());
    			}
    			if (updatedAlumno.getCurso() != null) {
    				alumno.setCurso(updatedAlumno.getCurso());
    			}
    			if (updatedAlumno.getEdad() != 0) {
    				alumno.setEdad(updatedAlumno.getEdad());
    			}
    			if(updatedAlumno.getDireccion() != null) {
    				alumno.setDireccion(updatedAlumno.getDireccion());
    			}
    			
    			return ResponseEntity.noContent().build();
    		}
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable int id) {

        for (Alumnos alumno : alumnos ){
        	Iterator<Alumnos> iterador = alumnos.iterator();
    		while (iterador.hasNext()) {
    			Alumnos alumnos = iterador.next();
    			if (alumno.getId() == id) {
    				iterador.remove();
    				return ResponseEntity.ok("Alumno borrado");
    			}
    		}
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/alumnos/direcciones")
    public ResponseEntity<List<Direccion>> getDirecciones() {

        List<Direccion> direccion = new ArrayList<>();
        for (Alumnos alumno : alumnos) {
            direccion.add(alumno.getDireccion());
        }

        return ResponseEntity.ok(direccion);
    }

    @GetMapping("/alumnos/direcciones/{codPostal}")
    public ResponseEntity<List<Direccion>> getDireccionesCodPostal(@PathVariable String codPostal) {

        List<Direccion> direccion = new ArrayList<>();
        for (Alumnos alumno : alumnos) {
            if (alumno.getDireccion().getCodPostal().equalsIgnoreCase(codPostal)) {
                direccion.add(alumno.getDireccion());
            }
        }

        return ResponseEntity.ok(direccion);
    }

    @GetMapping("/alumnos/direcciones-ciudad/{ciudad}")
    public ResponseEntity<Integer> getDireccionesCiudad(@PathVariable String ciudad) {

        List<Direccion> direccion = new ArrayList<>();
        for (Alumnos alumno : alumnos) {
            if (alumno.getDireccion() != null && alumno.getDireccion().getCiudad() != null) {
                if (alumno.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
                    direccion.add(alumno.getDireccion());
                }
            }
        }

        if (direccion.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(direccion.size());
    }
}
