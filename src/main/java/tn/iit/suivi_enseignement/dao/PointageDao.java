package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.suivi_enseignement.entites.Pointage;

public interface PointageDao extends JpaRepository<Pointage, Integer> {

}
