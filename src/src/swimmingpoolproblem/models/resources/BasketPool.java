package src.swimmingpoolproblem.models.resources;

/**
 * BasketPool describes a pool of Basket to use.
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