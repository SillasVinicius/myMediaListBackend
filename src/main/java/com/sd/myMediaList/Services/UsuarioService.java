package com.sd.myMediaList.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.UsuarioNotFoundException;
import com.sd.myMediaList.Models.Usuario;
import com.sd.myMediaList.Repositiories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario get(Long id) {
		try {
			Usuario usuario = repository.findById(id);
			return usuario;
		} catch (Exception ex) {
			throw new UsuarioNotFoundException(String.format("Usuário não existe com esse id: %s ", id));
		}
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	@Transactional
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}
}
