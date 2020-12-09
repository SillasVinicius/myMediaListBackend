package com.sd.myMediaList.Repositiories;

import com.sd.myMediaList.Models.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AuthorityRepository {
	@Autowired
	private AuthorityRepositoryJPA repositoryJPA;
	
	public List<Authority> findAll() {
		return repositoryJPA.findAll();
	}

	/*
	public Authority findById(Long id) {
		return repositoryJPA.findById(id).get();
	}*/

	public Authority save(Authority authority) {
		return repositoryJPA.save(authority);
	}

	/*
	public void deleteById(Long id) {
		repositoryJPA.deleteById(id);
	}*/
}
