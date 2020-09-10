package com.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.BusinessException;
import com.demo.model.Kitchen;
import com.demo.service.KitchenService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class KitchenController {
	@Autowired
	private KitchenService service;
	
	private MultiValueMap<String, String> map;

	@PostMapping("/kitchen")
	public Kitchen addKitchen(@RequestBody Kitchen kitchen) {

		return service.addKitchen(kitchen);
	}

	@PutMapping("/kitchen")
	public Kitchen updateKitchen(@RequestBody Kitchen kitchen) {

		return service.updateKitchen(kitchen);
	}

	@GetMapping("/kitchen/{id}")
	public ResponseEntity<Kitchen> getKitchenById(@PathVariable int id) {

		try {
			return new ResponseEntity<>(service.getKitchenById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/kitchen/{id}")
	public void deleteKitchenById(@PathVariable int id) {
		service.deleteKitchenById(id);

	}

	@GetMapping("/kitchens")
	public List<Kitchen> getAllKitchens() {

		return service.getAllKitchens();
	}

	@GetMapping("/kitchens/cost/{cost}")
	public List<Kitchen> getAllKitchensByCost(@PathVariable int cost) {
		
		return service.getAllKitchensByCost(cost);
	}

	
}

