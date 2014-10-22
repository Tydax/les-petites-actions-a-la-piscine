package test.swimmingpoolproblem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import src.swimmingpoolproblem.models.resources.Resource;
import src.swimmingpoolproblem.models.resources.ResourcePool;

public abstract class ResourcePoolTest<R extends Resource> {

	public abstract ResourcePool<R> createResourcePool();
	
	@Test
	public void testResourcePool() {
		ResourcePool<R> rs= createResourcePool();
		assertNotNull(rs);
	}

	@Test
	public void testProvideResource() {
		;
	}

	@Test
	public void testFreeResource() {
		fail("Not yet implemented");
	}

}
