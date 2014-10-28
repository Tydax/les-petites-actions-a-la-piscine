package src.swimmingpoolproblem.models.resources;

/**
 * ResourcefulUser describes a user taking Resource from a pool.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 * @param <R> The type of Resource taken by the user.
 */
public class ResourcefulUser<R extends Resource> {

	
	/** The resource taken by the user. May be <code>null</code> if no Resource
	 * was assigned to the user.*/
	protected R mResource;

	public ResourcefulUser() {
		mResource =null;		
	}

	/** 
	 * Gets a reference to the Resource taken by the user.
	 * @return The Resource assigned to the user.<br>
	 * 			<code>null</code> if none was assigned.
	 */
	public R getResource() {
		return mResource;
	}

	/**
	 * Assigns a Resource to the user. 
	 * @param resource The Resource to assign to the user.
	 */
	public void setResource(R resource) {
		this.mResource = resource;
	}

	/**
	 * Sets the Resource of the user to null.
	 */
	public void resetResource() {
		this.mResource = null;
	}
}
