package com.ceu.ej8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej8.model.Perfil;
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

	@Override
	@Transactional
	public void updatePerfil(int id, Usuario perfil) {
		Usuario usuario = getUsuarioById(id);
		
		if (usuario != null && perfil != null) {
			if (perfil.getPerfil().getBio() != null) {
				usuario.getPerfil().setBio(perfil.getPerfil().getBio());
			}
			
			if (perfil.getPerfil().getEstado() != null) {
				usuario.getPerfil().setEstado(perfil.getPerfil().getEstado());
			}
			
			repository.updateUsuario(usuario);
		}
	}

	@Override
	public Perfil getPerfil(int id) {
		return repository.getPerfil(id);
	}

	@Override
	@Transactional
	public void updateEstado(int id) {
		Usuario usuario = getUsuarioById(id);
		
		if (usuario != null) {
			if (usuario.getPerfil().getEstado() != "DISPONIBLE") {
				usuario.getPerfil().setEstado("DISPONIBLE");
			}
			
			repository.updateUsuario(usuario);
		}
	}

	@Override
	public List<Usuario> getUsuariosContainsEdad() {
		return repository.getUsuariosContainsEdad();
	}

	@Override
	public Optional<Usuario> getFirstDisponible() {
		Optional<Usuario> usuario = getUsuarios().stream()
				.filter(x -> x.getPerfil().getEstado().equals("DISPONIBLE")).findFirst();
		
		return usuario;
	}

	@Override
	public List<Usuario> getNoDisponibles() {
		List<Usuario> listaUsuarios = getUsuarios().stream()
				.filter(x -> x.getPerfil().getEstado().equals("NO DISPONIBLE")).toList();
		
		return listaUsuarios;
	}

	@Override
	public void updateAllToDisponible() {
		List<Usuario> listaUsuarios = getUsuarios().stream()
				.filter(x -> x.getPerfil().getEstado().equals("DISPONIBLE")).toList();
		
		for (Usuario usuario : listaUsuarios) {
			usuario.getPerfil().setEstado("NO DISPONIBLE");
		}
	}
}
