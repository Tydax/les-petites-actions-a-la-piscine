package lespetitsactionsalapiscine.models.actions.schedulers;

/**
 * FairScheduler handles multiple Actions and make them a progress each simultaneously.<br>
 * In a nutshell, FairScheduler takes the first Action in the list, makes it progress when {@link #doStep()}
 * is called, then takes the second Action, makes it progress, and so on.
 * 
 * @author Armand BOUR
 * @author Antoien PETIT
 */

public class FairScheduler extends Scheduler {

	@Override
	protected void step() {
		// TODO implement
	}
}
