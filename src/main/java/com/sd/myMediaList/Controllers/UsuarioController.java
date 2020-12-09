package com.sd.myMediaList.Controllers;

import java.util.List;

import com.sd.myMediaList.Services.CredentialServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sd.myMediaList.Models.Usuario;
import com.sd.myMediaList.Services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@Autowired
	private CredentialServiceAPI credentialService;
	
	@CrossOrigin
	@GetMapping()
	public @ResponseBody
	HttpEntity<List<Usuario>> findAll() {

		List<Usuario> usuario = service.findAll();

		if(usuario.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@GetMapping(value = "/{nome}")
	public @ResponseBody
	HttpEntity<Usuario> get(@PathVariable(name = "nome") String nome) {

		Usuario usuario = service.get(nome);
		return ResponseEntity.ok(usuario);
	}


	@CrossOrigin
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
		List<Usuario> usuario = service.findAll();
		return usuario.size();
	}

	@PostMapping
	public @ResponseBody
	HttpEntity<Usuario> create(@RequestBody Usuario usuario) {
		credentialService.create(usuario.getUsername(), usuario.getPassword(), "USER");
		return ResponseEntity.ok(usuario);
	}

//	@CrossOrigin
//	@PutMapping(value = "/{id}")
//	public void update(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
//
//		usuario.setId(id);
//		service.update(usuario);
//	}
	
//	@CrossOrigin
//	@DeleteMapping(value = "/{id}")
//	public void remove(@PathVariable(name = "id") Long id) {
//		service.remove(id);
//	}

	@DeleteMapping(value = "/{username}")
	public @ResponseBody
	HttpEntity<Usuario> remove(@PathVariable(name = "username") String username) {

		service.remove(username);
		return ResponseEntity.ok().build();
	}

}
