package swimmingpoolTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import lespetitsactionsalapiscine.models.actions.Action;
import lespetitsactionsalapiscine.models.actions.ForeseeableAction;
import lespetitsactionsalapiscine.models.actions.schedulers.FairScheduler;
import lespetitsactionsalapiscine.models.actions.schedulers.Scheduler;

import org.junit.Test;

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
