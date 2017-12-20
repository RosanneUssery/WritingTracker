package controllers;

import java.util.List;

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
	
	@RequestMapping(path="story", method=RequestMethod.GET)
	public List<Story> index() {
		return storyDAO.index();
	}
	
	@RequestMapping(path="story/{id}", method=RequestMethod.GET)
	public Story show(@PathVariable int id) {
		return storyDAO.show(id);
	}
	
	@RequestMapping(path="story", method=RequestMethod.POST)
	public Story create(@RequestBody String json) {
		return storyDAO.create(json);
	}
	
	@RequestMapping(path="story/{id}", method=RequestMethod.PUT)
	public Story update(@PathVariable int id, @RequestBody String json) {
		return storyDAO.update(id, json);
	}
	
	@RequestMapping(path="story/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return storyDAO.destroy(id);
	}

}
