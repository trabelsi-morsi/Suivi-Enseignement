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

import tn.iit.suivi_enseignement.dao.RegistreDao;
import tn.iit.suivi_enseignement.entites.Registre;

@RestController
@RequestMapping("/registre")
public class RegistreController {

	@Autowired
	private RegistreDao registreDao;

	@PostMapping
	public ResponseEntity<Registre> createOrUpdate(@RequestBody Registre registre) {
		Registre s = registreDao.saveAndFlush(registre);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@DeleteMapping("/{mail:.+}")
	public ResponseEntity<Registre> delete(@PathVariable String mail) {
		Registre s = null;
		ResponseEntity<Registre> response = null;
		if ((s = registreDao.findOne(mail)) != null) {
			registreDao.delete(mail);
			response = new ResponseEntity<>(s, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	@GetMapping("/{mail:.+}")
	@ResponseBody
	public Registre getOne(@PathVariable String mail) {
		return registreDao.findOne(mail);
	}

	@GetMapping
	@ResponseBody
	public List<Registre> list() {
		return registreDao.findAll();
	}

}
