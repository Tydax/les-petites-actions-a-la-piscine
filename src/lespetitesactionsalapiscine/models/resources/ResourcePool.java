package lespetitesactionsalapiscine.models.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The ResourcePool class describes a pool containing some Resources which can be taken
 *  from it and then freed back to the pool. 
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */
public abstract class ResourcePool<R extends Resource> {

	/** The list of the resources which can be taken from the pool. */
	protected LinkedList<R> mAvailableRes;
	
	/** The list of the resources which are borrowed at the current time. */
	protected LinkedList<R> mProvidedRes;

	/**
	 * Constructor taking one parameter. Creates a ResourcePool with the specified number of resources.
	 * @param nbResources The number of resources to initialise in the pool.
	 */
	public ResourcePool(int nbResources) {
		mAvailableRes = new LinkedList<R>();
		mProvidedRes = new LinkedList<R>();
		for (int i = 0; i < nbResources; i++) {
			mAvailableRes.add(createResource());
		}
	}

	/**
	 * Template method to create the specified type of Resource.
	 * @return A new Resource.
	 */
	protected abstract R createResource();

	/**
	 * Provides a resource from the pool if at least one exists.
	 * @return A resource.
	 * @throws NoSuchElementException when no resource can be provided.
	 */
	public R provideResource() throws NoSuchElementException {
		R rs;
		if (mAvailableRes.isEmpty())
			throw new NoSuchElementException("No resource available");
		else {
			rs = mAvailableRes.remove();
			return rs;
		}
	}

	/**
	 * Frees a resource which was borrowed from the pool.
	 * @param resource The freed resource that should be retrieved.
	 * @throws IllegalArgumentException when the resource was not provided by this pool.
	 */
	public void freeResource(R resource) throws IllegalArgumentException {
		if (mProvidedRes.remove(resource)) {
			mAvailableRes.add(resource);
		} else
			throw new IllegalArgumentException(
					"The pool doesn't manage this resource");
	}

}