package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.ForeseeableAction;

/**
 * DressAction describes an action where a swimmer get undressed in a specified amount of steps.
 * @author Armand BOUR
 * @author Antoine PETIT
 * @see ForeseeableAction
 */
public class UndressAction extends ForeseeableAction {
		
	public UndressAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tundressing " + super.description(); 
	}
}
