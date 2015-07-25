package com.gester.GesterAchievementServer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

@Path("receiveachievement")
public class ReceiveAchievement {
	
	
	


	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CustomResponse receiveAndSaveAchievement(LoggedAchievement sentAchievement){
	
		CustomResponse cr = new CustomResponse();
		cr.setResponse("OK");

		
		//saving sent Achievement to database
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	session.save(sentAchievement);
    	session.getTransaction().commit();
    	session.getSessionFactory().getCurrentSession().close();
		return cr;
	}

}
