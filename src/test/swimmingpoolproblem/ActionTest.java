package test.swimmingpoolproblem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ActionFinishedException;
import src.swimmingpoolproblem.models.actions.ActionState;


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
				fail("Action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(action.isFinished());
		action.doStep(); // This should throw the ActionFinishedException
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
