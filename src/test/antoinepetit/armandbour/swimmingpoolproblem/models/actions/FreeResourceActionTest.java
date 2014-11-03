package test.antoinepetit.armandbour.swimmingpoolproblem.models.actions;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.Action;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.FreeResourceAction;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcefulUser;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.Basket;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.BasketPool;

public class FreeResourceActionTest extends ActionTest {

	private BasketPool mPool;
	private ResourcefulUser<Basket> mUser;
	
	@Override
	public void initialiseFields() {
		mPool = new BasketPool(1);
		mUser = new ResourcefulUser<Basket>();
		mUser.setResource(mPool.provideResource());
		super.initialiseFields();
	}
	
	@Override
	protected Action createAction() {
		return new FreeResourceAction<Basket>(mPool, mUser);
	}

	@Test
	public void testFreeResource() throws Exception {
		mAction.doStep();
		assertNull(mUser.getResource());
		assertTrue(mAction.isFinished());
	}
}
