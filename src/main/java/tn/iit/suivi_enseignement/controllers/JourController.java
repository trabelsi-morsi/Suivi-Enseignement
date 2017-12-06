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
import org.springframework.web.bind.annotation.RestController;

import tn.iit.suivi_enseignement.dao.JourDao;
import tn.iit.suivi_enseignement.entites.Jour;

@RestController
@RequestMapping("/jour")
public class JourController {

	@Autowired
	private JourDao jourDao;

	@PostMapping
	public ResponseEntity<Jour> createOrUpdate(@RequestBody Jour jour) {
		Jour j = jourDao.saveAndFlush(jour);
		return new ResponseEntity<>(j, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Jour> delete(@PathVariable Integer id) {
		Jour j = null;
		ResponseEntity<Jour> response = null;
		if ((j = jourDao.findOne(id)) != null) {
			jourDao.delete(id);
			response = new ResponseEntity<>(j, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Jour getOne(@PathVariable Integer id) {
		return jourDao.findOne(id);
	}

	@GetMapping
	public List<Jour> list() {
		return jourDao.findAll();
	}

}
