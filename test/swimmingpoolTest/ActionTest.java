package swimmingpoolTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import lespetitsactionsalapiscine.models.actions.Action;
import lespetitsactionsalapiscine.models.actions.ActionFinishedException;
import lespetitsactionsalapiscine.models.actions.ActionState;

import org.junit.Test;


public abstract class ActionTest {

	protected abstract Action createAction();
	
	@Test (expected = ActionFinishedException.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException  {
		Action action = createAction();
		while (!action.isFinished()) {
			try {
				action.doStep();
			}
			catch (ActionFinishedException e){
				fail("action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(action.isFinished());
		action.doStep(); //this sould throw the ActionFinishedException
	}
	
	@Test 
	public void stateOfActionTest() throws ActionFinishedException {
		Action action= createAction();
		assertEquals(ActionState.READY,action.getState()); 
		action.doStep();
		assertEquals(ActionState.IN_PROGRESS,action.getState());
		while (!action.isFinished())
			action.doStep();
		assertEquals(ActionState.FINISHED,action.getState());
		}
	
}
