package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import Entities.Story;
import Entities.User;

@Transactional
@Repository
public class StoryDAOImpl implements StoryDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Story> index(int uid) {
		String query = "Select s FROM Story s";
		List<Story> stories = em.createQuery(query, Story.class).getResultList();
		return stories;
	}

	@Override
	public Story show(int uid, int tid) {
		return em.find(Story.class, tid);
	}

	@Override
	public Story create(int uid, String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Story newStory = mapper.readValue(json, Story.class);
			User u = em.find(User.class, uid);
			newStory.setUserId(u);
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
	public Story update(int uid, int tid, String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Story storyManaged = em.find(Story.class, tid);
			Story changed = mapper.readValue(json, Story.class);
			storyManaged.setTitle(changed.getTitle());
			storyManaged.setWordcount(changed.getWordcount());
			return storyManaged;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean destroy(int uid, int tid) {
		Story s = em.find(Story.class, tid);
		em.remove(s);
		if(em.find(Story.class, tid) != null) {
			return false;
		} else {
		return true;
		}
	}

}