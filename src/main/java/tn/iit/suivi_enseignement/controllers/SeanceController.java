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

import tn.iit.suivi_enseignement.dao.SeanceDao;
import tn.iit.suivi_enseignement.entites.Seance;

@RestController
@RequestMapping("/seance")
public class SeanceController {

	@Autowired
	private SeanceDao seanceDao;

	@PostMapping
	public ResponseEntity<Seance> createOrUpdate(@RequestBody Seance salle) {
		Seance s = seanceDao.saveAndFlush(salle);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Seance> delete(@PathVariable Integer id) {
		Seance s = null;
		ResponseEntity<Seance> response = null;
		if ((s = seanceDao.findOne(id)) != null) {
			seanceDao.delete(id);
			response = new ResponseEntity<>(s, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Seance getOne(@PathVariable Integer id) {
		return seanceDao.findOne(id);
	}

	@GetMapping
	public List<Seance> list() {
		return seanceDao.findAll();
	}

}
