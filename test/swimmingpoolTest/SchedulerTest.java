package swimmingpoolTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import lespetitsactionsalapiscine.models.actions.Action;
import lespetitsactionsalapiscine.models.actions.ForeseeableAction;
import lespetitsactionsalapiscine.models.actions.schedulers.Scheduler;

import org.junit.Test;

public abstract class SchedulerTest extends ActionTest {

	public abstract Scheduler createScheduler(Action ... actions);
	

	public class OneStepAction extends ForeseeableAction {
		public OneStepAction() {
			super(1);
		}
	}
	
	@Override
	protected Action createAction() {
	return createScheduler (new OneStepAction());
	}

	@Test 
	public void with1OneStepAction() throws Exception {
		OneStepAction action1 = new OneStepAction();
		Scheduler scheduler= createScheduler(action1);
				
		assertFalse(scheduler.isFinished());
		assertFalse(action1.isFinished());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isFinished());
		assertTrue(action1.isFinished());
	}
	
	@Test
	public void allStepFinishedAction() throws Exception {
		OneStepAction action1= new OneStepAction();
		OneStepAction action2= new OneStepAction();
		Scheduler scheduler = createScheduler(action1,action2);
		while (!scheduler.isFinished()) {
			scheduler.doStep();
		}
		
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
	}

}
