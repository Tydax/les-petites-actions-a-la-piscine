package test.swimmingpoolproblem;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ForeseeableAction;



public class ForseeableTest extends ActionTest {

	protected Action createAction(){
		return new ForeseeableAction(3);
	}
	
	@Test
	public void foreseeableGoodTimeTest() throws Exception {
		Action action = createAction();
		for(int i=1;i<=3;i++)
			action.doStep();
		assertTrue(action.isFinished());
	}

}
