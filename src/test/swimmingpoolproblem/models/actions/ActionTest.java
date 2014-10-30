package test.swimmingpoolproblem.models.actions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ActionFinishedException;
import src.swimmingpoolproblem.models.actions.ActionState;


public abstract class ActionTest {

	protected Action mAction;
	
	protected abstract Action createAction();
	
	@Before
	public void initialiseFields() {
		mAction = createAction();
	}
	
	@Test (expected = ActionFinishedException.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException  {
		while (!mAction.isFinished()) {
			try {
				mAction.doStep();
			}
			catch (ActionFinishedException e){
				fail("Action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(mAction.isFinished());
		mAction.doStep(); // This should throw the ActionFinishedException
	}
	
	@Test 
	public void stateOfActionTest() throws ActionFinishedException {
		assertEquals(ActionState.READY,mAction.getState()); 
		mAction.doStep();
		
		while (!mAction.isFinished()) {
			assertEquals(ActionState.IN_PROGRESS,mAction.getState());			
			mAction.doStep();
		}
		
		assertEquals(ActionState.FINISHED,mAction.getState());
	}
}
