package com.zakir.wipro.hibernateOperations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.zakir.wipro.pojo.TestResults;
import com.zakir.wipro.pojo.UserDetails;

public class HibernateOperations {
	public static Session session = null;

	public Session getSessionForUserDetails(Class<?> clazz) {
		Configuration con = new Configuration().configure().addAnnotatedClass(clazz);
		// Get the registry object
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		session = sf.openSession();

		return session;
	}
	
	public void closeSession() {
		if (session.isOpen() == true)
			session.close();
	}
	
	public boolean checkIfUserExist(String forEmail) {
		UserDetails user = getUserDetails(forEmail);
		if(user == null) return false;
		else return true;
	}

	public void initialDataUpdate() {
		UserDetails u1 = new UserDetails();
		UserDetails u2 = new UserDetails();
		System.out.println("session: " + session);

		u1.setEmail("roger@gmail.com");
		u1.setPassword("wipro@123");
		u1.setFirstName("Roger");
		u1.setLastName("Kutcher");
		u1.setUserType("admin"); 

		u2.setEmail("steve@gmail.com");
		u2.setPassword("wipro@123");
		u2.setFirstName("Steve");
		u2.setLastName("Martin");
		u2.setUserType("admin");

		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		Transaction tx = null;
		System.out.println("session: " + session);

		try {

			if (!checkIfUserExist("steve@gmail.com")) {
				tx = session.beginTransaction();
				session.save(u1);
				session.save(u2);
				tx.commit();
				System.out.println("Initial admin data stored in database");
			}
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			closeSession();
		}
		System.out.println("Session closed : session = "+session);
	}

	public UserDetails getUserDetails(String userEmail) {
		System.out.println("session: " + session);
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		System.out.println("session: " + session);

		Transaction tx = null;
		UserDetails user = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM UserDetails U WHERE U.email = :userEmail";
			Query query = session.createQuery(hql);
			query.setParameter("userEmail", userEmail);
			List userDetails = query.list();
			for (Iterator iterator = userDetails.iterator(); iterator.hasNext();) {
				user = (UserDetails) iterator.next();
				System.out.println("After select query: user email:"+user.getEmail());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<UserDetails> getCandidateList() {
		List<UserDetails> candidates = new ArrayList<UserDetails>();
		closeSession();
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List candidate = session.createQuery("FROM UserDetails u").list();
			for (Iterator iterator = candidate.iterator(); iterator.hasNext();){
	            UserDetails user = (UserDetails) iterator.next(); 
	            candidates.add(user);
	         }
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}		
		return candidates;
	}
	
	public String addCandidate(String fname, String lname, String email, String password, String uType) {
		String response= "failure";
		System.out.println("session: " + session);
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		Transaction tx = null;
		UserDetails newUser = null;
		try {
			tx = session.beginTransaction();
	        newUser = new UserDetails();
	        newUser.setFirstName(fname);
			newUser.setLastName(lname);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setUserType(uType);
			
			session.save(newUser);
			tx.commit();
			System.out.println("Data Saved");
			response = "success";
		} catch(Exception ex) {
			if (tx!=null) tx.rollback();
	        ex.printStackTrace();
		}
		
		return response;
	}
	
	public String deleteUser(String userEmail) {
		String response = "failure";
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		Transaction tx = null;
		UserDetails userToDelete = null;
		try {
			tx = session.beginTransaction();
			userToDelete = (UserDetails)session.get(UserDetails.class, userEmail);
			session.delete(userToDelete);
			tx.commit();
			
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
	        ex.printStackTrace();
		}
		
		
		return response;
	}
	
	public String dropTableInitially() {
		System.out.println("session: " + session);
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(UserDetails.class);
		}
		System.out.println("session: " + session);

		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			String hql = "delete from UserDetails where user_type = 'candidate'";
			session.createQuery(hql).executeUpdate();
			tx.commit();
			System.out.println("Deletion Done!!");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return "";
	}
	
	public String dropAssessmentTableInitially() {
		closeSession();
		System.out.println("session: " + session);
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(TestResults.class);
		}
		System.out.println("session: " + session);

		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			 String hql = "delete from TestResults tr where tr.totalMarks = 50";
			 session.createQuery(hql).executeUpdate();
			/*
			 * TestResults tr = (TestResults)session.get(TestResults.class, emailId);
			 * session.delete(tr);
			 */
			tx.commit();
			System.out.println("Deletion Done!!");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return "";
	}
	
	public int insertIntoAssessmentResults(int id, String userEmail, String assessment, int score, String result ) {
		int response = 0;
		System.out.println("hibernate session in insert Into AssessmentResult: " + session);
		closeSession();
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(TestResults.class);
		}
		
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String dateTime = formatter.format(date);
	    System.out.println("saved date: "+ dateTime);  
		
		
		Transaction tx = null;
		TestResults testResult = null;
		try {
			tx = session.beginTransaction();
			testResult = new TestResults();
			testResult.setId(id);
			testResult.setTestDate(dateTime);
			testResult.setAssessmentName(assessment);
			testResult.setTestMarks(score);
			testResult.setEmailId(userEmail);
			testResult.setTotalMarks(50);
			testResult.setResult(result);
			
			session.save(testResult);
			tx.commit();
			System.out.println("Data Saved");
			response = 1;
		} catch(Exception ex) {
			if (tx!=null) tx.rollback();
	        ex.printStackTrace();
		}
		finally {
			closeSession();
		}

		return response;
	}
	
	public List<TestResults> getTestResultList() {
		List<TestResults> results = new ArrayList<TestResults>();
		closeSession();
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(TestResults.class);
		}
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List assessmentResults = session.createQuery("FROM TestResults tr").list();
			for (Iterator iterator = assessmentResults.iterator(); iterator.hasNext();){
	            TestResults testResult = (TestResults) iterator.next(); 
	            results.add(testResult);
	         }
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}		
		return results;
	}
	public int getIdForTestResultTable() {
		int newId = 1;
		closeSession();
		if (session == null || session.isOpen() == false) {
			session = getSessionForUserDetails(TestResults.class);
		}
		Transaction tx = null;
		System.out.println("new Id initially: "+newId);
		try {
			tx = session.beginTransaction();
			List assessmentResults = session.createQuery("FROM TestResults tr").list();
			for (Iterator iterator = assessmentResults.iterator(); iterator.hasNext();){
				TestResults testResult = (TestResults) iterator.next(); 
				newId++;
				System.out.println("new Id got: "+newId);
	         }
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}		
		return newId;
	}
}
