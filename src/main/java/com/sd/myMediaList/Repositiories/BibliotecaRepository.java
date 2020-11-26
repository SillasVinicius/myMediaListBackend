package com.sd.myMediaList.Repositiories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.myMediaList.Models.Biblioteca;


@Repository
public class BibliotecaRepository {
	@Autowired
	private BibliotecaRepositoryJPA repositoryJPA;
	
	public List<Biblioteca> findAll() {
		return repositoryJPA.findAll();
	}

	public Biblioteca findById(Long id) {
		return repositoryJPA.findById(id).get();
	}

	public Biblioteca save(Biblioteca biblioteca) {
		return repositoryJPA.save(biblioteca);
	}

	public void deleteById(Long id) {
		repositoryJPA.deleteById(id);
	}
}
