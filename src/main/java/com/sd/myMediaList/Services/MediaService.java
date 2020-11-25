package com.sd.myMediaList.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.myMediaList.Exceptions.MediaNotFoundException;
import com.sd.myMediaList.Models.Media;
import com.sd.myMediaList.Repositiories.MediaRepository;

@Service
public class MediaService {
	@Autowired
	private MediaRepository repository;
	
	@Transactional(readOnly = true)
	public List<Media> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Media get(Long id) {
		try {
			Media media = repository.findById(id);
			return media;
		} catch (Exception ex) {
			throw new MediaNotFoundException(String.format("Media não existe com esse id: %s ", id));
		}
	}

	@Transactional
	public Media save(Media media) {
		return repository.save(media);
	}

	@Transactional
	public Media update(Media media) {
		return repository.save(media);
	}

	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}
}
