package lespetitesactionsalapiscine.models.actions;

/**
 * Action class describes an action which progresses as we use the 
 * @author Armand BOUR
 * @author Antoine PETIT
 */
public abstract class Action {
	/** Field describing the current state of the Action. */
	protected ActionState mState;
	
	/** Template method called by {@link #doStep()}. 
	 * @throws ActionFinishedException TODO*/
	protected abstract void step() throws ActionFinishedException;
	
	public Action() {
		mState = ActionState.READY;
	}
	
	/**
	 * Progresses the Action.
	 * @throws ActionFinishedException if Action is already finished.
	 */
	public void doStep() throws ActionFinishedException {
		if(isFinished()) {
			throw new ActionFinishedException();
		}
		
		if(mState == ActionState.READY) {
			mState = ActionState.IN_PROGRESS;
		}
		
		step();
		
		if(isFinished()) {
			mState = ActionState.FINISHED;
		}
	}
	
	/** Gets whether the Action is finished or not.
	 * @return <code>true</code> if the Action is finished ;
	 * 			<code>false</code> else.
	 */
	public abstract boolean isFinished();
	
	/**
	 * Gets the current state of the Action.
	 * @return the current state of the Action.
	 */
	public ActionState getState() {
		return mState;
	}
}
