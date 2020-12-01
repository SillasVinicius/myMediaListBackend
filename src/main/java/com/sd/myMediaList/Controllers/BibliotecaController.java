package com.sd.myMediaList.Controllers;

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

import com.sd.myMediaList.Models.Biblioteca;
import com.sd.myMediaList.Services.BibliotecaService;

@RestController
@RequestMapping("biblioteca")
public class BibliotecaController {
	@Autowired
	private BibliotecaService service;
	
	@CrossOrigin
	@GetMapping()
	public @ResponseBody List<Biblioteca> findAll() {
		List<Biblioteca> biblioteca = service.findAll();
		return biblioteca;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
		List<Biblioteca> biblioteca = service.findAll();
		return biblioteca.size();
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public @ResponseBody Biblioteca get(@PathVariable(name = "id") Long id) {
		Biblioteca biblioteca = service.get(id);
		return biblioteca;
	}
	
	@CrossOrigin
	@PostMapping
	public @ResponseBody Biblioteca create(@RequestBody Biblioteca biblioteca) {

		biblioteca = service.save(biblioteca);
		return biblioteca;
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Biblioteca biblioteca) {

		biblioteca.setId(id);
		service.update(biblioteca);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
