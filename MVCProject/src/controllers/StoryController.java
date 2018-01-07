package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Entities.Story;
import data.StoryDAO;

@RestController
public class StoryController {
	
	@Autowired
	private StoryDAO storyDAO;
	
	@RequestMapping(path="story/ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "/user/{uid}/story", method = RequestMethod.GET)
	public List<Story> index(HttpServletRequest req, HttpServletResponse resp, @PathVariable("uid") int uid) {
		return storyDAO.index(uid);
	}
	
	@RequestMapping(path = "/user/{uid}/story/{tid}", method = RequestMethod.GET)
	public Story show(HttpServletRequest req, HttpServletResponse res, @PathVariable("uid") int uid, @PathVariable("tid") int tid) {
		return storyDAO.show(uid, tid);
	}
	
	@RequestMapping(path = "/user/{uid}/story", method = RequestMethod.POST) 
	public Story create(HttpServletRequest req, HttpServletResponse res, @PathVariable("uid") int uid, @RequestBody String json) {
		return storyDAO.create(uid, json);
	}
	
	@RequestMapping(path = "/user/{uid}/story/{tid}", method = RequestMethod.PUT)
	public Story update(HttpServletRequest req, HttpServletResponse res, @PathVariable("uid") int uid, @PathVariable("tid") int tid,  @RequestBody String json) {
		return storyDAO.update(uid, tid, json);
	}
	
	@RequestMapping(path = "/user/{uid}/story/{tid}", method = RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable("uid") int uid, @PathVariable("tid") int tid) {
		return storyDAO.destroy(uid, tid);
	}

}
