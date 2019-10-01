package com.zakir.hibernateOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateOperations {
	public Session session = null;
	
	//Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
	public Session getSessionForUser(Configuration con) {
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	session = sf.openSession();
		
		return session;
	}
	
	
	
	
}
