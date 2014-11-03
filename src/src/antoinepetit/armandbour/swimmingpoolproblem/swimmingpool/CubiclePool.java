package src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.resources.ResourcePool;

/**
 * CubiclePool describes a pool providing cubicles to swimmers.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nbResources) {
		super (nbResources);
	}
	
	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}
	
}
