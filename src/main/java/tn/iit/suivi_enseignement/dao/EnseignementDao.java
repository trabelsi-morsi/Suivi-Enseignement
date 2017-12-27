package tn.iit.suivi_enseignement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Enseignement;

public interface EnseignementDao extends JpaRepository<Enseignement, Integer> {
	List<Enseignement> findByDate(Date date);
}
