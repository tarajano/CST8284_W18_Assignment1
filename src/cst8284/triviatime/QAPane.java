package cst8284.triviatime;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QAPane {
   private VBox qaPane;
   private ToggleGroup radioBtnGroup;
   private QA qa;
   private VBox vbox;
   
   // : Add a QAPane constructor that takes as an argument QA object. The object's
   // should be used to load the question and potential answer into the center pane
   // along with radio buttons next to each answer.
   //  Rather than use the default font,
   // your output will look considerably better is you use the .setStyle() method
   // to improve the look of the user interface.
   // See the Assignment 1 document for details on implementing the button handler
   // for this method
   public QAPane(QA qa) {
     this.setQA(qa);
     this.setQAPane(configQAPaneVBox(qa));
   }
   
   private void setQA(QA qa) {this.qa = qa;}
   private void setQAPane(VBox vb) {this.qaPane = vb;}
   public VBox getQAPane() {return qaPane;}

   // : write a method getAnswerPane() that takes as arguments an array of Strings
   // corresponding to the array of answers returned by getAnswers() and returns
   // a VBox loaded with radio buttons next to each string.  You'll need to load
   // each radio button into a toggle group.  Again, see the Assignment 1 document
   // for details
   public VBox getAnswerPane(String[] answers) { // maybe this method must be private
     radioBtnGroup = new ToggleGroup();
     vbox = new VBox();
     VBox btnvBox = new VBox();
     btnvBox.setSpacing(5);
     RadioButton rb;
     
     for (String answer : answers) {
       rb = new RadioButton(answer);
       rb.setToggleGroup(radioBtnGroup);
       rb.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
           HBox hb = (HBox) qaPane.getChildren().get(2);
           hb.getChildren().get(0).setDisable(false);
          }
       });
       btnvBox.getChildren().add(rb);
     }
     
     vbox.getChildren().add(btnvBox);
     return vbox;
   }
   
   public VBox getQuestionPane(String question) { // maybe this method must be private
     vbox = new VBox();
     vbox.getChildren().add( new Text(question) );
     return vbox;
   }
   
   public VBox getRightAnswerPane(String question) { // maybe this method must be private
     vbox = new VBox();
     vbox.getChildren().add( new Text(question) );
     return vbox;
   }
   
   // write a method getRadioButtonSelected() that returns the number of the 
   // radio button selected.  One way to do this is to loop through each radio button
   // in the radio button array and test if isSelected() is set
   public int getRadioButtonSelected() {
     int i = 1;
     for(Toggle t : radioBtnGroup.getToggles()) {
       RadioButton rb = (RadioButton) t;
       if ( rb.isSelected() )
         return i;
       i++;
     }
     return 0;
   }
	
   private VBox configQAPaneVBox(QA qa) {
     VBox vbox = new VBox();
     vbox.setAlignment(Pos.CENTER);
     vbox.setSpacing(5);
     vbox.getChildren().addAll(this.getQuestionPane(qa.getQuestion()), 
                               this.getAnswerPane(qa.getAnswers()),
                               this.getThatsMyAnswerBtn(),
                               Controls.getNextQuestionPane());
     // TODO Create hbox for buttons alone
//     HBox btnsBox = new HBox();
//     btnsBox.getChildren().addAll(this.getThatsMyAnswerBtn(), Controls.getNextQuestionPane());
//     vbox.getChildren().addAll(this.getQuestionPane(qa.getQuestion()), 
//                               this.getAnswerPane(qa.getAnswers()), btnsBox);
     return vbox;
   }

   private HBox getThatsMyAnswerBtn() {
     HBox btnBox = new HBox();  
     Button btn = new Button("That's my answer");
     btn.setDisable(true);
     btn.setOnAction(new ThatsMyAnswerBtnHndlr());
     btnBox.getChildren().add(btn);
     return btnBox;
   }
   
   private class ThatsMyAnswerBtnHndlr implements EventHandler<ActionEvent>{
     @Override
     public void handle(ActionEvent e){
       this.disableRadioBtns(true);
       this.disableAnwserBtn(true);
       if (Controls.getCurrentQuestionNumber() < Controls.getNumOfQuestions() - 1)
         this.disableNxtQBtn(false);
       else
         this.setShowResultsBtn();
       this.getAnwserFeedBack();
     }
     
     private void setShowResultsBtn() {
       HBox hb = (HBox) qaPane.getChildren().get(3);
       Button btn = (Button) hb.getChildren().get(0);
       btn.setText("Show results");
       btn.setDisable(false);
       btn.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
           btn.setDisable(true);
           Stage pStage = Controls.getStage(); 
           BorderPane bp = (BorderPane) pStage.getScene().getRoot();
           bp.setCenter(Results.getQuizResultSummaryBox());
           //qaPane.getChildren().add(Results.getQuizResultSummaryBox()); // TODO fix/center position of results pane
          }
       });
     }
     
     private void disableRadioBtns(boolean b) {
       for(Toggle t : radioBtnGroup.getToggles()) {
         RadioButton rb = (RadioButton) t;
         rb.setDisable(b);
       }
    }
     
    private void disableAnwserBtn(boolean b) {qaPane.getChildren().get(2).setDisable(b);}
    
    private void disableNxtQBtn(boolean b) {
      HBox hb = (HBox) qaPane.getChildren().get(3);
      hb.getChildren().get(0).setDisable(b);
    }
    
    private void getAnwserFeedBack() {
      if (qa.getCorrectAnswerNumber() == getRadioButtonSelected()) {
        qaPane.getChildren().add(new Text("That's correct!"));
        Results.scoreCurrQuestion( Controls.getCurrentQuestionNumber() );
      }else{
        qaPane.getChildren().add(new Text("That's incorrect! " + qa.getExplanation() ));
      }
    }
     
   }


    
}
