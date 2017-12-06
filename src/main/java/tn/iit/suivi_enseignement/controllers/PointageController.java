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

import tn.iit.suivi_enseignement.dao.EnseignementDao;
import tn.iit.suivi_enseignement.dao.PointageDao;
import tn.iit.suivi_enseignement.dto.PointageDto;
import tn.iit.suivi_enseignement.entites.Enseignement;
import tn.iit.suivi_enseignement.entites.Pointage;

@RestController
@RequestMapping("/pointage")
public class PointageController {

	@Autowired
	private PointageDao pointageDao;
	@Autowired
	private EnseignementDao enseignementDao;

	@PostMapping
	public ResponseEntity<Pointage> createOrUpdate(@RequestBody PointageDto pointageDto) {

		Enseignement enseignement = enseignementDao.findOne(pointageDto.getEnseignement());

		Pointage pointage = pointageDto.toPointage(enseignement);
		pointageDao.saveAndFlush(pointage);
		return new ResponseEntity<>(pointage, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pointage> delete(@PathVariable Integer id) {

		Pointage p = null;
		ResponseEntity<Pointage> response = null;
		if ((p = pointageDao.findOne(id)) != null) {
			pointageDao.delete(id);
			response = new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Pointage getOne(@PathVariable Integer id) {
		return pointageDao.findOne(id);
	}

	@GetMapping
	public List<Pointage> list() {
		return pointageDao.findAll();
	}
}
