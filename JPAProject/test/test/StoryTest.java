package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Entities.Story;

public class StoryTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Story stry;
	
	@Before
	public void setUp() throws Exception{
		this.emf = Persistence.createEntityManagerFactory("YourPU");
		this.em = emf.createEntityManager();
		stry = em.find(Story.class, 1);
	}
	
	@Test
	public void test() {
		boolean pass = true;
		assertEquals(pass, true);
	}
	
	@Test
	public void connectionTest() {
		stry = em.find(Story.class, 1);
		assertEquals("To Kill a Mockingbird", stry.getTitle());
	}
	
	@After
	public void tearDown() {
		
	}

}
