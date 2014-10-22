package src.swimmingpoolproblem.models.actions.schedulers;

import java.util.NoSuchElementException;

import src.swimmingpoolproblem.models.actions.Action;


/**
 * FairScheduler handles multiple Actions and make them a progress each simultaneously.<br>
 * In a nutshell, FairScheduler takes the first Action in the list, makes it progress when {@link #doStep()}
 * is called, then takes the second Action, makes it progress, and so on.
 * 
 * @author Armand BOUR
 * @author Antoien PETIT
 */

public class FairScheduler extends Scheduler {

	/**
	 * Constructor with an undefined number of parameters.
	 * @param actions The Actions that the Scheduler has to handle.
	 */
	public FairScheduler(Action ... actions) {
		super(actions);
	}
	
	@Override
	protected Action nextAction() {
		if(!mIt.hasNext()) {
			mIt = mActions.iterator();
		}
		
		Action res = null;
		
		try {
			res = mIt.next();
		}
		catch(NoSuchElementException nseExc) {
			System.out.println("coucou");
		}
		return res;
	}
}
