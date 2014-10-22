package src.swimmingpoolproblem.models.resources;

/**
 * The Resource interface describes a resource which can be contained in a {@link ResourcePool} and
 * which can be provided to a {@link ResourcefulUser}.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public interface Resource {

	/**
	 * Returns a description of the Resource.
	 * @return A description of the Resource.
	 */
	public String description();
	
}