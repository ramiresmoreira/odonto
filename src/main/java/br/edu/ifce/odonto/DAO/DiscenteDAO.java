package br.edu.ifce.odonto.DAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.odonto.model.Discente;
import br.edu.ifce.odonto.util.JPAUtil;

public class DiscenteDAO {
	
//	private EntityManager 


	public boolean save(Discente discente) throws Exception{
		
		try {
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(discente);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Discente get(Integer id){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Discente discente = em.find(Discente.class, id);
		em.getTransaction().commit();
		em.close();
		return discente;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Discente> getAll(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT d FROM Discente d");
		em.getTransaction().commit();
		List<Discente> resultList = query.getResultList();
		em.close();
		return resultList;
	}
	
}
