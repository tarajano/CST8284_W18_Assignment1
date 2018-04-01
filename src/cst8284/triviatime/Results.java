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

/**
 * @author Manuel Alonso Tarajano (tarajano@gmail.com)
 * Apr 1, 2018  
 */
public class Results {
  
  private HBox resultsPane;
  private int numCorrectAnswers, numQuestions;

  public Results(int okA, int totQ) {
    this.setNumCorrectAnswers(okA);
    this.setNumQuestions(totQ);
    this.setResultsPane();
  }
  
  // http://www.java2s.com/Tutorials/Java/JavaFX/0810__JavaFX_Pie_Chart.htm
  private HBox createResultsPieChartVBox() {
    HBox hb = new HBox();
    
    PieChart pieChart = new PieChart();
    pieChart.setTitle("Results");
    pieChart.setData(getChartData( this.getNumCorrectAnswers() , this.getNumQuestions() ));
    
//    PieChart pieChartPct = new PieChart();
//    pieChartPct.setTitle("Results Percentage");
//    pieChartPct.setData(getChartDataPct( this.getNumCorrectAnswers() , this.getNumQuestions() ));
//    pieChart.setLegendSide(Side.LEFT);
//    pieChart.setClockwise(false);
//    pieChart.setLabelsVisible(false);
    
//    hb.getChildren().addAll(pieChart, pieChartPct);
    hb.getChildren().add(pieChart);
    return hb; 
  }
//  
//  private ObservableList<Data> getChartDataPct(int okQ, int totQ) {
//    ObservableList<Data> answer = FXCollections.observableArrayList();
//    answer.addAll(new PieChart.Data("Correct", okQ*100/totQ),
//            new PieChart.Data("Incorrect", (totQ - okQ)*100/totQ)
//            );
//    return answer;
//  }
  
  private ObservableList<Data> getChartData(int okQ, int totQ) {
    ObservableList<Data> answer = FXCollections.observableArrayList();
    answer.addAll(new PieChart.Data("Correct", okQ),
            new PieChart.Data("Incorrect", totQ - okQ)
            );
    return answer;
  }
  
  public HBox getResultsPane() {
    return this.resultsPane;
  }

  private void setResultsPane() {
    this.resultsPane = this.createResultsPieChartVBox();
  }
  
  private int getNumCorrectAnswers() {
    return numCorrectAnswers;
  }

  private void setNumCorrectAnswers(int numCorrectAnswers) {
    this.numCorrectAnswers = numCorrectAnswers;
  }

  private int getNumQuestions() {
    return numQuestions;
  }

  private void setNumQuestions(int numQuestions) {
    this.numQuestions = numQuestions;
  }
  

}
