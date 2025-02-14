package com.ceu.ej10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej10.model.Empleado;
import com.ceu.ej10.model.Oficina;
import com.ceu.ej10.service.EmpleadoService;
import com.ceu.ej10.service.OficinaService;

@SpringBootApplication
public class Ej10Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej10Application.class, args);
	}
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private OficinaService oficinaService;

	@Override
	public void run(String... args) throws Exception {
		Empleado empleado1 = new Empleado("Angel", "Desarrollador", "angel@angel.com");
		
		empleadoService.addEmpleado(empleado1);
		
		Oficina oficina1 = new Oficina("Calle1", "123456789");
		
		oficinaService.addOficina(oficina1);
		
		// empleado1.setOficina(oficina1);
		// System.out.println(empleado1);
	}

}
