package src.swimmingpoolproblem.models.actions;

/**
 * ForeseeableAction describes an Action which progression is defined by a specified number of steps.
 * @author Armand BOUR
 * @author Antoine PETIT
 */

public class ForeseeableAction extends Action {

	/** The number of steps remaining necessary to finish the Action. */
	protected int mNbSteps;
	
	/**
	 * Constructor with one parameter.
	 * @param nb The number of steps necessary to finish the Action.
	 */
	public ForeseeableAction(int nb) {
		super();
		mNbSteps = nb;
	}
	
	@Override
	protected void step() throws ActionFinishedException {
		mNbSteps--;
	}

	@Override
	public boolean isFinished() {
		return mNbSteps == 0;
	}

}
