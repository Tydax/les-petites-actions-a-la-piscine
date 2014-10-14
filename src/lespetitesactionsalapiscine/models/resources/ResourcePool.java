package lespetitesactionsalapiscine.models.resources;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<R extends Resource> {

	protected List<R> mAvailableRes;
	protected List<R> mProvidedRes;

	public ResourcePool(int nbResources) {
		mAvailableRes = new LinkedList<R>();
		mProvidedRes = new LinkedList<R>();

		for(int i=0 ; i < nbResources ; i++) {
			mAvailableRes.add(createResource());
		}
	}

	protected abstract R createResource();

	public R provideResource() throws NoSuchElementException {
		// TODO: implement
		return null;
	}

	public void freeResource(R resource) throws IllegalArgumentException {
		// TODO: implement
	}

}