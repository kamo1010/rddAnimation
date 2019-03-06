package fr.ensma.a3.ia;

import java.util.Random;

public class MouvementKernel {
	
	private static double x, y, u, v;
	private static double xI = 50, yI = 50, uI = 100, vI = -100,
			uOnClick = 100, vOnClick = -100, g = 9.81,
			dt = 0.1, circleRadius = 150, opacityMin = 0.1, opacityMax = 0.7;
	private static int screenWidth = 1960, screenHeight = 1080,
			modesDeVitesse = 2, sol = 30, delay = 15;
	private static Processing processing;
	private static Random r;
	
	public MouvementKernel() {
		x = circleRadius; y = circleRadius;
		u = uI; v = -vI;
		processing = new Processing();
		r = new Random();
	}
	
	
	public int getDelay() {
		return delay;
	}
	
	public double getOpacityTampon() {
		return opacityMax - opacityMin;
	}
	
	public Processing getProcessing() {
		return processing;
	}
	
	public int getWidth() {
		return screenWidth;
	}
	
	public int getHeight() {
		return screenHeight;
	}
	
	public double getRadius() {
		return circleRadius;
	}
	
	public int getX() {
		return (int) Math.round(x);
	}
	
	public int getY() {
		return (int) Math.round(y);
	}

	public int getU() {
		return (int) Math.round(u);
	}

	public int getV() {
		return (int) Math.round(v);
	}

	public static double getuI() {
		return uI;
	}

	public static double getvI() {
		return -vI;
	}
	
	public static double getxI() {
		return xI;
	}

	public static double getyI() {
		return yI;
	}

	public static double getuOnClick() {
		return uOnClick;
	}

	public void setU(double u) {
		MouvementKernel.u = u;
	}

	public void setV(double v) {
		MouvementKernel.v = v;
	}

	public void setX(double x) {
		MouvementKernel.x = x;
	}

	public void setY(double y) {
		MouvementKernel.y = y;
	}

	public static double getvOnClick() {
		return vOnClick;
	}

	public static double getG() {
		return g;
	}

	public static double getDt() {
		return dt;
	}
	
	public static void bounceLeft() {
		u = -u;
	}
	
	public static void bounceRight() {
		u = -u;
	}
	
	public static void bounceDown() {
		v = -v;
	}
	
	public static void bounceUp() {
		v = -v;
	}
	
	public static void bounce() {
		if (x < circleRadius) {
			bounceLeft();
			x = circleRadius;
		}
		if (x > screenWidth - circleRadius-37) {
			bounceRight();
			x = screenWidth - circleRadius-37;
		}
		if (y < circleRadius) {
			bounceUp();
			y = circleRadius;
		}
		if (y > screenHeight - circleRadius - sol) {
			bounceDown();
			y = screenHeight - circleRadius - sol;
		}
	}
	
	public void reset() {
		x = 0; y = 0;
		u = uI; v = -vI;
	}
	
	public static void proceedOnce() {
		v = v - g * dt;
		x = x + u * dt;
		y = y - v * dt;
		bounce();
	}
	
	public static class Processing extends Thread {
		@Override
		public void run() {
			proceedOnce();
			try {
				sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void modifyU() {
		u = (r.nextInt(2 * modesDeVitesse + 1) - modesDeVitesse) * uOnClick;
	}

	public void modifyV() {
		v = -(r.nextInt(modesDeVitesse + 1) + 1) * vOnClick;
	}
	
	public int getReflectionOffset() {
		return (int) (screenHeight - (sol + y + circleRadius));
	}

	public double getTamponLimit() {
		return screenHeight - (sol + 2 * circleRadius);
	}

}
