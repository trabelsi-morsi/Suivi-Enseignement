package tn.iit.suivi_enseignement.dto;

import tn.iit.suivi_enseignement.entites.Enseignement;
import tn.iit.suivi_enseignement.entites.Pointage;

public class PointageDto {
	private Integer id;
	private String date;
	private Integer enseignement;

	public Pointage toPointage(Enseignement e) {

		Pointage p = new Pointage();
		p.setDate(date);
		p.setId(id);
		p.setEnseignement(e);
		return p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getEnseignement() {
		return enseignement;
	}

	public void setEnseignement(Integer enseignement) {
		this.enseignement = enseignement;
	}

}
