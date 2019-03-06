package fr.ensma.a3.ia.CercleAgent.State;

public class CercleStateException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "Already current state!";
	
	public CercleStateException() {
		super(message);
	}

}
