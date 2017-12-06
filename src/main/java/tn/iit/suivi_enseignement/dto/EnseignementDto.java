package tn.iit.suivi_enseignement.dto;

import tn.iit.suivi_enseignement.entites.Departement;
import tn.iit.suivi_enseignement.entites.Enseignant;
import tn.iit.suivi_enseignement.entites.Enseignement;
import tn.iit.suivi_enseignement.entites.Jour;
import tn.iit.suivi_enseignement.entites.Matiere;
import tn.iit.suivi_enseignement.entites.Niveau;
import tn.iit.suivi_enseignement.entites.Salle;
import tn.iit.suivi_enseignement.entites.Seance;

public class EnseignementDto {
	private Integer id;
	private int annee;
	private int cours;
	private int module;
	private int par15;
	private int semestre;

	private Integer enseignant;
	private Integer niveaux;
	private Integer salle;
	private Integer jour;
	private Integer seance;
	private Integer departement;
	private Integer matiere;

	public Enseignement toEnseignement(Enseignant e, Niveau n, Salle s, Jour j, Seance se, Departement dep, Matiere m) {

		Enseignement ens = new Enseignement();
		ens.setId(id);
		ens.setAnnee(annee);
		ens.setCours(cours);
		ens.setModule(module);
		ens.setPar15(par15);
		ens.setSemestre(semestre);

		ens.setEnseignant(e);
		ens.setNiveaux(n);
		ens.setSalle(s);
		ens.setJour(j);
		ens.setSeance(se);
		ens.setDepartement(dep);
		ens.setMatiere(m);
		return ens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getCours() {
		return cours;
	}

	public void setCours(int cours) {
		this.cours = cours;
	}

	public int getModule() {
		return module;
	}

	public void setModule(int module) {
		this.module = module;
	}

	public int getPar15() {
		return par15;
	}

	public void setPar15(int par15) {
		this.par15 = par15;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Integer getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Integer enseignant) {
		this.enseignant = enseignant;
	}

	public Integer getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Integer niveaux) {
		this.niveaux = niveaux;
	}

	public Integer getSalle() {
		return salle;
	}

	public void setSalle(Integer salle) {
		this.salle = salle;
	}

	public Integer getJour() {
		return jour;
	}

	public void setJour(Integer jour) {
		this.jour = jour;
	}

	public Integer getSeance() {
		return seance;
	}

	public void setSeance(Integer seance) {
		this.seance = seance;
	}

	public Integer getDepartement() {
		return departement;
	}

	public void setDepartement(Integer departement) {
		this.departement = departement;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}

}
