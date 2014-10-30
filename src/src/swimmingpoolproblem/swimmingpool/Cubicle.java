package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.resources.Resource;

/**
 * The Cubicle class describes a Cubicle where people can undress/dress
 * themselves.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class Cubicle implements Resource {

	@Override
	public String description() {
		return "Cubicle";
	}

}
