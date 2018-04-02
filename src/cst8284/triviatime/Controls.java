package cst8284.triviatime;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;

public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	
	private static Stage stage;
	private static int currentQuestion = 0;
	
	private static QA[] qaArray;
	private static BorderPane bp;
	private static QAPane qaPane;
	
	private static String absPath = "/Dropbox/Dropbox/eclipse-workspace/CST8284_W18_Assignment1/src/cst8284/triviatime/triviaQAFiles/ComputerTrivia_Java100.trivia";
  private static int numObjects = 3;
  
	/***************** MenuBar *****************/
 
	// : design a method getMenuBar() that returns a MenuBar,
	// suitable for loading into the top panel of a BorderPane
	public static MenuBar getMenuBar(Stage primaryStage) {
	  MenuBar mnuBar = new MenuBar();
	  setStage(primaryStage);
	  mnuBar.getMenus().addAll(getMnuFile(), getMnuSettings(), getMnuHelp());
	  return mnuBar;
	}
	
	/******************* Menu ******************/
	// : design a method getMnuFile() that returns a File Menu;
	// this can then loaded into the MenuBar
	private static Menu getMnuFile() {
	  mnu = new Menu("File");
	  mnu.getItems().addAll(getMnuItmNewGame(), getMnuItmExit());
	  return mnu;
	}

	// : design a method getMnuSettings() that returns a Settings Menu;
	// This should be disabled to now; we'll use it later on
  private static Menu getMnuSettings() {
    mnu = new Menu("Settings");
    mnu.setDisable(true);
    return mnu;
  }
  
	// : design a method getMnuHelp() that returns a Help Menu
  private static Menu getMnuHelp() {
    mnu = new Menu("Help");
    mnu.getItems().addAll(getMnuItmAbout());
    return mnu;	  
	}
	
	/***************** MenuItems *****************/
	
	// : design a method called getMnuItmNewGame() that returns a New Game MenuItem
	// Clicking this menu item causes a new .triv to be opened
	// and the objects it contains to be loaded into an array.
	// Each array element contains question and answer information
	// that can be displayed in the center panel of the borderpane
  private static MenuItem getMnuItmNewGame() {
    /* From Marco Jakob, code.makery, */
    /* http://code.makery.ch/blog/javafx-dialogs-official/ */
    mnuItm = new MenuItem("New Game");
    mnuItm.setOnAction((ActionEvent e) -> {
      Stage pStage = getStage(); 
      bp = (BorderPane) pStage.getScene().getRoot();
      resetGame();
      setQAArray();
      setNxtPane();
    });
    return mnuItm; 
  }
	
	// : design a method that return the Exit MenuItem
  private static MenuItem getMnuItmExit() {
    /* From Marco Jakob, code.makery, */
    /* http://code.makery.ch/blog/javafx-dialogs-official/ */
    mnuItm = new MenuItem("Exit");
    mnuItm.setOnAction(actionEvent -> Platform.exit());
    return mnuItm;
  }
  
	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Author: Manuel Alonso\nYear: 2018");
			alert.showAndWait();
		});
		return mnuItm;
	}
	
	private static void resetGame() {
	  resetQuestionNumber();
	  Results.resetAnswersResults();
	}
	
	private static void resetQuestionNumber() {
	  currentQuestion = 0;
	}
	
	private static void setStage(Stage s) {stage=s;}
	public static Stage getStage() {return stage;}
	
  //: design a method getNextQuestionPane() that returns an HBox 
  // containing the 'Next Question' button, along with the code need to 
	// advance to the next question using the currentQuestion variable above
	public static HBox getNextQuestionPane() {
	  HBox btnNxtQHBox = new HBox();  
    Button btnNxtQ = new Button("Next Question");
    btnNxtQ.setDisable(true);
    btnNxtQ.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e){
        incrementQuestionNumber();
        setNxtPane();
      }
    });
    btnNxtQHBox.getChildren().add(btnNxtQ);
    return btnNxtQHBox;
	}
	
  private static VBox getNxtQPane() {
    qaPane = new QAPane(qaArray[ getCurrentQuestionNumber() ]);
    return qaPane.getQAPane();
  }
  
	private static QA[] getQATriviaFileArray() {
    FileUtils.setQAArray(getAbsPath(), getNumObjects());
    return FileUtils.getQAArray();
	}

	private static String getAbsPath() {return absPath;}
	private static int getNumObjects() {return numObjects;}
  public static int getNumOfQuestions() {return getNumObjects();}
  private static void setQAArray() {qaArray = getQATriviaFileArray();}
  public static int getCurrentQuestionNumber() {return currentQuestion;}
  private static int incrementQuestionNumber() {return currentQuestion+=1;}

  private static void setNxtPane() {
    VBox nxtPane = getNxtQPane(); 
    bp.setCenter(nxtPane);
    BorderPane.setAlignment(nxtPane, Pos.CENTER );
  }
  
  
}
