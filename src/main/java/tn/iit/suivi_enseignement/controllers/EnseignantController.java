package tn.iit.suivi_enseignement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.iit.suivi_enseignement.dao.EnseignantDao;
import tn.iit.suivi_enseignement.entites.Enseignant;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {
	@Autowired
	EnseignantDao enseignantDao;

	@PostMapping
	public ResponseEntity<Enseignant> createOrUpdate(@RequestBody Enseignant enseignant) {
		Enseignant dep = enseignantDao.saveAndFlush(enseignant);
		return new ResponseEntity<>(dep, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Enseignant> delete(@PathVariable Integer id) {

		Enseignant dep = null;
		ResponseEntity<Enseignant> response = null;
		if (enseignantDao.findOne(id) != null) {
			dep = enseignantDao.findOne(id);
			enseignantDao.delete(id);
			response = new ResponseEntity<>(dep, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	@ResponseBody
	public Enseignant getOne(@PathVariable Integer id) {
		return enseignantDao.findOne(id);
	}

	@GetMapping
	@ResponseBody
	public List<Enseignant> list() {
		return enseignantDao.findAll();
	}
}
