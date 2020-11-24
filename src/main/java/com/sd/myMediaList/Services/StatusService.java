package com.sd.myMediaList.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.StatusNotFoundException;
import com.sd.myMediaList.Models.Status;
import com.sd.myMediaList.Repositiories.StatusRepository;

@Service
public class StatusService {
	@Autowired
	private StatusRepository repository;

	@Transactional(readOnly = true)
	public List<Status> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Status get(Long id) {
		try {
			Status status = repository.findById(id);
			return status;
		} catch (Exception ex) {
			throw new StatusNotFoundException(String.format("Status não existe com esse id: %s ", id));
		}
	}

	@Transactional
	public Status save(Status status) {
		return repository.save(status);
	}

	@Transactional
	public Status update(Status status) {
		return repository.save(status);
	}

	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}
}
