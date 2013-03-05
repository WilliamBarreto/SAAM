package br.ucb.saam.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionFactory {
	
	
	
	private static ServiceRegistry serviceRegistry;
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = (ServiceRegistry) new	ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			
			sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
			
		}catch(Throwable ex){
			System.err.println("OPsss falha na criação." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}



