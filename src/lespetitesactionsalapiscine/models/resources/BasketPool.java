package lespetitesactionsalapiscine.models.resources;

/**
 * BasketPool represents a pool of {@link Basket} to provide Basket.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class BasketPool extends ResourcePool<Basket> {
	
	/**
	 * Constructor with one paramater creating a BasketPool with the specified number of baskets.
	 * @param nbBaskets The number of basket that the pool can provide.
	 */
	public BasketPool(int nbBaskets) {
		super(nbBaskets);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

}