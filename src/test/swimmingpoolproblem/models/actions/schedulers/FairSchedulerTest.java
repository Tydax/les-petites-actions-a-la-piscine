package test.swimmingpoolproblem.models.actions.schedulers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ForeseeableAction;
import src.swimmingpoolproblem.models.actions.schedulers.FairScheduler;
import src.swimmingpoolproblem.models.actions.schedulers.Scheduler;

public class FairSchedulerTest extends SchedulerTest {
	
	@Override
	public Scheduler createScheduler(Action ... actions) {
		return new FairScheduler (actions); 
	}
	
	@Test
	public void twoStepFairTest() throws Exception {
		Action a1=new ForeseeableAction(2);
		Action a2=new ForeseeableAction(2);
		
		Scheduler scheduler = createScheduler (a1,a2);
		
		scheduler.doStep();
		scheduler.doStep();
		
		assertFalse(a1.isFinished());
		assertFalse(a2.isFinished());
		
		scheduler.doStep();
		assertTrue(a1.isFinished());

		scheduler.doStep();
		assertTrue(a2.isFinished());
	}

}
