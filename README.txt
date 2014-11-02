*** Simulation d'une gestion de ressources et d'Actions dans une piscine ***
*** Armand BOUR, Antoine PETIT ***
*** 02/11/2014 ***

Ce programme simule une gestion de piscine, interagissant avec des ressources limitées (corbeilles à vêtements, cabines)
en quantité gérées par des "pools", ainsi que des actions qui se déroulent sur une unité de temps abstraite.


** Interfaces et méthodes polymorphiques **

Resource, implémentée par Cubicle et Basket, qui est permet préciser le type paramétré des classes ResourcePool


*** Code samples ***

* Action *

	Action est impliquée dans le pattern de "template method" avec sa méthode protégé asbtraite "step()".
	Cette méthode permet de déléguer la gestion des étapes aux classes filles. doStep() définit un comportement
commun aux classes filles, et appelle step().


public void doStep() throws ActionFinishedException {
		// Gestion des états commune aux classes filles
		if(isFinished()) {
			throw new ActionFinishedException();
		}
		
		if(mState == ActionState.READY) {
			mState = ActionState.IN_PROGRESS;
		}
		
		// Appel à la template method step qui délègue le comportement aux classes filles
		step();
		
		if(isFinished()) {
			mState = ActionState.FINISHED;
		}
	}
	
Puis, dans la classe fille Scheduler :

@Override
protected void step() throws ActionFinishedException {
	mCurrAct.doStep();

	// Check if current action is finished to keep our list of actions clean
	if (mCurrAct.isFinished()) {
		mIt.remove();
	}

	// Get next action if the Scheduler is not empty
	/* Encore une fois, on délègue la gestion de l'ordre d'exécution des actions du scheduler
	   dans les classes filles de Scheduler via la méthode template nextAction() */
	mCurrAct = !isFinished() ? nextAction() : null; /*
											(if it is, just set to null so that the
											action can get garbage-collected) */
}

