package src.swimmingpoolproblem.swimmingpool;

import src.swimmingpoolproblem.models.actions.Action;
import src.swimmingpoolproblem.models.actions.ForeseeableAction;
import src.swimmingpoolproblem.models.actions.FreeResourceAction;
import src.swimmingpoolproblem.models.actions.TakeResourceAction;
import src.swimmingpoolproblem.models.actions.schedulers.Scheduler;
import src.swimmingpoolproblem.models.actions.schedulers.SequentialScheduler;
import src.swimmingpoolproblem.models.resources.Resource;
import src.swimmingpoolproblem.models.resources.ResourcePool;
import src.swimmingpoolproblem.models.resources.ResourcefulUser;

/**
 * The Swimmer class describes a Swimmer at the swimming pool executing several actions in
 * a sequential order.<br><br>
 * Here are the actions that the swimmer needs to execute:
 * <ol>
 * 		<li>take a {@link Basket};</li>
 * 		<li>go into a {@link Cubicle};</li>
 * 		<li>get undressed;</li>
 * 		<li>free the cubicle;</li>
 * 		<li>swim;</li>
 * 		<li>go into a cubicle;</li>
 * 		<li>get dressed;</li>
 * 		<li>free the cubicle;</li>
 * 		<li>free his basket.</li>
 * </ol>
 * To modelise these actions, the Swimmer class uses the {@link Resource}, {@link ResourcePool},
 * {@link Action}, and {@link Scheduler} models created.
 * @author Armand BOUR
 * @author Antoine PETIT
 *
 */
public class Swimmer extends SequentialScheduler {

	/** The swimmer's name. */
	private String mName;
	/** The user taking a cubicle from a pool. */
	private ResourcefulUser<Cubicle> mCubicleUser;
	/** The user taking a basket from a pool. */
	private ResourcefulUser<Basket> mBasketUser;

	/**
	 * Creates a Swimmer with all the Actions to execute contained in the Scheduler itself.
	 * @param name The name of the Swimmer.
	 * @param basket The {@link BasketPool} which should provide the basket.
	 * @param cubicle The {@link CubiclePool} which should provide the cubicle.
	 * @param undress The number of steps that the swimmer takes to undress.
	 * @param swim The number of steps that the swimmer takes to swim.
	 * @param dress the number of steps that the swimmer takes to dress.
	 */
	public Swimmer(String name, BasketPool basket, CubiclePool cubicle,
			int undress, int swim, int dress) {
		// Initialise fields
		mName = name;
		mBasketUser = new ResourcefulUser<Basket>();
		mCubicleUser = new ResourcefulUser<Cubicle>();
		
		// Initialise scheduler with all actions
		
		// Take a basket
		addAction(new TakeResourceAction<Basket>(basket, mBasketUser));
		// Go into a cubicle
		addAction(new TakeResourceAction<Cubicle>(cubicle, mCubicleUser));
		// Undress
		addAction(new ForeseeableAction(undress));
		// Free the cubicle
		addAction(new FreeResourceAction<Cubicle>(cubicle, mCubicleUser));
		// Swim
		addAction(new ForeseeableAction(swim));
		// Go into a cubicle
		addAction(new TakeResourceAction<Cubicle>(cubicle, mCubicleUser));
		// Dress
		addAction(new ForeseeableAction(dress));
		// Free the cubicle
		addAction(new FreeResourceAction<Cubicle>(cubicle, mCubicleUser));
		// Free the basket
		addAction(new FreeResourceAction<Basket>(basket, mBasketUser));
	}

	/**
	 * Gets the swimmer's name.
	 * @return The swimmer's name.
	 */
	public String getName() {
		return mName;
	}
}
