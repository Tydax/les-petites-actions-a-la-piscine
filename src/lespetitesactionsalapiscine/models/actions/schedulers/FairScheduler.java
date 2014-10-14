package lespetitsactionsalapiscine.models.actions.schedulers;

import lespetitsactionsalapiscine.models.actions.Action;

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
	protected void step() {
		// TODO implement
	}

	@Override
	protected Action nextAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
