package tn.iit.suivi_enseignement.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Enseignement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBase")
	private Integer id;
	@Column(name = "annee1")
	private int annee;
	@Column
	private int cours;
	@Column
	private int module;
	@Column
	private int par15;
	@Column(name = "semestre1")
	private int semestre;

	@ManyToOne
	@JoinColumn(name = "cod_enseig")
	private Enseignant enseignant;

	@ManyToOne
	@JoinColumn(name = "cod_niveau")
	private Niveau niveaux;

	@ManyToOne
	@JoinColumn(name = "COD_salle")
	private Salle salle;

	@ManyToOne
	@JoinColumn(name = "cod_jour")
	private Jour jour;

	@ManyToOne
	@JoinColumn(name = "COD_senace")
	private Seance seance;

	@ManyToOne
	@JoinColumn(name = "cod_dep")
	private Departement departement;

	@ManyToOne
	@JoinColumn(name = "COD_mat")
	private Matiere matiere;

	@OneToMany(mappedBy = "enseignement", fetch = FetchType.EAGER)
	private List<Pointage> pointages;

	public Enseignement() {
	}

	public int getCours() {
		return this.cours;
	}

	public void setCours(int cours) {
		this.cours = cours;
	}

	public int getModule() {
		return this.module;
	}

	public void setModule(int module) {
		this.module = module;
	}

	public int getPar15() {
		return this.par15;
	}

	public void setPar15(int par15) {
		this.par15 = par15;
	}

	public Niveau getNiveaux() {
		return this.niveaux;
	}

	public void setNiveaux(Niveau niveaux) {
		this.niveaux = niveaux;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Jour getJour() {
		return this.jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Pointage> getPointages() {
		return this.pointages;
	}

	public void setPointages(List<Pointage> pointages) {
		this.pointages = pointages;
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

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

}