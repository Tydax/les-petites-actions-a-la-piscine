package src.antoinepetit.armandbour.swimmingpoolproblem.models.actions;

import java.util.NoSuchElementException;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.Resource;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcePool;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcefulUser;

/**
 * TakeResourceAction is an Action which attempts to take a Resource of the specified type
 * from a pool used in the constructor and give to the {@link ResourcefulUser}
 * specified in the constructor. <br>
 * The Action is finished when it managed to take a Resource from the pool and assigned it
 * to the ResourcefulUser.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 * @param <R> The type of {@link Resource} to take in this action.
 */
public class TakeResourceAction<R extends Resource> extends Action {

	/** The pool from which the Resource will be taken. */
	protected final ResourcePool<R> mPool;
	/** The user to whom the Resource will be assigned. */
	protected final ResourcefulUser<R> mUser;
	
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		mPool = pool;
		mUser = user;
	}
	
	@Override
	protected void step() throws ActionFinishedException {
		R res;
		
		try {
			res = mPool.provideResource();
			mUser.setResource(res);
			System.out.print("success\n");
		}
		catch(NoSuchElementException nseExc) {
			// Nothing to do with the exception
			System.out.print("failure\n");
		}
	}

	@Override
	public boolean isFinished() {
		return mUser.getResource() != null;
	}

	@Override
	public String description() {
		return "\ttrying to take resource from " + mPool.RESOURCE_DESC.toLowerCase() + " pool... ";
	}
}
