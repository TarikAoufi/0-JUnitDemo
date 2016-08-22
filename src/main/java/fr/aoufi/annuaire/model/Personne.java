package fr.aoufi.annuaire.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;	
	private Date dateNaissance;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<Numero> numeros;

	
	
	public Personne() {
	}
	
	public Personne(String nom, String prenom, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public Personne(Integer id, String nom, String prenom, Date dateNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	
	public Personne(int id, String nom, String prenom, Date dateNaissance, Set<Numero> numero) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeros = numero;
		this.dateNaissance = dateNaissance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Numero> getNumeros() {
		if (numeros == null) {
            numeros = new HashSet<Numero>();
        }
        return new ArrayList<>(this.numeros);
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = new HashSet<Numero>(numeros);
	}


	@Override
	public String toString() {
		return "Personne: [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ "]";
	}
	
}
