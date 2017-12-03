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

import tn.iit.suivi_enseignement.dao.SalleDao;
import tn.iit.suivi_enseignement.entites.Salle;

@RestController
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	private SalleDao salleDao;

	@PostMapping
	public ResponseEntity<Salle> createOrUpdate(@RequestBody Salle salle) {
		Salle s = salleDao.saveAndFlush(salle);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Salle> delete(@PathVariable Integer id) {
		Salle s = null;
		if (salleDao.findOne(id) != null) {
			s = salleDao.findOne(id);
		}
		salleDao.delete(id);
		return new ResponseEntity<>(s, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	@ResponseBody
	public Salle getOne(@PathVariable Integer id) {
		return salleDao.findOne(id);
	}

	@GetMapping
	@ResponseBody
	public List<Salle> list() {
		return salleDao.findAll();
	}

}
