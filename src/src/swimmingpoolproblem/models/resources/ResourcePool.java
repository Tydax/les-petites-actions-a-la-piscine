package src.swimmingpoolproblem.models.resources;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The ResourcePool class describe a pool containing some Resources which can be take from this pool and then free it back to the pool    
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */
public abstract class ResourcePool<R extends Resource> {

	/** The list of the resources which can be take from the pool */
	protected LinkedList<R> mAvailableRes;
	
	/** The list of the resources which are borrow at the current time */
	protected LinkedList<R> mProvidedRes;

	public ResourcePool(int nbResources) {
		mAvailableRes = new LinkedList<R>();
		mProvidedRes = new LinkedList<R>();
		for (int i = 0; i < nbResources; i++) {
			mAvailableRes.add(createResource());
		}
	}

	protected abstract R createResource();

	/**
	 * Provide a resource in the pool if there is at least one resource in the pool
	 * @return The Resource if possible 
	 * @throws NoSuchElementException
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
	 * Free a resource which was borrow from the pool, if not throw the exception
	 * @param resource the resource which who want to free back in the pool
	 * @throws IllegalArgumentException
	 */
	public void freeResource(R resource) throws IllegalArgumentException {
		if (mProvidedRes.remove(resource)) {
			mAvailableRes.add(resource);
		} else
			throw new IllegalArgumentException(
					"The pool doesn't manage this resource");
	}

}