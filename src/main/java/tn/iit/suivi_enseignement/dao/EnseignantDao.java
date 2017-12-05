package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Enseignant;

public interface EnseignantDao extends JpaRepository<Enseignant, Integer>{

}
