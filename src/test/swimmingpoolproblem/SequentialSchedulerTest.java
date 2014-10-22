package test.swimmingpoolproblem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ForeseeableAction;
import src.swimmingpoolproblem.models.actions.schedulers.Scheduler;
import src.swimmingpoolproblem.models.actions.schedulers.SequentialScheduler;

public class SequentialSchedulerTest extends SchedulerTest {

	@Override
	public Scheduler createScheduler(Action ... actions) {
		return new SequentialScheduler(actions); 
	}
	
	
	@Test
	public void twoStepSequentialTest() throws Exception {
		Action a1=new ForeseeableAction(2);
		Action a2=new ForeseeableAction(2);
		
		Scheduler scheduler = createScheduler(a1,a2);
		
		scheduler.doStep();
		scheduler.doStep();
		
		assertTrue(a1.isFinished());
		assertFalse(a2.isFinished());
		
		scheduler.doStep();
		scheduler.doStep();
		
		assertTrue(a1.isFinished());
		assertTrue(a2.isFinished());
	}


}
