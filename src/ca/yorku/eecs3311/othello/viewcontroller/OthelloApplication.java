package ca.yorku.eecs3311.othello.viewcontroller;
import ca.yorku.eecs3311.othello.model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put 
	// --module-path "/usr/share/openjfx/lib" --add-modules javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.
	
	@Override
	public void start(Stage stage) throws Exception {
		// Create and hook up the Model, View and the controller
		
		// MODEL
		Othello othello=new Othello();
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
		OthelloGUIController controller = new OthelloGUIController(othello);
	
		// VIEW
		// VIEW->CONTROLLER hookup
		// MODEL->VIEW hookup
		OthelloGUI guiView = new OthelloGUI(controller);

		
		// SCENE
		Scene scene = new Scene(guiView);
		stage.setTitle("Othello");
		stage.setScene(scene);
				
		// LAUNCH THE GUI
		stage.show();
		controller.play();
	}

	public static void main(String[] args) {
		OthelloApplication view = new OthelloApplication();
		launch(args);
	}

	/**
	 * @param p: character representing the player
	 * @return the corresponding color of player in game
	 */
	public static String playerColorName(char p){
		if (p == OthelloBoard.P1){
			return "White";
		}else if(p == OthelloBoard.P2){
			return "Black";
		}else{
			return "UNK";
		}
	}
}
