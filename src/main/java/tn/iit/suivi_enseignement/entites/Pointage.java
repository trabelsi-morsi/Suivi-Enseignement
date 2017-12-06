package tn.iit.suivi_enseignement.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pointage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPointage")
	private Integer id;
	@Column
	private String date;

	public Pointage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer idPointage) {
		this.id = idPointage;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
