package com.ej1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {
	
	@GetMapping("/validar-palabra/{palindromo}")
	public String validarPalindromo(@PathVariable String palindromo) {

		String palabra = palindromo.toLowerCase();
		String mensaje;

		if (esPalindromo(palabra)) {
			mensaje = "La palabra " + palabra + " es un palindromo";
		} else {
			mensaje = "La palabra " + palabra + " NO es un palindromo";
		}

		return mensaje;
	}

	private boolean esPalindromo(String palabra) {
		int longitud = palabra.length();

		for (int i = 0; i < longitud / 2; i++) {
			if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
