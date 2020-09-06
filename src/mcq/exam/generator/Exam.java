package mcq.exam.generator;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
public class Exam {
Label Question = new Label();
RadioButton Answer1 = new RadioButton(); 
RadioButton Answer2 = new RadioButton();
RadioButton Answer3 = new RadioButton();
RadioButton Answer4 = new RadioButton();
ToggleGroup answers = new ToggleGroup(); 
VBox questionVBox = new VBox(10);            
HBox answersHBox = new HBox(30);             
public Exam( String question , String answer1 , String answer2 , String answer3 , String answer4 )
{
Question.setText("\n  "+question);
Answer1.setText(answer1);
Answer2.setText(answer2);
Answer3.setText(answer3);
Answer4.setText(answer4);
Answer1.setToggleGroup(answers);
Answer2.setToggleGroup(answers);
Answer3.setToggleGroup(answers);
Answer4.setToggleGroup(answers);
answersHBox.getChildren().addAll(Answer1,Answer2,Answer3,Answer4);
questionVBox.getChildren().addAll(Question,answersHBox);
}
public VBox getVBox(){
    return questionVBox;
}}