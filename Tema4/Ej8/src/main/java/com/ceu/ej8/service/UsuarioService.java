package com.ceu.ej8.service;

import java.util.List;

import com.ceu.ej8.model.Usuario;

public interface UsuarioService {

	List<Usuario> getUsuarios();

	Usuario getUsuarioById(int id);

	void addUsuario(Usuario usuario);

	void updateUsuario(Usuario updatedUsuario);

	void deleteUsuario(int id);

}
