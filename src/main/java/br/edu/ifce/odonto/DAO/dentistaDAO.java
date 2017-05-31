package br.edu.ifce.odonto.DAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.odonto.model.Dentista;
import br.edu.ifce.odonto.util.JPAUtil;

public class dentistaDAO {
	
public boolean save(Dentista dentista) throws Exception{
		
		try {
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(dentista);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Dentista get(Integer id){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Dentista dentista = em.find(Dentista.class, id);
		em.getTransaction().commit();
		em.close();
		return dentista;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Dentista> getAll(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT d FROM Dentista d");
		em.getTransaction().commit();
		List<Dentista> resultList = query.getResultList();
		em.close();
		return resultList;
	}

}
