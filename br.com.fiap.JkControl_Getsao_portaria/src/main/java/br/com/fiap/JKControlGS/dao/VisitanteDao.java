package br.com.fiap.JKControlGS.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.JKControlGS.model.Visitante;

public class VisitanteDao {

	@Inject
	private EntityManager manager;

	public void create(Visitante visitante) {

		manager.getTransaction().begin();
		manager.persist(visitante);
		manager.getTransaction().commit();

		manager.clear();
	}

	public List<Visitante> listAll() {
		TypedQuery<Visitante> query = manager.createQuery("SELECT v FROM Visitante v", Visitante.class);
		return query.getResultList();
	}
	
	public void delete(Visitante visitante) {
		manager.getTransaction().begin();
		manager.remove(visitante);
		manager.getTransaction().commit();
	}
	
	public void update(Visitante visitante) {
		manager.getTransaction().begin();
		
		System.out.println(visitante);
		
		manager.merge(visitante);
		
		manager.getTransaction().commit();
		
	}

	public boolean exist(Visitante visitante) { //JPQL
		String sql = "SELECT v FROM visitante v WHERE "
				+ "cpf=:cpf";
		
		TypedQuery<Visitante> query = manager.createQuery(sql , Visitante.class);
		query.setParameter("cpf", visitante.getCpf());
			
		try {
			query.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
