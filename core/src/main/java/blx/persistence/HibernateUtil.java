package blx.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
//			if (sessionFactory == null) {
//				
//				Configuration configuration = new Configuration()
//						.configure(HibernateUtil.class
//								.getResource("hibernate.cfg.xml"));
//				ServiceRegistry serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//				
//				sessionFactory = configuration
//						.buildSessionFactory(serviceRegistryBuilder);
//			}
			return new Configuration().configure().buildSessionFactory();
//			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}



