package com.sd.myMediaList.Repositiories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.myMediaList.Models.Status;


@Repository
public class StatusRepository {
	
	@Autowired
	private StatusRepositoryJPA repositoryJPA;
	
	public List<Status> findAll() {
		return repositoryJPA.findAll();
	}

	public Status findById(Long id) {
		return repositoryJPA.findById(id).get();
	}

	public Status save(Status status) {
		return repositoryJPA.save(status);
	}

	public void deleteById(Long id) {
		repositoryJPA.deleteById(id);
	}
	
}
