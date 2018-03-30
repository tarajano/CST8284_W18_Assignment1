package cst8284.triviatime;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
   
   // TODO: Add a QAPane constructor that takes as an argument QA object. The object's
   // should be used to load the question and potential answer into the center pane
   // along with radio buttons next to each answer.
   // TODO Rather than use the default font,
   // your output will look considerably better is you use the .setStyle() method
   // to improve the look of the user interface.
   // See the Assignment 1 document for details on implementing the button handler
   // for this method
   public QAPane(QA qa) {
     
//     VBox questionVBox = this.getSingleStringVBox(qa.getQuestion());
//     VBox answersVBox = this.getAnswerPane(qa.getAnswers());
//     VBox explanationVBox = this.getSingleStringVBox(qa.getExplanation());
     
     //qaPane.getChildren().addAll(questionVBox,answersVBox,explanationVBox);
     //qaPane.getChildren().addAll(answersVBox);
   }

   // TODO: write a method getAnswerPane() that takes as arguments an array of Strings
   // corresponding to the array of answers returned by getAnswers() and returns
   // a VBox loaded with radio buttons next to each string.  You'll need to load
   // each radio button into a toggle group.  Again, see the Assignment 1 document
   // for details
   public VBox getAnswerPane(String[] answers) { // maybe this method must be private
     ToggleGroup radioBtnGroup = new ToggleGroup();
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
   
   public VBox getSingleStringVBox(String string) { // maybe this method must be private
     VBox vbox = new VBox();
     vbox.getChildren().add( this.setTxt(string) );
     return vbox;
   }
   
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
	
   private void setQAPane(VBox vb) {this.qaPane = vb;}
   public VBox getQAPane() {return qaPane;}
}
