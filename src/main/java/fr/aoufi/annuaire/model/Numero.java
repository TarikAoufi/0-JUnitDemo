package fr.aoufi.annuaire.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Numero implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tel;
	private String type;
	

	@ManyToMany(mappedBy="numeros",fetch=FetchType.LAZY)
	List<Personne> personnes;
	
	public Numero() {

	}
	
	public Numero(String tel, String type) {
		this.tel = tel;
		this.type = type;
	}
	
	public Numero(Integer id, String tel, String type) {
		this.id = id;
		this.tel = tel;
		this.type = type;
	}



	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	@Override
	public String toString() {
		return "Numero [id=" + id + ", tel=" + tel + ", type=" + type + ", personnes=" + personnes + "]";
	}

}