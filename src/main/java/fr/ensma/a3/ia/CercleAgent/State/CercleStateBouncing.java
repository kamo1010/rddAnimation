package fr.ensma.a3.ia.CercleAgent.State;

import fr.ensma.a3.ia.CercleAgent.CercleModel;
import fr.ensma.a3.ia.CercleAgent.CerclePresentation;

public class CercleStateBouncing extends CercleStateAbstract {
	
	public CercleStateBouncing(CerclePresentation p, CercleModel m) {
		super(p, m);
	}

	@Override
	public void toStop() throws CercleStateException {
		pres.setCurrentState(pres.getStopState());
		model.setBouncing(false);
	}
	
}
