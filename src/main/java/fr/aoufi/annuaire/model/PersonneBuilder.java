package fr.aoufi.annuaire.model;

import java.util.ArrayList;
import java.util.Date;

public class PersonneBuilder {
	
	private Personne personne;
	
	public static PersonneBuilder createInstance() {		
		PersonneBuilder builder = new PersonneBuilder();
		builder.personne = new Personne();	
		return builder;		
	}
	
	public PersonneBuilder withNom (String nom)	{
		this.personne.setNom(nom);
		return this;
	}
	
	public PersonneBuilder withPreom (String prenom) {
		this.personne.setPrenom(prenom);
		return this; 
	}
	
	public PersonneBuilder withDate(Date date) {
		this.personne.setDateNaissance(date);
		return this;
	}
	
	public PersonneBuilder withNum(Numero num) {
		if (personne.getNumeros() == null) {
			personne.setNumeros(new ArrayList<Numero>());
		}
		this.personne.getNumeros().add(num);
		return this;
	}
	
	public Personne builder() {
		return this.personne;
	}
}
