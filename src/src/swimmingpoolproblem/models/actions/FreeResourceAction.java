package src.swimmingpoolproblem.models.actions;

import src.swimmingpoolproblem.models.resources.Resource;
import src.swimmingpoolproblem.models.resources.ResourcePool;
import src.swimmingpoolproblem.models.resources.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends Action {

	/** The pool from which the Resource will be taken. */
	protected final ResourcePool<R> mPool;
	/** The user to whom the Resource will be assigned. */
	protected final ResourcefulUser<R> mUser;
	
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		mPool=pool;
		mUser=user;
	}
	
	@Override
	protected void step() throws ActionFinishedException {
		try
		{
			mPool.freeResource(mUser.getResource());
			mUser.resetResource();
		}
		catch (IllegalArgumentException iaeExc)
		{
			//In normal case you can't reach an exception
		}
		
	}

	@Override
	public boolean isFinished() {
		return mUser.getResource()==null;
	}

}
