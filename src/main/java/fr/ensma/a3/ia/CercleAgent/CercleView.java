package fr.ensma.a3.ia.CercleAgent;

import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CercleView extends Circle implements CercleIView {

	private Reflection r;
	private CerclePresentation pres;
	private static double offsetTampon, opacityTampon;
	
	public CercleView(Integer i, CerclePresentation p) {
		super(i);
		pres = p;
		double d = pres.getKernel().getReflectionOffset();
		offsetTampon = pres.getKernel().getTamponLimit();
		opacityTampon = pres.getKernel().getOpacityTampon();
		r = new Reflection(d, 0.25, 0.1, 0);
		setEffect(r);
		setCenterX(pres.getKernel().getX());
		setCenterY(pres.getKernel().getY());
		setFill(Color.ALICEBLUE);
	}
	
	public void notifyAccess(boolean b) {
		if (b) {
			setCenterX(pres.getModel().getX());
			setCenterY(pres.getModel().getY());
			double d = pres.getKernel().getReflectionOffset();
			r.setTopOffset(d);
			r.setTopOpacity(opacityTampon * (1 - d / offsetTampon));
		}
	}

}
