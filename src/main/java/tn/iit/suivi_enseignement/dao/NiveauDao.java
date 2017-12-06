package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Niveau;

public interface NiveauDao extends JpaRepository<Niveau, Integer> {

}
