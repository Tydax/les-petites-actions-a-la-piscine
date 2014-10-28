package src.swimmingpoolproblem.models.resources;

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
		return "A cubicle to get undress or dress in";
	}

}
