package br.edu.ifce.odonto.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//new AnnotationConfiguration().configure("hibernate.cfg.xml");
public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory = null;

	public static Session openSession(String host, int port, String base, String login, String senha) {
		Configuration config = new Configuration().configure(getPath());
		config.setProperty("hibernate.connection.url", "jdbc:postgresql://" + host + ":" + port + base);
		config.setProperty("hibernate.connection.username", login);
//		postgres://mwvunzpjqtqwse:fdf5514aaf8c2ca203603a14c57dd9c6aa7cde9b5cf30b4cb2af124e8537f265@ec2-23-23-111-171.compute-1.amazonaws.com:5432/d9duj1m1po4a03
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

	
	
	public static String getPath() {
		String str2 = "hibernate.cfg.xml";
//	    return getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "hibernate.cfg.xml";
	    return str2;
	}

}
