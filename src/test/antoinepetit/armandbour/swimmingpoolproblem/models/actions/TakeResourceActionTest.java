package test.antoinepetit.armandbour.swimmingpoolproblem.models.actions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.Action;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.TakeResourceAction;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcefulUser;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.Basket;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.BasketPool;

public class TakeResourceActionTest extends ActionTest {

	private BasketPool mPool;
	private ResourcefulUser<Basket> mUser;
	
	@Override
	public void initialiseFields() {
		mPool = new BasketPool(1);
		mUser = new ResourcefulUser<Basket>();
		super.initialiseFields();
	}
	
	@Override
	protected Action createAction() {
		return new TakeResourceAction<Basket>(mPool, mUser);
	}

	@Test
	public void testTakingResource() throws Exception {
		mAction.doStep();
		assertNotNull(mUser.getResource());
		// Action is supposed to be finished since we have managed to provide a Resource
		assertTrue(mAction.isFinished());
	}
	
	@Test
	public void testTakingResourceWhileNoneIsAvailable() throws Exception {
		mPool.provideResource();
		mAction.doStep();
		assertNull(mUser.getResource());
		// Action is not finished because no Resource has been provided
		assertFalse(mAction.isFinished());
	}
}
