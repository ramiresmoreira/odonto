package br.edu.ifce.odonto.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//new AnnotationConfiguration().configure("hibernate.cfg.xml");
public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory = null;

	public static Session openSession(String servidor, int port, String base, String login, String senha) {
		Configuration config = new Configuration().configure("META-INF/hibernate.cfg.xml");
		config.setProperty("hibernate.connection.url", "jdbc:postgresql://" + servidor + ":" + port + base);
		config.setProperty("hibernate.connection.username", login);
		config.setProperty("hibernate.connection.password", senha);
		sessionFactory = config.buildSessionFactory();
		threadLocal.set(sessionFactory.openSession());
		return threadLocal.get();
	}

	public static void closeCurrentSession() {
		threadLocal.get().close();
		threadLocal.set(null);
	}

	public static Session getCurrentSession() {
		return threadLocal.get();
	}
}
