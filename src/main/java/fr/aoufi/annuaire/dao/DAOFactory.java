package fr.aoufi.annuaire.dao;

import fr.aoufi.annuaire.dao.impl.NumeroDaoImpl;
import fr.aoufi.annuaire.dao.impl.PersonneDaoImpl;

public class DAOFactory {

	
	public static PersonneDao getPersonneDao() {
		return new PersonneDaoImpl();
	}
	
	public static NumeroDao getNumeroDao() {
		return new NumeroDaoImpl();
	}
	
}
