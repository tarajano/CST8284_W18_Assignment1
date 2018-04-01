/**
 * 
 */
package cst8284.triviatime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Manuel Alonso Tarajano (tarajano@gmail.com)
 * Apr 1, 2018  
 */
public class Results {
  
  private static HBox resultsPane;
  private static HBox pieChartBox;
  private static VBox textSummaryBox;
  private static int[] answersResults = new int[Controls.getNumOfQuestions()];
  
  
  private static VBox getTextSummaryBox() {return textSummaryBox;}  
  private static HBox getPieChartBox() {return pieChartBox;}
  private static int getNumQuestions() {return Controls.getNumOfQuestions();}
  public static void scoreCurrQuestion(int currQuest) {answersResults[currQuest]++;}
  
  public static HBox getQuizResultSummaryBox() {
    setQuizResultSummary();
    return resultsPane;
  }
  
  private static void setQuizResultSummary() {
    resultsPane = new HBox();
    setTextSummaryBox();
    setPieChartBox();
    resultsPane.getChildren().addAll(getTextSummaryBox(), getPieChartBox());
  }
  
  private static void setTextSummaryBox() {
    textSummaryBox = new VBox();
    textSummaryBox.getChildren().add(new Text("Results by question:"));
    for(int i=0; i < answersResults.length ; i++)
      textSummaryBox.getChildren().add(new Text((i+1) + ") " + (answersResults[i] == 1 ? "Pass" : "Fail")));
  }
  
  private static void setPieChartBox() {
    // http://www.java2s.com/Tutorials/Java/JavaFX/0810__JavaFX_Pie_Chart.htm
    pieChartBox = new HBox();
    PieChart pc = new PieChart();
    pc.setData(getChartData( getNumCorrectAnswers() , getNumQuestions() ));
    pieChartBox.getChildren().add(pc);
  }
  
  private static ObservableList<Data> getChartData(int okQ, int totQ) {
    // http://www.java2s.com/Tutorials/Java/JavaFX/0810__JavaFX_Pie_Chart.htm
    ObservableList<Data> answer = FXCollections.observableArrayList();  
    answer.addAll(new PieChart.Data("Correct", okQ),
                  new PieChart.Data("Incorrect", totQ - okQ));
    return answer;
  }
  
  private static int getNumCorrectAnswers() {
    int correctAnswers = 0;
    for (int i : answersResults)
      correctAnswers += i;
    return correctAnswers;
  }
  
  public static void resetAnswersResults() {
    for (int i=0; i < answersResults.length; i++)
      answersResults[i]=0;
  }
  
}
