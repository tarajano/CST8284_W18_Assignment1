package cst8284.triviatime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TriviaTimeLaunch extends Application {
	/**  @Copyright Dave Houtman 2018.  For use in Winter 2018 - CST8284 classes only */
	
	private static BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage){	
	   // Display Splash Screen
	   setRootPane("Welcome to Trivial Time");
	   getRootPane().setTop(Controls.getMenuBar(primaryStage));
	   Scene scene =  new Scene(getRootPane(), 1024, 512);
	   primaryStage.setTitle("Trivia Time");
	   primaryStage.setScene(scene);
	   primaryStage.show();	
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	//  TODO: build setRootPane(String), where the String is the logo in the Splashscreen
	//  You rootPane needs to be correctly set up so it can be loaded into the Scene
	//  using getRootPane(), as indicated in the code above
	
    //  TODO: build getRootPane(), which returns the rootPane stored in the variable declared above
		
}