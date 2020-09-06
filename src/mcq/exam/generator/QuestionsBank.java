package mcq.exam.generator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class QuestionsBank {
Label questionX = new Label();
Label writeAnswers = new Label();
TextField question = new TextField();
TextField rightAnswer = new TextField();
TextField wrongAnswer1 = new TextField();
TextField wrongAnswer2 = new TextField();
TextField wrongAnswer3 = new TextField();
HBox answersHBox = new HBox(15);   
VBox questionVBox=  new VBox(15); 
public QuestionsBank( int X )
{
questionX.setText(" Question "+X + " : ");
writeAnswers.setText(" Write right answer in the green text field and wrong answers in red text fields.");
rightAnswer.setStyle("-fx-background-color: lawngreen;");
wrongAnswer1.setStyle("-fx-background-color: red;");
wrongAnswer2.setStyle("-fx-background-color: red;");
wrongAnswer3.setStyle("-fx-background-color: red;");
rightAnswer.setPrefWidth(150);
wrongAnswer1.setPrefWidth(150);
wrongAnswer2.setPrefWidth(150);
wrongAnswer3.setPrefWidth(150);
answersHBox.getChildren().addAll(rightAnswer,wrongAnswer1,wrongAnswer2,wrongAnswer3);
questionVBox.getChildren().addAll(questionX,question,writeAnswers,answersHBox);
questionVBox.setPadding(new Insets (10,10,10,10));
}
// Method to return VBox in order to put it on the scene
public VBox getVBox(){
 return questionVBox;   
}
public String getQuestion(){
    return question.getText();
}
// Method to rearrange answers randomly
public String[] getAnswers(){
    String rearrangedAnswers[]={rightAnswer.getText(),wrongAnswer1.getText(),wrongAnswer2.getText(),wrongAnswer3.getText()};
    List list = Arrays.asList(rearrangedAnswers);
    Collections.shuffle(list);
    list.toArray(rearrangedAnswers);
    return rearrangedAnswers;
}
public String getRightAnswer(){
    return rightAnswer.getText();
}}