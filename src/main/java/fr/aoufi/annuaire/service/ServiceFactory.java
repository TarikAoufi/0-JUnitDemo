package fr.aoufi.annuaire.service;

import fr.aoufi.annuaire.service.impl.NumeroServiceImpl;
import fr.aoufi.annuaire.service.impl.PersonneServiceImpl;

public class ServiceFactory {
	
	public static PersonneService getPersonneService(){
		return new PersonneServiceImpl();
	}
	public static NumeroService getNumeroService(){
		return new NumeroServiceImpl();
	}
}
