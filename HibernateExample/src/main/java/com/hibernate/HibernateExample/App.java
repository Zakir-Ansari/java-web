package com.hibernate.HibernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	Alien a1 = new Alien();
    	Alien a2 = new Alien();
    	//If you want to insert the data
    	AlienName name = new AlienName();
    	name.setFname("fname");
    	name.setLname("lname");
    	name.setEname("ename");
    	//a1.setAid(102);
    	a1.setAname(name);
    	a1.setColor("green");
    	
    	a2.setAname(name);
    	a2.setColor("purple");
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	//Get the registry object
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	//In case of data insertion
    	session.save(a1);    	
    	session.save(a2);
    	
    	//In case of data display
    	//a1 = (Alien) session.get(Alien.class, 102);
    	
    	tx.commit();
    	
    	//To display the data
    	System.out.println(a1);
    	/**
    	 * Desired output:
    	 * Hibernate: select alien0_.aid as aid0_0_, alien0_.aname as aname0_0_, alien0_.alien_color as alien3_0_0_ from alien_table alien0_ where alien0_.aid=?
		 * Alien [aid=102, aname=Test, color=green]
    	 */
    	
    	
    }
}
