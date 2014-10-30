package src.swimmingpoolproblem.models.actions;

/**
 * ForeseeableAction describes an Action which progression is defined by a specified number of steps.
 * @author Armand BOUR
 * @author Antoine PETIT
 */

public class ForeseeableAction extends Action {

	/** The number of steps remaining necessary to finish the Action. */
	protected int mNbSteps;
	
	/** The total number of steps. */
	protected final int mTotal;
	/**
	 * Constructor with one parameter.
	 * @param nb The number of steps necessary to finish the Action.
	 */
	public ForeseeableAction(int nb) {
		super();
		mNbSteps = nb;
		mTotal = nb;
	}
	
	/**
	 * Gets the number of steps remaining to finish the action.
	 * @return The number of steps remaining.
	 */
	public int getNbSteps() {
		return mNbSteps;
	}
	
	/**
	 * Gets the total number of steps necessary to finish the Action.
	 * @return The total number of steps.
	 */
	public int getTotalNbSteps() {
		return mTotal;
	}
	
	@Override
	protected void step() throws ActionFinishedException {
		mNbSteps--;
	}

	@Override
	public boolean isFinished() {
		return mNbSteps == 0;
	}

	/**
	 * Returns a description of the ForeeseeableAction using this format: "(1/6)" (1 being
	 * the number of steps done, and 6 the total number of steps necessary to finish the Action).
	 */
	@Override
	public String description() {
		return "(" + String.valueOf(mTotal - mNbSteps + 1) + "/" + String.valueOf(mTotal) + ")\n";
	}
}
