package src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcePool;

/**
 * BasketPool describes a pool of baskets which can be provided to swimmers.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class BasketPool extends ResourcePool<Basket> {
	
	/**
	 * Constructor with the number of baskets available in the pool.
	 * @param nbBaskets The number of baskets in the pool.
	 */
	public BasketPool(int nbBaskets) {
		super(nbBaskets);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

}