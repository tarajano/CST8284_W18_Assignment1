package cst8284.triviatime;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	
	private static Stage stage;
	private static int currentQuestion = 0;

	/***************** MenuBar *****************/
 
	// TODO: design a method getMenuBar() that returns a MenuBar,
	// suitable for loading into the top panel of a BorderPane

	
	/******************* Menu ******************/

	// TODO: design a method getMnuFile() that returns a File Menu;
	// this can then loaded into the MenuBar

	// TODO: design a method getMnuSettings() that returns a Settings Menu;
	// This should be disabled to now; we'll use it later on

	// TODO: design a method getMnuHelp() that returns a Help Menu
	
	
	/***************** MenuItems *****************/

	// TODO: design a method called getMnuItmNewGame() that returns a New Game MenuItem
	// Clicking this menu item causes a new .triv to be opened
	// and the objects it contains to be loaded into an array.
	// Each array element contains question and answer information
	// that can be displayed in the center panel of the borderpane
	
	// TODO: design a method that return the Exit MenuItem
	
	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Author: YOUR NAME GOES HERE; 6 MARKS OFF IF YOU SCREW THIS UP");
			alert.showAndWait();
		});
		return mnuItm;
	}
	
	private static void setStage(Stage s) {stage= s;}
	private static Stage getStage() {return stage;}
	
    // TODO: design a method getNextQuestionPane() that returns an HBox 
    // containing the 'Next Question' button, along with the code need to 
	// advance to the next question using the currentQuestion variable above
}
