package lespetitesactionsalapiscine.models.resources;

public class BasketPool extends ResourcePool<Basket> {
	
	public BasketPool(int nbBaskets) {
		super(nbBaskets);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

}