package fr.ensma.a3.ia.CercleAgent.State;

public interface CercleIState {
	
	public void toStop() throws CercleStateException;
	public void toBounce() throws CercleStateException;

}
