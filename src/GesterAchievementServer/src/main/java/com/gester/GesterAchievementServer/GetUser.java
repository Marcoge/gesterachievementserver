package com.gester.GesterAchievementServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;


@Path("getuser")
public class GetUser {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User doGetUser(@QueryParam("u") String email){
		
		
		//Preparing Hibernate Query
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    	session.beginTransaction();
		    	Query hqN = session.createQuery("FROM User WHERE email = :email");
		    	hqN.setParameter("email", email);
		    	
		    	User u = (User)hqN.uniqueResult();

		    
		    	session.getTransaction().commit();
		    	session.getSessionFactory().getCurrentSession().close();
		
		return u;
	}

}
