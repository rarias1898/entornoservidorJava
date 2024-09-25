package com.ej1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {

	@GetMapping("/validar-palabra/{palindromo}")
	public String validarPalindromo(@PathVariable String palindromo) {
		
		String palab = palindromo.substring(0, palindromo.length() -1);
		
		System.out.println(palab);
		
		
		return "Hola";
	}
}
