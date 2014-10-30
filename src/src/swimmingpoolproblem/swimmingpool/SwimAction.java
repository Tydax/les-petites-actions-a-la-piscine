package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.ForeseeableAction;

public class SwimAction extends ForeseeableAction {
	
	public SwimAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tswimming " + super.description(); 
	}
}
