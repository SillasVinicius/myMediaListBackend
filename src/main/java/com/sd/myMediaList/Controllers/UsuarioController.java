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

import com.sd.myMediaList.Models.Usuario;
import com.sd.myMediaList.Services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@GetMapping()
	public @ResponseBody List<Usuario> findAll() {
		List<Usuario> usuario = service.findAll();
		return usuario;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Usuario get(@PathVariable(name = "id") Long id) {
		Usuario usuario = service.get(id);
		return usuario;
	}

	@PostMapping
	public @ResponseBody Usuario create(@RequestBody Usuario usuario) {

		usuario = service.save(usuario);
		return usuario;
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {

		usuario.setId(id);
		service.update(usuario);
	}

	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
