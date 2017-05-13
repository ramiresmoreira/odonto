package br.edu.ifce.odonto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifce.odonto.model.Discente;

public class PacienteTest {
	
	private static Discente discente;
	private static EntityManager em;
	private static EntityManagerFactory factory;
	
	@Before
	public void criaPaciente(){
		discente = new Discente("Ramires", 25);
	}
	
	@Before
	public void criaEm(){
		factory = Persistence.createEntityManagerFactory("odonto");
		em = factory.createEntityManager();
	}
	
	@Test
	public void main() {
		em.getTransaction().begin();
		em.persist(discente);
		em.getTransaction().commit();
		Discente find = em.find(Discente.class, 1);
		Assert.assertTrue(find.equals(discente));
		em.close();
		factory.close();
	}
	
}
