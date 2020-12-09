package com.sd.myMediaList.Services;

import java.util.List;

import com.sd.myMediaList.Repositiories.AuthorityRepositoryJPA;
import com.sd.myMediaList.Repositiories.UsuarioRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.UsuarioNotFoundException;
import com.sd.myMediaList.Models.Usuario;

@Service
public class UsuarioService {
	//@Autowired
	//private UsuarioRepository repository;

	@Autowired
	private UsuarioRepositoryJPA repositoryJPA;

	@Autowired
	private AuthorityRepositoryJPA authorityRepositoryJPA;


	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return repositoryJPA.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario get(String username) {
		try {
			Usuario usuario = repositoryJPA.findById(username).get();
			return usuario;
		} catch (Exception ex) {
			throw new UsuarioNotFoundException(String.format("Usuário não existe com esse id: %s ", username));
		}
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		return repositoryJPA.save(usuario);
	}

//	@Transactional
//	public Usuario update(Usuario usuario) {
//		return repository.save(usuario);
//	}

	@Transactional
	public void remove(String username) {

		authorityRepositoryJPA.deleteById(username);
		repositoryJPA.deleteById(username);
	}
}
