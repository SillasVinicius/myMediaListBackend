package com.sd.myMediaList.Repositiories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.myMediaList.Models.Usuario;

@Repository
public class UsuarioRepository {
	@Autowired
	private UsuarioRepositoryJPA repositoryJPA;

	public List<Usuario> findAll() {
		return repositoryJPA.findAll();
	}

	public Usuario findById(String username) {
		return repositoryJPA.findById(username).get();
	}

	public Usuario save(Usuario usuario) {
		return repositoryJPA.save(usuario);
	}

	public void deleteById(String username) {
		repositoryJPA.deleteById(username);
	}
}
