package src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.ForeseeableAction;

/**
 * DressAction describes an action where a swimmer get dressed in a specified amount of steps.
 * @author Armand BOUR
 * @author Antoine PETIT
 * @see ForeseeableAction
 */
public class DressAction extends ForeseeableAction {
	
	public DressAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tdressing " + super.description(); 
	}
}
