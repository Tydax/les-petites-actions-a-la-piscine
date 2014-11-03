package src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.Resource;

/**
 * The Basket class describes a basket containing clothes.
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
