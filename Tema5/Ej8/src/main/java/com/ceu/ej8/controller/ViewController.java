package com.ceu.ej8.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceu.ej8.model.Usuario;
import com.ceu.ej8.service.UsuarioService;

@Controller
public class ViewController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String verUsuarios(Model model) {
		model.addAttribute("usuarios", service.getUsuarios());
		return "usuarios";
	}
	
	@GetMapping("/nuevo")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario-form";
	}
	
	@PostMapping("/nuevo")
	public String nuevoUsuario(@ModelAttribute Usuario usuario, Model model) {
		service.addUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/primer")
	public String primerUsuarioDisponible(Model model) { 
		model.addAttribute("usuario", service.getFirstDisponible());
		return "primerUsuario";
	}
	
	@GetMapping("/nuevo/{id}")
	public String verUsuario(Model model, @PathVariable int id) {
		model.addAttribute("usuario", service.getUsuarioById(id));
		return "usuario-form";
	}
}
