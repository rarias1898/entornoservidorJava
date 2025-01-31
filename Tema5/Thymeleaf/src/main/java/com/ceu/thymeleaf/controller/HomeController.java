package com.ceu.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf");
		model.addAttribute("nombre", "Hola Angel");
		model.addAttribute("role", "admin");
		List<String> listaNombres = new ArrayList<>(Arrays.asList("Angel", "Pepe", "Maria", "Ana", "Paco"));
		model.addAttribute("nombres", listaNombres);
		return "home";
	}
	
	@GetMapping("/index.html")
	public String index() {
		return "index";
	}
	
	@GetMapping("/form.html")
	public String form() {
		return "form";
	}
}
