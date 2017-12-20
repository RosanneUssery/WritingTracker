package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import Entities.Story;

@Transactional
@Repository
public class StoryDAOImpl implements StoryDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Story> index() {
		String query = "Select s FROM Story s";
		List<Story> stories = em.createQuery(query, Story.class).getResultList();
		return stories;
	}

	@Override
	public Story show(int id) {
		return em.find(Story.class, id);
	}

	@Override
	public Story create(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Story newStory = mapper.readValue(json, Story.class);
			em.persist(newStory);
			em.flush();
			return newStory;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Story update(int id, String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Story storyManaged = em.find(Story.class, id);
			Story changed = mapper.readValue(json, Story.class);
			storyManaged.setTitle(changed.getTitle());
			return storyManaged;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean destroy(int id) {
		Story s = em.find(Story.class, id);
		em.remove(s);
		if(em.find(Story.class, id) != null) {
			return false;
		} else {
		return true;
		}
	}

}