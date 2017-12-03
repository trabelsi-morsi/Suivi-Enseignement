package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.suivi_enseignement.entites.Salle;

@Repository
public interface SalleDao extends JpaRepository<Salle, Integer>{

}
