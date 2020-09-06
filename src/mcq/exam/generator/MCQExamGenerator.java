package mcq.exam.generator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MCQExamGenerator extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Bank Question Window
        Button generateBtn = new Button("Generate Exam");
        StackPane btnPane = new StackPane();      // Stack Pane to change button position
        btnPane.getChildren().addAll(generateBtn);
        btnPane.setPadding(new Insets (0,0,0,5));
        QuestionsBank question1 = new QuestionsBank(1);
        QuestionsBank question2 = new QuestionsBank(2);
        QuestionsBank question3 = new QuestionsBank(3);
        QuestionsBank question4 = new QuestionsBank(4);
        QuestionsBank question5 = new QuestionsBank(5);
        VBox primaryV = new VBox(15);
        primaryV.getChildren().addAll(question1.getVBox(),question2.getVBox(),question3.getVBox(),question4.getVBox(),question5.getVBox(),btnPane);
        // Exam Window
        generateBtn.setOnAction(e->{
            QuestionsBank rearrangedQuestions[]={question1,question2,question3,question4,question5}; // Putting elements in array to rearrange them randomly
            List list = Arrays.asList(rearrangedQuestions);    // putting elements in a list to shuffle them
            Collections.shuffle(list);
            list.toArray(rearrangedQuestions);
            // putting answers in array after rearranging them
            String answers1[] = rearrangedQuestions[0].getAnswers();
            String answers2[] = rearrangedQuestions[1].getAnswers();
            String answers3[] = rearrangedQuestions[2].getAnswers();
            String answers4[] = rearrangedQuestions[3].getAnswers();
            String answers5[] = rearrangedQuestions[4].getAnswers();
            // Create questions and answers
            Exam Question1 = new Exam(rearrangedQuestions[0].getQuestion(),answers1[0],answers1[1],answers1[2],answers1[3]);
            Exam Question2 = new Exam(rearrangedQuestions[1].getQuestion(),answers2[0],answers2[1],answers2[2],answers2[3]);
            Exam Question3 = new Exam(rearrangedQuestions[2].getQuestion(),answers3[0],answers3[1],answers3[2],answers3[3]);
            Exam Question4 = new Exam(rearrangedQuestions[3].getQuestion(),answers4[0],answers4[1],answers4[2],answers4[3]);
            Exam Question5 = new Exam(rearrangedQuestions[4].getQuestion(),answers5[0],answers5[1],answers5[2],answers5[3]);
            Label label = new Label("\n\t\t\tChoose the right answer of following questions");
            Button modelAnswer = new Button("Model Answers");
            StackPane btnPane2 = new StackPane();
            btnPane2.getChildren().addAll(modelAnswer);
            btnPane2.setPadding(new Insets (0,0,0,5));
            VBox secondV = new VBox(10);
            secondV.getChildren().addAll(label,Question1.getVBox(),Question2.getVBox(),Question3.getVBox(),Question4.getVBox(),Question5.getVBox(),btnPane2);
                // Model answer window
                modelAnswer.setOnAction(event ->{
                Label rightAnswer1 = new Label("\n Question 1 : " + rearrangedQuestions[0].getRightAnswer() );
                Label rightAnswer2 = new Label("\n Question 2 : " + rearrangedQuestions[1].getRightAnswer());
                Label rightAnswer3 = new Label("\n Question 3 : " + rearrangedQuestions[2].getRightAnswer());
                Label rightAnswer4 = new Label("\n Question 4 : " + rearrangedQuestions[3].getRightAnswer());
                Label rightAnswer5 = new Label("\n Question 5 : " + rearrangedQuestions[4].getRightAnswer());
                VBox thirdV = new VBox(10) ;
                thirdV.getChildren().addAll(rightAnswer1,rightAnswer2,rightAnswer3,rightAnswer4,rightAnswer5);
                Scene thirdScene = new Scene(thirdV,500,250);
                Stage thirdStage = new Stage();
                thirdStage.setResizable(false);
                thirdStage.setTitle("Model Answer");
                thirdStage.setScene(thirdScene);
                thirdStage.show();
            });
            Scene secondScene = new Scene(secondV,500,505);
            Stage secondStage = new Stage();
            secondStage.setResizable(false);
            secondStage.setTitle("Exam");
            secondStage.setScene(secondScene);
            secondStage.show();
        });
        Scene scene = new Scene(primaryV, 670, 950);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Set Exam");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}