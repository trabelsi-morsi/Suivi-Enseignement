package tn.iit.suivi_enseignement.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Column(name = "dateEns")
	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "COD_senace")
	private Seance seance;

	@ManyToOne
	@JoinColumn(name = "cod_dep")
	private Departement departement;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "COD_mat")
	private Matiere matiere;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignement other = (Enseignement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}