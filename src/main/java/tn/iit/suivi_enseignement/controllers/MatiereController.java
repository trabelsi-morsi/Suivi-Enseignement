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

import tn.iit.suivi_enseignement.dao.MatiereDao;
import tn.iit.suivi_enseignement.entites.Matiere;

@RestController
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereDao matiereDao;

	@PostMapping
	public ResponseEntity<Matiere> createOrUpdate(@RequestBody Matiere matiere) {
		Matiere s = matiereDao.saveAndFlush(matiere);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Matiere> delete(@PathVariable Integer id) {
		Matiere s = null;
		ResponseEntity<Matiere> response = null;
		if ((s = matiereDao.findOne(id)) != null) {
			matiereDao.delete(id);
			response = new ResponseEntity<>(s, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{id}")
	public Matiere getOne(@PathVariable Integer id) {
		return matiereDao.findOne(id);
	}

	@GetMapping
	public List<Matiere> list() {
		return matiereDao.findAll();
	}

}
