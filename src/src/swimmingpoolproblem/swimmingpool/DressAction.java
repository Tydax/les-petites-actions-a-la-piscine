package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.ForeseeableAction;

public class DressAction extends ForeseeableAction {
	
	public DressAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tdressing " + super.description(); 
	}
}
