package com.ceu.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceu.thymeleaf.model.User;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf");
		model.addAttribute("nombre", "Hola Angel");
		model.addAttribute("role", "admin");
		List<String> listaNombres = new ArrayList<>(Arrays.asList("Angel", "Pepe", "Maria", "Ana", "Paco", "Diego"));
		model.addAttribute("nombres", listaNombres);
		return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/form")
	public String form(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "result";
	}
}
