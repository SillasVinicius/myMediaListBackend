package com.sd.myMediaList.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.BibliotecaNotFoundException;
import com.sd.myMediaList.Models.Biblioteca;
import com.sd.myMediaList.Repositiories.BibliotecaRepository;

@Service
public class BibliotecaService {
	@Autowired
	private BibliotecaRepository repository;
	
	@Transactional(readOnly = true)
	public List<Biblioteca> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Biblioteca get(Long id) {
		try {
			Biblioteca biblioteca = repository.findById(id);
			return biblioteca;
		} catch (Exception ex) {
			throw new BibliotecaNotFoundException(String.format("Biblioteca não existe com esse id: %s ", id));
		}
	}

	@Transactional
	public Biblioteca save(Biblioteca biblioteca) {
		return repository.save(biblioteca);
	}

	@Transactional
	public Biblioteca update(Biblioteca biblioteca) {
		return repository.save(biblioteca);
	}

	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}
}
