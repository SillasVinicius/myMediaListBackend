package com.sd.myMediaList.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sd.myMediaList.Models.Media;
import com.sd.myMediaList.Services.MediaService;

@RestController
@RequestMapping("media")
public class MediaController {
	@Autowired
	private MediaService service;
	
	@CrossOrigin
	@GetMapping()
	public @ResponseBody List<Media> findAll() {
		List<Media> media = service.findAll();
		return media;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
		List<Media> media = service.findAll();
		return media.size();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/Movie", method = RequestMethod.GET)
	public @ResponseBody List<Media> Movie() {

		List<Media> listaMedia = new ArrayList<Media>();

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Filme")) {
				listaMedia.add(m);
			}
		}

		return listaMedia;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/Serie", method = RequestMethod.GET)
	public @ResponseBody List<Media> Serie() {

		List<Media> listaMedia = new ArrayList<Media>();

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Série")) {
				listaMedia.add(m);
			}
		}

		return listaMedia;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/Book", method = RequestMethod.GET)
	public @ResponseBody List<Media> Book() {

		List<Media> listaMedia = new ArrayList<Media>();

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Livro")) {
				listaMedia.add(m);
			}
		}

		return listaMedia;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCountMovie", method = RequestMethod.GET)
	public @ResponseBody int getCountMovie() {

		int cont = 0;

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Filme")) {
				cont++;
			}
		}

		return cont;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCountSerie", method = RequestMethod.GET)
	public @ResponseBody int getCountSerie() {

		int cont = 0;

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Série")) {
				cont++;
			}
		}

		return cont;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCountBook", method = RequestMethod.GET)
	public @ResponseBody int getCountBook() {

		int cont = 0;

		List<Media> media = new ArrayList<Media>();

		Media[] mediaArray = new Media[media.size()];

		media = service.findAll();

		mediaArray = media.toArray(mediaArray);

		for (Media m : mediaArray) {
			String tipo = m.getTipo().getDescricao();
			if (tipo.equals("Livro")) {
				cont++;
			}
		}

		return cont;
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public @ResponseBody Media get(@PathVariable(name = "id") Long id) {
		Media media = service.get(id);
		return media;
	}
	
	@CrossOrigin
	@PostMapping
	public @ResponseBody Media create(@RequestBody Media media) {

		media = service.save(media);
		return media;
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Media media) {

		media.setId(id);
		service.update(media);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
