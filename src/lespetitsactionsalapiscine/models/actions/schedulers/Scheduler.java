package lespetitsactionsalapiscine.models.actions.schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import lespetitsactionsalapiscine.models.actions.Action;
import lespetitsactionsalapiscine.models.actions.ActionState;

/**
 * The Scheduler class describes a Scheduler which handles multiple Action at a time.
 * The way that the Scheduler will handle the different Actions depends on its type.<br><br>
 * Scheduler extends {@link Action} because it acts like an Action, meaning that it has
 * a state, and it can be progressed using the {@link #doStep()} method. The Scheduler's state
 * is set to {@link ActionState#FINISHED} when all Actions inside it are finished.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */

public abstract class Scheduler extends Action {

	/** The list of Actions which the Scheduler has to progress. The list will be
	 * empty when all Actions are finished.
	 */
	protected final ArrayList<Action> mActions;
	
	/** The Iterator which gives access to the next Action. */
	protected Iterator<Action> mIt;
	
	/** A reference to the Action which will be progressed in the next call of {@link #doStep()} */
	protected Action mCurrAct;
	
	/**
	 * Constructor with an undefined number of parameters.
	 * @param actions The Actions that the Scheduler has to handle.
	 */
	
	public Scheduler(Action ... actions) {
		mActions = new ArrayList<Action>(Arrays.asList(actions));
		mIt = mActions.iterator();
	}
	
	@Override
	protected void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
