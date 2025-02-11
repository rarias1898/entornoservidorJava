package com.ceu.ej10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceu.ej10.model.Empleado;
import com.ceu.ej10.service.EmpleadoService;
import com.ceu.ej10.service.OficinaService;

@Controller
public class ViewController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private OficinaService oficinaService;

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/empleados")
	public String listaEmpeados(Model model) {
		model.addAttribute("empleados", empleadoService.getEmpleados());
		return "lista";
	}
	
	@GetMapping("/add")
	public String addEmpleado(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "empleado-form";
	}
	
	@PostMapping("/add")
	public String addEmpleado(Model model, @ModelAttribute Empleado empleado) {
		empleadoService.addEmpleado(empleado);
		return "redirect:/empleados";
	}
	
	// Oficinas
	@GetMapping("/oficinas")
	public String listaOficinas(Model model) {
		model.addAttribute("oficinas", oficinaService.getOficinas());
		return "oficinas-lista";
	}
}
