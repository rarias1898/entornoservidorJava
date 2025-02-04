package com.ceu.ej5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ceu.ej5.model.Cliente;
import com.ceu.ej5.service.ClienteService;

@Controller
public class ViewController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/clientes")
	public String index(Model model) {
		List<Cliente> listaClientes = service.getClientes();
		model.addAttribute("listaClientes", listaClientes);
		return "index";
	}
	
	@GetMapping("/detalles/{id}")
	public String detalles(Model model, @PathVariable int id) {
		Cliente cliente = service.getCliente(id);
		model.addAttribute("cliente", cliente);
		return "cliente-detalle";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "nuevo";
	}
	
	@PostMapping("/nuevo")
	public String nuevo(@ModelAttribute Cliente cliente, Model model) {
		service.addCliente(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/ciudad")
	public String ciudad(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "ciudad";
	}
	
	@PostMapping("/ciudad")
	public String ciudad1(@ModelAttribute Cliente cliente, Model model) {
		model.addAttribute("clientes", service.getClientesByCiudad(cliente.getDireccion().getCiudad()));
		return "/ciudad";
	}
}
