package com.ceu.ej8.service;

import java.util.List;
import java.util.Optional;

import com.ceu.ej8.model.Perfil;
import com.ceu.ej8.model.Usuario;

public interface UsuarioService {

	List<Usuario> getUsuarios();

	Usuario getUsuarioById(int id);

	void addUsuario(Usuario usuario);

	void updateUsuario(Usuario updatedUsuario);

	void deleteUsuario(int id);

	void updatePerfil(int id, Usuario perfil);

	Perfil getPerfil(int id);

	void updateEstado(int id);

	List<Usuario> getUsuariosContainsEdad();

	Optional<Usuario> getFirstDisponible();

	List<Usuario> getNoDisponibles();

	void updateAllToDisponible();

}
