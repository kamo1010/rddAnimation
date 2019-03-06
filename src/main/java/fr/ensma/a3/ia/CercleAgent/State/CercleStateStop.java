package fr.ensma.a3.ia.CercleAgent.State;

import fr.ensma.a3.ia.CercleAgent.CercleModel;
import fr.ensma.a3.ia.CercleAgent.CerclePresentation;

public class CercleStateStop extends CercleStateAbstract {
	
	public CercleStateStop(CerclePresentation p, CercleModel m) {
		super(p, m);
	}
	
	@Override
	public void toBounce() throws CercleStateException {
		pres.setCurrentState(pres.getBounceState());
		model.setBouncing(true);
	}
	
	@Override
	public void toStop() throws CercleStateException {
	}
}
