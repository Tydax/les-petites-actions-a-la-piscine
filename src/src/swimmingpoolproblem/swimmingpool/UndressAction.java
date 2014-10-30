package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.ForeseeableAction;

public class UndressAction extends ForeseeableAction {
		
	public UndressAction(int nb) {
		super(nb);
	}
	
	@Override
	public String description() {
		return "\tundressing " + super.description(); 
	}
}
