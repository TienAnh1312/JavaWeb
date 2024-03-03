package buitienanh.edu.vn.ultil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import buitienanh.edu.vn.entity.Product;
import jakarta.websocket.Session;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	static {
		try {
			if(sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
					MetadataSources metadataSource = new MetadataSources(standardServiceRegistry).addAnnotatedClass(Product.class);
					Metadata metadata = metadataSource.getMetadataBuilder().build();
					sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		}catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
