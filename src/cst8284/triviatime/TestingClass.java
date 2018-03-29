/**
 * 
 */
package cst8284.triviatime;

/**
 * @author Manuel Alonso Tarajano (tarajano@gmail.com)
 * Mar 29, 2018  
 */
public class TestingClass {

  /**
   * 
   */
  public TestingClass() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

    String absPath = "/Dropbox/Dropbox/eclipse-workspace/CST8284_W18_Assignment1/src/cst8284/triviatime/triviaQAFiles/ComputerTrivia_Java100.trivia";
    int numObjects = 7;
    
    // Loading objects
    FileUtils.setQAArray(absPath, numObjects);
    QA[] myQAArray = FileUtils.getQAArray();
    for (QA qa : myQAArray)
      System.out.println(qa.getQuestion());
    
    
    
    
  }

}
 