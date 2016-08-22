package fr.aoufi.annuaire.dao.impl;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fr.aoufi.annuaire.dao.DAOFactory;
import fr.aoufi.annuaire.dao.PersonneDao;
import fr.aoufi.annuaire.model.Personne;

public class PersonneDaoImplTest {	
  
    @Test
    public void testGetfirstName() {
    	Personne p1 = new Personne ("Thomas", "Brown", new Date());
    	Assert.assertEquals("Thomas", p1.getNom());
    }
    
    @Test
	public void findByNameShouldReturn10() {
		
		PersonneDao personneDao = DAOFactory.getPersonneDao();
		/*
 		List<Personne> personnes = personneDao.findByName("Bond");
		
 		Assert.assertNotNull(personnes);
 		for (Personne personne : personnes) {
 			System.out.println(personne.toString());
 		}
 		Assert.assertEquals(2, personnes.size());
 		*/
	}

}
