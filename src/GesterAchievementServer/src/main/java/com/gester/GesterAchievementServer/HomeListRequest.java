package com.gester.GesterAchievementServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;


@Path("homelistrequest")
public class HomeListRequest {
	
	
	
	@SuppressWarnings("unchecked")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Achievement[] doGetJson(@QueryParam("n") double n, @QueryParam("e") double e){

		List<Achievement> a;
		
		//Preparing parameters for Hibernate query
		Map<String, Object> hqlParams = new HashMap<String, Object>();
		hqlParams.put("nMax", n+1);
		hqlParams.put("nMin", n-1);
		hqlParams.put("eMax", e+1);
		hqlParams.put("eMin", e-1);
		
		
		//Preparing Hibernate Query
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Query hqN = session.createQuery("from Achievement A WHERE (A.locationN <= :nMax) AND  (A.locationN >= :nMin) AND"
    			+ "(A.locationE <= :eMax) AND (A.locationE >= :eMin)");
    	
    	//applying parameters to query
    	for (Entry<String, Object> entry : hqlParams.entrySet()) {
			hqN.setParameter(entry.getKey(), entry.getValue());
		}
    	
    	a = (List<Achievement>)hqN.list();
    	session.getTransaction().commit();
    	session.getSessionFactory().getCurrentSession().close();
		return a.toArray(new Achievement[a.size()]);
	}

}
