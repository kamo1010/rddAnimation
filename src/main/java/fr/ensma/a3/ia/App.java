package fr.ensma.a3.ia;

import fr.ensma.a3.ia.CercleAgent.CerclePresentation;
import fr.ensma.a3.ia.CercleAgent.CercleView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application implements EventHandler<KeyEvent> {
	
	private CerclePresentation cPres;
	private CercleView cView;
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		Pane root = new Pane();
		cPres = new CerclePresentation();
		cView = new CercleView((int) cPres.getKernel().getRadius(), cPres);
		cPres.setView(cView);
		root.getChildren().add(cView);
		root.setCursor(Cursor.NONE);
		Scene scene = new Scene(root, cPres.getKernel().getWidth(), cPres.getKernel().getHeight(), Color.BLACK);
		stage.setScene(scene);
		stage.setFullScreenExitHint("");
		stage.setResizable(false);
		stage.setMaximized(true);
		stage.setFullScreen(true);
		stage.addEventHandler(KeyEvent.KEY_PRESSED, this);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              cPres.closeTasks();
	          }
	      });
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void handle(KeyEvent arg0) {
		if (arg0.getCode().equals(KeyCode.SPACE)) {
			if (!cPres.getBouncerTh().isAlive()) {
				cPres.actionStartMove();
			}
			else {
				cPres.push();
			}
		}
		if (arg0.getCode().equals(KeyCode.ENTER)) {
			if (stage.isFullScreen()) {
				stage.setFullScreen(false);
			}
			else {
				stage.setFullScreen(true);
			}
		}
		if (arg0.getCode().equals(KeyCode.ESCAPE)) {
			cPres.actionExit();
			stage.close();
		}
		arg0.consume();
	}
}
