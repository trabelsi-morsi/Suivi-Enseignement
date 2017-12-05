package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Departement;

public interface DepartementDao extends JpaRepository<Departement, Integer>{

}
