package cst8284.triviatime;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class QAPane {
   private RadioButton[] rbAr;
   private VBox qaPane;
   ToggleGroup radioBtnGroup;
   
   // TODO: Add a QAPane constructor that takes as an argument QA object. The object's
   // should be used to load the question and potential answer into the center pane
   // along with radio buttons next to each answer.
   // TODO Rather than use the default font,
   // your output will look considerably better is you use the .setStyle() method
   // to improve the look of the user interface.
   // See the Assignment 1 document for details on implementing the button handler
   // for this method
   public QAPane(QA qa) {
     this.setQAPane(configQAPaneVBox(qa));
   }

   // TODO: write a method getAnswerPane() that takes as arguments an array of Strings
   // corresponding to the array of answers returned by getAnswers() and returns
   // a VBox loaded with radio buttons next to each string.  You'll need to load
   // each radio button into a toggle group.  Again, see the Assignment 1 document
   // for details
   public VBox getAnswerPane(String[] answers) { // maybe this method must be private
     radioBtnGroup = new ToggleGroup();
     VBox vbox = new VBox();
     VBox btnvbox = new VBox();
     btnvbox.setSpacing(5);
     RadioButton rb;
     
     for (String answer : answers) {
       rb = new RadioButton(answer);
       rb.setToggleGroup(radioBtnGroup);
       btnvbox.getChildren().add(rb);
     }
     vbox.getChildren().add(btnvbox);
     
     return vbox;
     
   }
   
   public VBox getQuestionPane(String question) { // maybe this method must be private
     VBox vbox = new VBox();
     vbox.getChildren().add( this.setTxt(question) );
     return vbox;
   }
   
   public VBox getRightAnswerPane(String question) { // maybe this method must be private
     VBox vbox = new VBox();
     vbox.getChildren().add( this.setTxt(question) );
     return vbox;
   }
   
//   public VBox getSingleStringVBox(String string) { // maybe this method must be private
//     VBox vbox = new VBox();
//     vbox.getChildren().add( this.setTxt(string) );
//     return vbox;
//   }
   
   private Text setTxt(String text) {
     Text t = new Text();
//   t.setFill(Color.BLUE);
//   t.setFont(Font.font(null, FontWeight.BOLD, 32));
     t.setText(text);
     return t;
   }
   
   
   // TODO write a method getRadioButtonSelected() that returns the number of the 
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
	
   private void setQAPane(VBox vb) {this.qaPane = vb;}
   public VBox getQAPane() {return qaPane;}
   
   private VBox configQAPaneVBox(QA qa) {
     VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.getChildren().addAll(this.getQuestionPane(qa.getQuestion()), 
                               this.getAnswerPane(qa.getAnswers()),
                               this.getThatsMyAnswerBtn(),
                               Controls.getNextQuestionPane());
     return vbox;
   }

   private HBox getThatsMyAnswerBtn() {
     HBox btnBox = new HBox();  
     Button btn = new Button("That's my answer");
     btn.setOnAction(new ThatsMyAnswerBtnHndlr());
     btnBox.getChildren().add(btn);
     return btnBox;
   }
   
   private class ThatsMyAnswerBtnHndlr implements EventHandler<ActionEvent>{
     @Override
     public void handle(ActionEvent e){
       // TODO
       this.disableRadioBtns();
       this.disableAnwserBtn();
       this.enableNxtQBtn();
       // Show feedback
       // Enable nxtQbtn
     }
     
     private void disableRadioBtns() {
       for(Toggle t : radioBtnGroup.getToggles()) {
         RadioButton rb = (RadioButton) t;
         rb.setDisable(true);
       }
    }
     
    private void disableAnwserBtn() {
      qaPane.getChildren().get(2).setDisable(true);
    }
    
    private void enableNxtQBtn() {
      HBox hb = (HBox) qaPane.getChildren().get(3);
      hb.getChildren().get(0).setDisable(false);
    }
    
    private void getAwnserFeedBack() {
      
    }
     
   }


    
}
