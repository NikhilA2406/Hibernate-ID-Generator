package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;



public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();
		
		config.addAnnotatedClass(userinfo.class);

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		userinfo student=new userinfo();
		//student.setSid(1);
		student.setUcity("Kolkata");
		student.setuName("Nikhil");
		
		try
		{
			transaction=session.beginTransaction();
			//session.save(student);
			session.persist(student);
			flag=true;
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}


	}

}
