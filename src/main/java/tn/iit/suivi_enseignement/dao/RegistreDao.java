package tn.iit.suivi_enseignement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.suivi_enseignement.entites.Registre;

@Repository
public interface RegistreDao extends JpaRepository<Registre, String>{

}
