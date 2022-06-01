package br.com.fiap.JKControlGS.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerProducer {
	
	@RequestScoped
	@Produces
	public EntityManager getManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JKControlGS-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

}
