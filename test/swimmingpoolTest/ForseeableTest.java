package swimmingpoolTest;
import static org.junit.Assert.assertTrue;
import lespetitsactionsalapiscine.models.actions.Action;
import lespetitsactionsalapiscine.models.actions.ForeseeableAction;

import org.junit.Test;



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
