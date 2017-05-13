package br.edu.ifce.odonto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;

import App.MainApp;

public class JPAUtil {
	
//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("odonto"); 
	private EntityManagerFactory factory = MainApp.getSession().getEntityManagerFactory();
	public EntityManager getEntityManager(){
		EntityManager em = factory.createEntityManager();
		return em;
	}
}
