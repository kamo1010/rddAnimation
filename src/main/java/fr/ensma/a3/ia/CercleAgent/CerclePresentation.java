package fr.ensma.a3.ia.CercleAgent;

import fr.ensma.a3.ia.MouvementKernel;
import fr.ensma.a3.ia.CercleAgent.State.CercleIState;
import fr.ensma.a3.ia.CercleAgent.State.CercleStateBouncing;
import fr.ensma.a3.ia.CercleAgent.State.CercleStateException;
import fr.ensma.a3.ia.CercleAgent.State.CercleStateStop;

public class CerclePresentation {
	
	private static CercleModel model;
	private static CercleIView view;
	private CercleIState currentState, stopState, bounceState;
	private static MouvementKernel kernel;
	private static BallBouncing bouncerTh;
	
	public CerclePresentation() {
		kernel = new MouvementKernel();
		bouncerTh = new BallBouncing();
		model = new CercleModel();
		stopState = new CercleStateStop(this, model);
		bounceState = new CercleStateBouncing(this, model);
		currentState = stopState;
	}
	
	public void setView(CercleIView v) {
		view = v;
	}

	public CercleIState getStopState() {
		return stopState;
	}
	
	public CercleIState getBounceState() {
		return bounceState;
	}

	public void setCurrentState(CercleIState state) {
		currentState = state;
	}

	public void actionStartMove() {
		try {
			currentState.toBounce();
		} catch (CercleStateException e) {
			e.printStackTrace();
		}
		bouncerTh.start();
	}

	public MouvementKernel getKernel() {
		// TODO Auto-generated method stub
		return kernel;
	}
	
	public static class BallBouncing extends Thread {
		@Override
		public void run() {
			while (model.isBouncing()){
				kernel.getProcessing().run();
				model.setX(kernel.getX());
				model.setY(kernel.getY());
				view.notifyAccess(model.isBouncing());
				try{
					Thread.sleep(kernel.getDelay()) ;
				} catch (InterruptedException ex){
				}
			}
		}
	}

	public CercleModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public void closeTasks() {
		kernel.getProcessing().interrupt();
		bouncerTh.interrupt();
	}

	public BallBouncing getBouncerTh() {
		return bouncerTh;
	}
	
	public void push() {
		kernel.modifyV();
		kernel.modifyU();
	}

	public void actionExit() {
		try {
			currentState.toStop();
		} catch (CercleStateException e) {
			e.printStackTrace();
		}
	}
}
