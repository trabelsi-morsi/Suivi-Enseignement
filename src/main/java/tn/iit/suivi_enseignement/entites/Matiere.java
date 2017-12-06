package tn.iit.suivi_enseignement.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mat")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_matiere")
	private Integer id;
	@Column(name = "abv")
	private String abvreviation;
	@Column(name = "nom_matiere")
	private String nom_matiere;

	@OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
	private List<Enseignement> enseignements;

	public Matiere() {
	}

	public String getAbvreviation() {
		return abvreviation;
	}

	public void setAbvreviation(String abvreviation) {
		this.abvreviation = abvreviation;
	}

	public String getNom_matiere() {
		return nom_matiere;
	}

	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}

	public List<Enseignement> getEnseignements() {
		return enseignements;
	}

	public void setEnseignements(List<Enseignement> enseignements) {
		this.enseignements = enseignements;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Matiere other = (Matiere) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", abvreviation=" + abvreviation + ", nom_matiere=" + nom_matiere
				+ ", enseignements=" + enseignements + "]";
	}

}
