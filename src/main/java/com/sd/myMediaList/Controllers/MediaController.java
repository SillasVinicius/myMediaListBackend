package com.sd.myMediaList.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sd.myMediaList.Models.Media;
import com.sd.myMediaList.Services.MediaService;

@RestController
@RequestMapping("media")
public class MediaController {
	@Autowired
	private MediaService service;

	@GetMapping()
	public @ResponseBody List<Media> findAll() {
		List<Media> media = service.findAll();
		return media;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Media get(@PathVariable(name = "id") Long id) {
		Media media = service.get(id);
		return media;
	}

	@PostMapping
	public @ResponseBody Media create(@RequestBody Media media) {

		media = service.save(media);
		return media;
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Media media) {

		media.setId(id);
		service.update(media);
	}

	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
