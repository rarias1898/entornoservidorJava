package com.ceu.ej8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej8.model.Usuario;
import com.ceu.ej8.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> getUsuarios() {
		return repository.getUsuarios();
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return repository.getUsuarioById(id);
	}

	@Override
	@Transactional
	public void addUsuario(Usuario usuario) {
		repository.addUsuario(usuario);
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario updatedUsuario) {
		Usuario miUsuario = getUsuarioById(updatedUsuario.getId());
		
		if (updatedUsuario.getNombre() != null) {
			miUsuario.setNombre(updatedUsuario.getNombre());
		}
		
		if (updatedUsuario.getEmail() != null) {
			miUsuario.setEmail(updatedUsuario.getEmail());
		}
		
		if (updatedUsuario.getPerfil().getBio() != null) {
			miUsuario.getPerfil().setBio(updatedUsuario.getPerfil().getBio());
		}
		
		if (updatedUsuario.getPerfil().getEstado() != null) {
			miUsuario.getPerfil().setEstado(updatedUsuario.getPerfil().getEstado());
		}
		
		repository.updateUsuario(updatedUsuario);
	}

	@Override
	@Transactional
	public void deleteUsuario(int id) {
		Usuario usuario = getUsuarioById(id);
		
		repository.deleteUsuario(usuario);
	}
}
