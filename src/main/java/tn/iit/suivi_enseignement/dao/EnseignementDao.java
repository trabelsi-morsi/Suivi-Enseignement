package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Enseignement;

public interface EnseignementDao extends JpaRepository<Enseignement, Integer>{

}
