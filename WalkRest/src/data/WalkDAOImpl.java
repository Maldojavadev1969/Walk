package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Walk;

@Transactional
public class WalkDAOImpl implements WalkDAO {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<Walk> index(){
	String query = "Select w from Walk w";
	return em.createQuery(query, Walk.class).getResultList();
	}
	
	
	public Walk show(int id){
		  return em.find(Walk.class, id);
		}
	
	@Override
    public Walk create(Walk walk) {
        em.persist(walk);
        em.flush();
        return em.find(Walk.class, walk.getId());
    }
	
	
	
	@Override
    public Walk update(int id, Walk walk) {
        Walk managed = null;
        try {
        
        			managed=em.find(Walk.class, id);
        			
        			if(walk.getDistance() > 0) {
            			managed.setDistance(walk.getDistance());
        			}
        			if(walk.getTime() > 0) {
            			managed.setTime(walk.getTime());

        			}
        			if(walk.getLocation() != null) {
            			managed.setLocation(walk.getLocation());

        			}
        			if(walk.getNotes() != null) {
            			managed.setNotes(walk.getNotes());

        			}
        			
       
    
        } catch (Exception e)  {
            e.printStackTrace();
        }
        return managed;
        
    }
	
	@Override
    public boolean destroy(int id) {
        Walk deleteWalk = em.find(Walk.class, id);  
        em.remove(deleteWalk);
        if (deleteWalk==null) {
            return false;
        }    
        return true;
    }

}
