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

import com.sd.myMediaList.Models.Status;
import com.sd.myMediaList.Services.StatusService;

@RestController
@RequestMapping("status")
public class StatusController {
	@Autowired
	private StatusService service;

	@GetMapping()
	public @ResponseBody List<Status> findAll() {
		List<Status> status = service.findAll();
		return status;
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Status get(@PathVariable(name = "id") Long id) {
		Status status = service.get(id);
		return status;
	}

	@PostMapping
	public @ResponseBody Status create(@RequestBody Status status) {

		status = service.save(status);
		return status;
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable(name = "id") Long id, @RequestBody Status status) {

		status.setId(id);
		service.update(status);
	}

	@DeleteMapping(value = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		service.remove(id);
	}
}
