package src.swimmingpoolproblem.models.actions.schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ActionFinishedException;
import src.swimmingpoolproblem.models.actions.ActionState;

/**
 * The Scheduler class describes a Scheduler which handles multiple Action at a
 * time. The way that the Scheduler will handle the different Actions depends on
 * its type.<br>
 * <br>
 * Scheduler extends {@link Action} because it acts like an Action, meaning that
 * it has a state, and it can be progressed using the {@link #doStep()} method.
 * The Scheduler's state is set to {@link ActionState#FINISHED} when all Actions
 * inside it are finished.
 * 
 * @author Armand BOUR
 * @author Antoine PETIT
 */

public abstract class Scheduler extends Action {

	/**
	 * The list of Actions which the Scheduler has to progress. The list will be
	 * empty when all Actions are finished.
	 */
	protected final List<Action> mActions;

	/** The Iterator which gives access to the next Action. */
	protected Iterator<Action> mIt;

	/**
	 * A reference to the Action which will be progressed in the next call of
	 * {@link #doStep()}
	 */
	protected Action mCurrAct;

	/**
	 * Constructor with an undefined number of parameters.
	 * 
	 * @param actions
	 *            The Actions that the Scheduler has to handle.
	 */
	public Scheduler(Action... actions) {
		super();
		mActions = new ArrayList<Action>(Arrays.asList(actions));
		mIt = mActions.iterator();

		if (!isFinished()) {
			mCurrAct = mIt.next();
		}
	}

	/**
	 * Template method to get the next Action in the Scheduler.
	 * 
	 * @return The next Action to iterate.
	 */
	protected abstract Action nextAction();

	@Override
	protected void step() throws ActionFinishedException {
		System.out.print(mCurrAct.description());
		mCurrAct.doStep();

		// Check if current action is finished to keep our list of actions clean
		if (mCurrAct.isFinished()) {
			mIt.remove();
		}

		// Get next action if the Scheduler is not empty
		mCurrAct = !isFinished() ? nextAction() : null; /*
												(if it is, just set to null so that the
												action can get garbage-collected) */
	}

	@Override
	public boolean isFinished() {
		return mActions.isEmpty();
	}

	/**
	 * Adds an action to the Scheduler, and resets the iterator to the first action.
	 * @param action The action to add.
	 */
	public void addAction(Action action) {
		mActions.add(action);
		mIt = mActions.iterator();
		mCurrAct = mIt.next();
	}
	
	@Override
	public String description() {
		return "";
	}
}
