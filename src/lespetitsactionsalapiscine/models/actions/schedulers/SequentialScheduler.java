package lespetitsactionsalapiscine.models.actions.schedulers;

import lespetitsactionsalapiscine.models.actions.Action;

/**
 * SequentialScheduler handles multiple Action by finishing them one at time.<br>
 * Basically, the Scheduler takes the first Action in the list, make it progress with each call
 * of {@link #doStep()}, and when it is finished, takes the second Action, and so on.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected void step() {
		// TODO implement
	}
}