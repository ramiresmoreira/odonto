package br.edu.ifce.odonto.DAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.odonto.model.Paciente;
import br.edu.ifce.odonto.util.JPAUtil;

public class PacienteDAO {

	public boolean save(Paciente paciente) throws Exception {
		try {
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Paciente get(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Paciente paciente = em.find(Paciente.class, id);
		em.getTransaction().commit();
		em.close();
		return paciente;
	}

	@SuppressWarnings("unchecked")
	public Collection<Paciente> getAll() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Paciente p");
		em.getTransaction().commit();
		List<Paciente> resultList = query.getResultList();
		em.close();
		return resultList;
	}

}
