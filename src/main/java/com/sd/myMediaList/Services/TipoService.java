package com.sd.myMediaList.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.TipoNotFoundException;
import com.sd.myMediaList.Models.Tipo;
import com.sd.myMediaList.Repositiories.TipoRepository;

@Service
public class TipoService {
	@Autowired
	private TipoRepository repository;

	@Transactional(readOnly = true)
	public List<Tipo> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Tipo get(Long id) {
		try {
			Tipo tipo = repository.findById(id);
			return tipo;
		} catch (Exception ex) {
			throw new TipoNotFoundException(String.format("Tipo não existe com esse id: %s ", id));
		}
	}

	@Transactional
	public Tipo save(Tipo tipo) {
		return repository.save(tipo);
	}

	@Transactional
	public Tipo update(Tipo tipo) {
		return repository.save(tipo);
	}

	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}
}
