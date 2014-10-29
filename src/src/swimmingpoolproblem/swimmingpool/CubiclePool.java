package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.resources.ResourcePool;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nbResources) {
		super (nbResources);
	}
	
	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}
	
}
