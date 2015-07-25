package com.gester.GesterAchievementServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User u = new User();
        u.setEmail("test@test.com");
        u.setFacebook("test@test.com");
        u.setInstagram("test@bla.com");
        u.setTwitter("labernicht");
        
        
        
        Achievement a1 = createAchievement("Dat Erste", "Dies ist ein Achievement,"
        		+ " nähe Info Institut", 1, 52.456417, 13.296004);
        Achievement a2 = createAchievement("Dat Zweite", "Dies ist auch ein Achievement,"
        		+ "nähe BBTor", 2, 52.516135, 13.376738);
        Achievement a3 = createAchievement("Dat Dritte", "und noch eins nähe Home"
        		, 1, 52.470678, 13.298371);
        Achievement a4 = createAchievement("Way Off", "Schleswig zum Testen von "
        		+ "Entfernung", 2, 54.514530, 9.542438);
        
        session.save(u);
        session.save(a1);
        session.save(a2);
        session.save(a3); 
        session.save(a4);
        session.getTransaction().commit();
        session.getSessionFactory().getCurrentSession().close();
        return "Got it!";
    }
    
    private static Achievement createAchievement (String name, String d, int g, 
    		double locn, double loce){
    	Achievement a = new Achievement();
        a.setName(name);
        a.setDescription(d);
        a.setGfxId(g);
        a.setLocationN(locn);
        a.setLocationE(loce);
    	return a;
    }
}
