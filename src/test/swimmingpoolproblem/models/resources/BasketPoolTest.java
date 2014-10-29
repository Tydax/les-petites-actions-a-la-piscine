package test.swimmingpoolproblem.models.resources;

import src.swimmingpoolproblem.models.resources.ResourcePool;
import src.swimmingpoolproblem.swimmingpool.Basket;
import src.swimmingpoolproblem.swimmingpool.BasketPool;

public class BasketPoolTest extends ResourcePoolTest<Basket> {


	@Override
	public ResourcePool<Basket> createResourcePool() {
		return new BasketPool(12);		
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}

}
