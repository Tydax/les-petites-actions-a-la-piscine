package src.antoinepetit.armandbour.swimmingpoolproblem.models.actions;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.Resource;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcePool;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcefulUser;

/**
 * FreeResourceAction describes an Action which attempts to free a Resource taken by a {@link ResourcefulUser}
 * back to the specified pool.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 * @param <R> The type of {@link Resource} to free in this Action.
 */
public class FreeResourceAction<R extends Resource> extends Action {

	/** The pool from which the Resource has been taken. */
	protected final ResourcePool<R> mPool;
	/** The user to whom the Resource has been assigned. */
	protected final ResourcefulUser<R> mUser;
	
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		mPool = pool;
		mUser = user;
	}
	
	@Override
	protected void step() throws ActionFinishedException, IllegalArgumentException {
		mPool.freeResource(mUser.getResource());
		mUser.resetResource();
	}

	@Override
	public boolean isFinished() {
		return mUser.getResource() == null;
	}
	
	@Override
	public String description() {
		return "\tfreeing resource from " + mPool.RESOURCE_DESC.toLowerCase() + " pool...\n";
	}
}
