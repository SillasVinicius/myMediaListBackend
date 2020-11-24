package com.sd.myMediaList.Repositiories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.myMediaList.Models.Tipo;

@Repository
public class TipoRepository {
	@Autowired
	private TipoRepositoryJPA repositoryJPA;

	public List<Tipo> findAll() {
		return repositoryJPA.findAll();
	}

	public Tipo findById(Long id) {
		return repositoryJPA.findById(id).get();
	}

	public Tipo save(Tipo tipo) {
		return repositoryJPA.save(tipo);
	}

	public void deleteById(Long id) {
		repositoryJPA.deleteById(id);
	}
}
