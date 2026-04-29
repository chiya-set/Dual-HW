//I worked on the homework assignment alone, using only course materials.

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a class that organizes startup ideas.
 *
 * @author Priscilla Setiadi
 * @version 1.0
 */
public class StarterUpper extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage mainStage) {

        Label initialsLabel = new Label("P.G.S");

        //Questions
        Label problemLabel = new Label("What's the problem?");
        TextField problemField = new TextField();

        Label customerLabel = new Label("Who is the target customer?");
        TextField customerField = new TextField();

        Label needLabel = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        TextField needField = new TextField();

        Label experienceLabel = new Label("How many people do you know who might experience this problem?");
        TextField experienceField = new TextField();

        Label sizeLabel = new Label("How big is the target market?");
        TextField sizeField = new TextField();

        Label competitorLabel = new Label("Who are the competitors/existing solutions?");
        TextField competitorField = new TextField();

        //My buttons:
        Button addButton = new Button("Add Idea");
        Button sortButton = new Button("Sort");
        Button resetButton = new Button("Reset");
        Button saveButton = new Button("Save");

        ArrayList<StartUpIdea> ideas = new ArrayList<>();
        Label outputLabel = new Label();
        addButton.setOnAction(event -> {

            try {
                if (problemField.getText().isEmpty() || customerField.getText().isEmpty() || needField.getText().isEmpty() 
                    || experienceField.getText().isEmpty() || sizeField.getText().isEmpty() || competitorField.getText().isEmpty()) {
                        throw new Exception();
                }

                int need = Integer.parseInt(needField.getText());
                int experience = Integer.parseInt(experienceField.getText());
                int size = Integer.parseInt(sizeField.getText());

                if (need < 1 || need > 10) throw new Exception();

                StartUpIdea idea = new StartUpIdea(problemField.getText(), customerField.getText(), 
                    need, experience, size, competitorField.getText());

                ideas.add(idea);
                outputLabel.setText("Yay, ideas added! Total ideas: " + ideas.size());

            } catch(Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Invalid input!");
                errorAlert.setContentText("Please fill in all fields.");
                errorAlert.showAndWait();
            }

        });

        sortButton.setOnAction(e -> {
            Collections.sort(ideas);
            outputLabel.setText("Ideas are sorted!");
        });

        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION);
                confirmMsg.setContentText("Are you SURE you want to reset?");

                Optional<ButtonType> result = confirmMsg.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    ideas.clear();

                    problemField.clear();
                    customerField.clear();
                    needField.clear();
                    experienceField.clear();
                    sizeField.clear();
                    competitorField.clear();

                    File file = new File("ideas.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    
                    outputLabel.setText("Reset complete.");
                }
            }
        });

        Button GTIDButton = new Button("My GTID");
        GTIDButton.setOnAction((ActionEvent event) -> {
            System.out.println("904196983");
        });

        saveButton.setOnAction(e -> {
            try {
                FileUtil.saveIdeasToFile(ideas, new File("ideas.txt"));
                outputLabel.setText("Ideas saved!");
            } catch(Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error saving ideas");
                alert.showAndWait();
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        root.getChildren().addAll(initialsLabel, problemLabel, problemField, customerLabel
            , customerField, needLabel, needField, experienceLabel, experienceField, sizeLabel
            , sizeField, competitorLabel, competitorField, addButton, sortButton, resetButton
            , saveButton, GTIDButton, outputLabel);

        Scene scene = new Scene(root, 600, 650);
        mainStage.setScene(scene);
        mainStage.setTitle("Title Ideation Form");

        mainStage.show();
    }
}
