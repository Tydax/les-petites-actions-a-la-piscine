package lespetitesactionsalapiscine.models.resources;

/**
 * Interface describing a Resource. Implementing this Interface in a class allows one to
 * use this class as a Resource in a {@link ResourcePool}.
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