package test.swimmingpoolproblem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

import src.swimmingpoolproblem.models.resources.Resource;
import src.swimmingpoolproblem.models.resources.ResourcePool;

public abstract class ResourcePoolTest<R extends Resource> {

	public abstract ResourcePool<R> createResourcePool();
	public abstract R createResource();

	@Test
	public void testResourcePool() {
		ResourcePool<R> rs = createResourcePool();
		assertNotNull(rs);
	}

	@Test
	public void testProvideResource() {
		ResourcePool<R> rs = createResourcePool();
		assertNotNull(rs.provideResource());
	}

	@Test(expected = NoSuchElementException.class)
	public void testExceptionProvideResource() {
		ResourcePool<R> rs = createResourcePool();
		while (true) {
			rs.provideResource();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionFreeResource() {
		ResourcePool<R> rs = createResourcePool();
		R r= createResource();
		rs.freeResource(r);
	}
	
	@Test
	public void testFreeResource() {
		ResourcePool<R> rs = createResourcePool();
		R res = rs.provideResource();
		try {
			rs.freeResource(res);
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("Should have not throw an exception at this moment.");
		}
	}

}
