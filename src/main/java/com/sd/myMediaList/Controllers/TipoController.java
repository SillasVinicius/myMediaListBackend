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

import com.sd.myMediaList.Models.Tipo;
import com.sd.myMediaList.Services.TipoService;

@RestController
@RequestMapping("tipo")
public class TipoController {
	@Autowired
	private TipoService service;
	
	@CrossOrigin
	@GetMapping()
	public @ResponseBody List<Tipo> findAll() {
		List<Tipo> tipo = service.findAll();
		return tipo;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
		List<Tipo> tipo = service.findAll();
		return tipo.size();
	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public @ResponseBody Tipo get(@PathVariable(name = "id") Long id) {
		Tipo tipo = service.get(id);
		return tipo;
	}
	
	@CrossOrigin
	@PostMapping
	public @ResponseBody Tipo create(@RequestBody Tipo tipo) {

		tipo = service.save(tipo);
		return tipo;
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Tipo tipo) {

		tipo.setId(id);
		service.update(tipo);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
