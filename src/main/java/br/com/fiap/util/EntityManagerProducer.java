package br.com.fiap.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	@Produces
	public EntityManager create() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gs");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

}
