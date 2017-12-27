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

import tn.iit.suivi_enseignement.dao.NiveauDao;
import tn.iit.suivi_enseignement.entites.Niveau;

@RestController
@RequestMapping("/niveau")
@CrossOrigin(origins="*")
public class NiveauController {

	@Autowired
	private NiveauDao niveauDao;

	@PostMapping
	public ResponseEntity<Niveau> createOrUpdate(@RequestBody Niveau niveau) {
		Niveau niv = niveauDao.saveAndFlush(niveau);
		return new ResponseEntity<>(niv, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Niveau> delete(@PathVariable Integer id) {

		Niveau niv = null;
		ResponseEntity<Niveau> response = null;
		if ((niv = niveauDao.findOne(id)) != null) {
			niveauDao.delete(id);
			response = new ResponseEntity<>(niv, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Niveau getOne(@PathVariable Integer id) {
		return niveauDao.findOne(id);
	}

	@GetMapping
	public List<Niveau> list() {
		return niveauDao.findAll();
	}
}
