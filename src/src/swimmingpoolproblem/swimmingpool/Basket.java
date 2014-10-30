package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.resources.Resource;

/**
 * The Basket class describes a Basket containing clothes.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class Basket implements Resource {

	@Override
	public String description() {
		return "Basket";
	}

}
