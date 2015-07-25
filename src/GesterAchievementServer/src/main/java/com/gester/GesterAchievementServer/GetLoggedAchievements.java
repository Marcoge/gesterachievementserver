package com.gester.GesterAchievementServer;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;


@Path("getloggedachievements")
public class GetLoggedAchievements {
	
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LoggedAchievement[] doGetLoggedAchievement(@QueryParam("u") String userEmail){
		List<LoggedAchievement> la;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Query hqN = session.createQuery("FROM LoggedAchievement WHERE userEmail = :u");
    	hqN.setParameter("u", userEmail);
    	

    	la = (List<LoggedAchievement>)hqN.list();
    	session.getTransaction().commit();
    	session.getSessionFactory().getCurrentSession().close();
		
		
		
		return la.toArray(new LoggedAchievement[la.size()]);
	}

}
