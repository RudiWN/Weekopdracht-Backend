package com.theorganisation.rest;

import com.theorganisation.controller.TelefoonService;
import com.theorganisation.domain.Telefoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telefoon")
public class TelefoonEndpoint {
	
	@Autowired
	TelefoonService telefoonService;
	
	@PostMapping("/new")
	public Telefoon addTelefoon(@RequestBody Telefoon telefoon) {
		return telefoonService.addTelefoon(telefoon);
	}

	@GetMapping("/all")
	public Iterable<Telefoon> getEmployees() {
		return telefoonService.getAllTelefoons();
	}
}
