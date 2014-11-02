package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.resources.Resource;

/**
 * The Cubicle class describes a cubicle where people can get dressed or get undressed.
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
