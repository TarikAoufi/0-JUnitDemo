package fr.aoufi.annuaire.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.aoufi.annuaire.exception.DAOException;

public class JPAutils {
	
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static EntityManager createEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("annuaire");
				entityManager = entityManagerFactory.createEntityManager();
			} catch (ExceptionInInitializerError e) {
				throw e;
			}
		}
		return entityManager;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public static void commit() throws DAOException {
		try {
			getEntityManager().getTransaction().commit();
		} catch (PersistenceException e) {
			throw new DAOException("Erreur JPAUtils commit " + e.getMessage(), e);
		}
	}
	
	public static void rollback(){
		getEntityManager().getTransaction().rollback();
	}

	public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}

	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
