package com.sd.myMediaList.Repositiories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.myMediaList.Models.Media;

@Repository
public class MediaRepository {
	@Autowired
	private MediaRepositoryJPA repositoryJPA;
	
	public List<Media> findAll() {
		return repositoryJPA.findAll();
	}

	public Media findById(Long id) {
		return repositoryJPA.findById(id).get();
	}

	public Media save(Media media) {
		return repositoryJPA.save(media);
	}

	public void deleteById(Long id) {
		repositoryJPA.deleteById(id);
	}
}
