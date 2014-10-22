package test.swimmingpoolproblem;

import src.swimmingpoolproblem.models.resources.Basket;
import src.swimmingpoolproblem.models.resources.BasketPool;
import src.swimmingpoolproblem.models.resources.ResourcePool;

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
