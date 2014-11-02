package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.ForeseeableAction;
/**
 * SwimAction describes an action where a swimmer swims in a specified number of steps.
 * @author Armand BOUR
 * @author Antoine PETIT
 * @see ForeseeableAction
 */
public class SwimAction extends ForeseeableAction {
	
	public SwimAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tswimming " + super.description(); 
	}
}
