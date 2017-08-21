package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.WalkDAO;
import entities.Walk;


@RestController
public class WalkController {
	@RequestMapping(path = "walks/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@Autowired
	private WalkDAO dao;
	
	@RequestMapping(path="walks", method=RequestMethod.GET)
	public List<Walk> index(){
		return dao.index();
	}
	
	@RequestMapping(path="walks/{id}", method=RequestMethod.GET)
	public Walk show(@PathVariable int id) {
		return dao.show(id);
	}
	
	@RequestMapping(path = "walks", method = RequestMethod.POST)
	 public Walk create(@RequestBody String walkJSON, HttpServletResponse res) {
	        if (walkJSON != null) {
	            res.setStatus(202);
	            ObjectMapper mapper = new ObjectMapper();
	            Walk newWalk = null;
	            try {
	                newWalk = mapper.readValue(walkJSON, Walk.class);
	                return dao.create(newWalk);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            
	        }
	        res.setStatus(400);
	        return null;

	    }
	
	@RequestMapping(path = "walks/{id}", method = RequestMethod.PUT)
    public Walk update(@PathVariable int id, @RequestBody String walkJSON, HttpServletResponse res) {
        if (walkJSON != null) {
            res.setStatus(202);
            ObjectMapper mapper = new ObjectMapper();
            Walk updatedWalk = null;
            try {
                updatedWalk = mapper.readValue(walkJSON, Walk.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dao.update(id, updatedWalk);
        }
        res.setStatus(400);
        return null;
    }
	
	@RequestMapping(path = "walks/{id}", method = RequestMethod.DELETE)
    public boolean destroy(@PathVariable int id) {

        return dao.destroy(id);
    }
	
	
	
	

}
