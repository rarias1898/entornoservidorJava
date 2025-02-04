package com.ceu.ej8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
