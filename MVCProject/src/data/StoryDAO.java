package data;

import java.util.List;

import Entities.Story;

public interface StoryDAO {
		
	public List<Story> index (int uid);
	
	public Story show(int uid, int tid);
	
	public Story create(int uid, String todoJson);
	
	public Story update(int uid, int tid, String todoJson);
	
	public Boolean destroy(int uid, int tid);
	
		
}
