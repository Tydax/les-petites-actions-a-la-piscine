package src.antoinepetit.armandbour.swimmingpoolproblem;

import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.ActionFinishedException;
import src.antoinepetit.armandbour.swimmingpoolproblem.models.actions.schedulers.FairScheduler;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.BasketPool;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.CubiclePool;
import src.antoinepetit.armandbour.swimmingpoolproblem.swimmingpool.Swimmer;

public class Main {

	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler sche = new FairScheduler();
		
		sche.addAction(new Swimmer("Camille",baskets, cubicles,6,4,8));
		sche.addAction(new Swimmer("Loïs",baskets,cubicles,2,10,4));
		sche.addAction(new Swimmer("Maé", baskets,cubicles,10,18,10));
		sche.addAction(new Swimmer("Ange", baskets,cubicles,3,7,5));
		sche.addAction(new Swimmer("Louison", baskets,cubicles,18,3,3));
		sche.addAction(new Swimmer("Charlie", baskets,cubicles,3,6,10));
		sche.addAction(new Swimmer("Alexis", baskets,cubicles,6,5,7));
		
		int nbSteps = 0;
		while (!sche.isFinished()) {
			nbSteps++;
			sche.doStep();
		}
		
		System.out.println("\nFinished in "+ nbSteps + " steps.");
	}
}
