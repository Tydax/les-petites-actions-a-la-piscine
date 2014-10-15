package swimmingpoolTest;

import static org.junit.Assert.fail;
import lespetitesactionsalapiscine.models.resources.Resource;
import lespetitesactionsalapiscine.models.resources.ResourcePool;

import org.junit.Test;

public abstract class ResourcePoolTest<R extends Resource> {

	public abstract ResourcePool<R> createResourcePool();
	
	@Test
	public void testResourcePool() {
		;
	}

	@Test
	public void testCreateResource() {
		fail("Not yet implemented");
	}

	@Test
	public void testProvideResource() {
		fail("Not yet implemented");
	}

	@Test
	public void testFreeResource() {
		fail("Not yet implemented");
	}

}
