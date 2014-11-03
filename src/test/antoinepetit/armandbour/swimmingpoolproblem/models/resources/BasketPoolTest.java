package test.antoinepetit.armandbour.swimmingpoolproblem.models.resources;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcePool;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.Basket;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.BasketPool;

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
