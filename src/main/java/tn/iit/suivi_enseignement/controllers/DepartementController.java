package tn.iit.suivi_enseignement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.suivi_enseignement.dao.DepartementDao;
import tn.iit.suivi_enseignement.entites.Departement;

@RestController
@RequestMapping("/departement")
@CrossOrigin(origins="*")
public class DepartementController {

	@Autowired
	private DepartementDao departementDao;

	@PostMapping
	public ResponseEntity<Departement> createOrUpdate(@RequestBody Departement departement) {
		Departement dep = departementDao.saveAndFlush(departement);
		return new ResponseEntity<>(dep, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Departement> delete(@PathVariable Integer id) {

		Departement dep = null;
		ResponseEntity<Departement> response = null;
		if ((dep = departementDao.findOne(id)) != null) {
			departementDao.delete(id);
			response = new ResponseEntity<>(dep, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Departement getOne(@PathVariable Integer id) {
		return departementDao.findOne(id);
	}

	@GetMapping
	public List<Departement> list() {
		return departementDao.findAll();
	}

}
