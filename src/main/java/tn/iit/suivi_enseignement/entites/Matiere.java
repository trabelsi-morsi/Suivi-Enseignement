package tn.iit.suivi_enseignement.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String nom;

	public Matiere() {
	}

	public String getAbvreviation() {
		return abvreviation;
	}

	public void setAbvreviation(String abvreviation) {
		this.abvreviation = abvreviation;
	}

	public String getNom_matiere() {
		return nom;
	}

	public void setNom_matiere(String nom_matiere) {
		this.nom = nom_matiere;
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

}
