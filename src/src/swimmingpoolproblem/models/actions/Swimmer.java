package src.swimmingpoolproblem.models.actions;

import src.swimmingpoolproblem.models.actions.schedulers.SequentialScheduler;
import src.swimmingpoolproblem.models.resources.Basket;
import src.swimmingpoolproblem.models.resources.BasketPool;
import src.swimmingpoolproblem.models.resources.Cubicle;
import src.swimmingpoolproblem.models.resources.CubiclePool;
import src.swimmingpoolproblem.models.resources.ResourcefulUser;

public class Swimmer extends SequentialScheduler {

	private String mName;
	private ResourcefulUser<Cubicle> mCubicleUser;
	private ResourcefulUser<Basket> mBasketUser;

	public Swimmer(String name, BasketPool basket, CubiclePool cubicle,
			int undress, int swim, int dress) {
		mName = name;
		mBasketUser = new ResourcefulUser<Basket>();
		mCubicleUser = new ResourcefulUser<Cubicle>();
		addAction(new TakeResourceAction<Basket>(basket, mBasketUser));
		addAction(new TakeResourceAction<Cubicle>(cubicle, mCubicleUser));
		addAction(new ForeseeableAction(undress));
		addAction(new FreeResourceAction<Cubicle>(cubicle, mCubicleUser));
		addAction(new ForeseeableAction(swim));
		addAction(new TakeResourceAction<Cubicle>(cubicle, mCubicleUser));
		addAction(new ForeseeableAction(dress));
		addAction(new FreeResourceAction<Cubicle>(cubicle, mCubicleUser));
		addAction(new FreeResourceAction<Basket>(basket, mBasketUser));
	}

	public String getName() {
		return mName;
	}
}
