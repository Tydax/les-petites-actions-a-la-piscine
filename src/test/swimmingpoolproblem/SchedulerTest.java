package test.swimmingpoolproblem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ForeseeableAction;
import src.swimmingpoolproblem.models.actions.schedulers.Scheduler;

public abstract class SchedulerTest extends ActionTest {

	public abstract Scheduler createScheduler(Action ... actions);
	

	public class OneStepAction extends ForeseeableAction {
		public OneStepAction() {
			super(1);
		}
	}
	
	@Override
	protected Action createAction() {
	return createScheduler (new OneStepAction(), new OneStepAction());
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
