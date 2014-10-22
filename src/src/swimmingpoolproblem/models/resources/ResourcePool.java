package src.swimmingpoolproblem.models.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The ResourcePool class describes a pool containing some
 * Resources which can be taken from this pool and then freed back to the pool.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */
public abstract class ResourcePool<R extends Resource> {

	/** The list of resources which can be taken from the pool. */
	protected LinkedList<R> mAvailableRes;
	
	/** The list of resources which are borrowed at the current time. */
	protected LinkedList<R> mProvidedRes;

	/**
	 * Constructor taking the number of Resources assigned to the pool as a parameter.
	 * @param nbResources The number of Resources to assign to the pool.
	 */
	public ResourcePool(int nbResources) {
		mAvailableRes = new LinkedList<R>();
		mProvidedRes = new LinkedList<R>();
		for (int i = 0; i < nbResources; i++) {
			mAvailableRes.add(createResource());
		}
	}

	/**
	 * Factory method to initialise a Resource.
	 * @return A new Resource of type R.
	 */
	protected abstract R createResource();

	/**
	 * Provides a resource in the pool if there is at least a free one.
	 * @return A Resource.
	 * @throws NoSuchElementException If no Resource are available at the moment.
	 */
	public R provideResource() throws NoSuchElementException {
		R rs;
		if (mAvailableRes.isEmpty())
			throw new NoSuchElementException("No resource available");
		else {
			rs = mAvailableRes.remove();
			mProvidedRes.add(rs);
			return rs;
		}
	}

	/**
	 * Frees the specified Resource and put it back in the pool.
	 * @param resource The Resource to free.
	 * @throws IllegalArgumentException If the Resource was not borrowed from this pool.
	 */
	public void freeResource(R resource) throws IllegalArgumentException {
		if (mProvidedRes.remove(resource)) {
			mAvailableRes.add(resource);
		} else
			throw new IllegalArgumentException(
					"The pool doesn't manage this resource");
	}

}