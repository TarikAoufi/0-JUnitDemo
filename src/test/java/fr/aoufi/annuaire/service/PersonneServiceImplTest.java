package fr.aoufi.annuaire.service;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.aoufi.annuaire.dao.PersonneDao;
import fr.aoufi.annuaire.exception.ServiceException;
import fr.aoufi.annuaire.model.Personne;
import fr.aoufi.annuaire.service.impl.PersonneServiceImpl;


public class PersonneServiceImplTest {
	
	@BeforeClass
	public static void initClass(){
		//Avant même de créer la classe
	}
	
	@Before
	public void iniTest(){
		//Avnt chaque test
	}
	
	@Test(expected = ServiceException.class)
	public void testServiceException(){
		throw new ServiceException("Erreur test", null);
	}
	
	@Test
	public void shouldReturnPersonnes() {
		
		PersonneServiceImpl  service = new PersonneServiceImpl();
		
		PersonneDao mockPersDao = EasyMock.mock(PersonneDao.class);
		
		
		List<Personne> resultMock = Arrays.asList(new Personne("Pers","Pers2",null), 
				new Personne("Pers","Pers2",null));		
		
		EasyMock.expect(mockPersDao.findByName("Pers")).andReturn(resultMock);
		EasyMock.expect(mockPersDao.findByName("TOTO")).andReturn(null);
		
		EasyMock.replay(mockPersDao); // pour verouiller après expect
		
		service.setPersonneDao(mockPersDao);
		
		List<Personne> result = service.findByName("Pers");
		
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		
		List<Personne> result2 = service.findByName("TOTO");
		Assert.assertNull(result2);
		
		EasyMock.verify(mockPersDao);
	}
}
