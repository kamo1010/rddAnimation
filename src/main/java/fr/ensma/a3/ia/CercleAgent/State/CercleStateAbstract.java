package fr.ensma.a3.ia.CercleAgent.State;

import fr.ensma.a3.ia.CercleAgent.CercleModel;
import fr.ensma.a3.ia.CercleAgent.CerclePresentation;

public abstract class CercleStateAbstract implements CercleIState {

	protected CerclePresentation pres;
	protected CercleModel model;
	
	public CercleStateAbstract(CerclePresentation p, CercleModel m) {
		pres = p; model = m;
	}
	
	public void toStop() throws CercleStateException {
		throw new CercleStateException();
	}
	
	public void toBounce() throws CercleStateException {
		throw new CercleStateException();
	}
	
}
