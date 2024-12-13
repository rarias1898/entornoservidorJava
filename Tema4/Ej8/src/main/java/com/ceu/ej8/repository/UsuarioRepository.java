package com.ceu.ej8.repository;

import java.util.List;

import com.ceu.ej8.model.Usuario;

public interface UsuarioRepository {

	List<Usuario> getUsuarios();

	Usuario getUsuarioById(int id);

	void addUsuario(Usuario usuario);

	void updateUsuario(Usuario miUsuario);

	void deleteUsuario(Usuario usuario);

}
