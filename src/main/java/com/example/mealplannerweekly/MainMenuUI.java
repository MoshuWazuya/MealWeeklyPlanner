package com.example.mealplannerweekly;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 *
 * @author Nadsreen
 * ABANG MOHAMAD NADSREEN BIN ABANG ADRUS 2314113
 */

public class MainMenuUI extends Application {


    private static String userName;
    public static void setUserName(String name) {
        userName = name;
    }

    @Override
    public void start(Stage primaryStage) {

        // Create the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setStyle("-fx-background-color: WHITE;"); //


        // Create the header using a BorderPane
        BorderPane header = new BorderPane();
        header.setStyle("-fx-background-color: #87CEEB;"); // light blue
        header.setPadding(new Insets(10));

        // Center the title label
        Label titleLabel = new Label("Meal Planner");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        header.setCenter(titleLabel);

        // Add the profile icon to the right
        Image profileImage = new Image("am-a-19-year-old-multimedia-artist-student-from-manila--21.png");
        ImageView profileView = new ImageView(profileImage);
        profileView.setFitWidth(30);
        profileView.setFitHeight(30);



        // Wrap the profile image in an HBox for alignment and spacing
        HBox profileContainer = new HBox(profileView);
        profileContainer.setAlignment(Pos.CENTER_RIGHT);
        header.setRight(profileContainer);

        // Create the grid for the week
        GridPane weekGrid = new GridPane();
        weekGrid.setAlignment(Pos.CENTER);

        weekGrid.setPadding(new Insets(20));
        weekGrid.setHgap(20);
        weekGrid.setVgap(20);

        DaysUI days = new DaysUI();
// Profile image icon click handler
        profileView.setOnMouseClicked(event -> {
            if (userName != null) {
                ProfileUI.openProfileStage(userName);  // Open ProfileUI with the stored name
            } else {
                System.out.println("User name is not set.");
            }
        });

        // Monday
        VBox mondayBox = new VBox();
        mondayBox.setPrefSize(100,100);
        mondayBox.setAlignment(Pos.CENTER);
        mondayBox.setSpacing(10); //jarak between nodes (monday and box view)
        mondayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;"); //blue color

        Label mondayLabel = new Label("Monday");
        mondayLabel.setStyle("-fx-font-size: 14px;");

        Button mondayButton = new Button("View");
        mondayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        mondayButton.setOnAction(event ->{
            days.days("Monday",primaryStage);
        });
        mondayBox.getChildren().addAll(mondayLabel, mondayButton);
        weekGrid.add(mondayBox, 0, 0); //position

        // Tuesday
        VBox tuesdayBox = new VBox();
        tuesdayBox.setAlignment(Pos.CENTER);
        tuesdayBox.setPrefSize(100,100);
        tuesdayBox.setSpacing(10);
        tuesdayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label tuesdayLabel = new Label("Tuesday");
        tuesdayLabel.setStyle("-fx-font-size: 14px;");

        Button tuesdayButton = new Button("View");
        tuesdayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        tuesdayButton.setOnAction(event ->{
            days.days("Tuesday",primaryStage);
        });
        tuesdayBox.getChildren().addAll(tuesdayLabel, tuesdayButton);
        weekGrid.add(tuesdayBox, 2, 0);

        // Wednesday
        VBox wednesdayBox = new VBox();
        wednesdayBox.setAlignment(Pos.CENTER);
        wednesdayBox.setPrefSize(100,100);
        wednesdayBox.setSpacing(10);
        wednesdayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label wednesdayLabel = new Label("Wednesday");
        wednesdayLabel.setStyle("-fx-font-size: 14px;");

        Button wednesdayButton = new Button("View");
        wednesdayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        wednesdayButton.setOnAction(event ->{
            days.days("Wednesday",primaryStage);
        });
        wednesdayBox.getChildren().addAll(wednesdayLabel, wednesdayButton);
        weekGrid.add(wednesdayBox, 4, 0);

        // Thursday
        VBox thursdayBox = new VBox();
        thursdayBox.setAlignment(Pos.CENTER);
        thursdayBox.setPrefSize(100,100);
        thursdayBox.setSpacing(10);
        thursdayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label thursdayLabel = new Label("Thursday");
        thursdayLabel.setStyle("-fx-font-size: 14px;");

        Button thursdayButton = new Button("View");
        thursdayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        thursdayButton.setOnAction(event ->{
            days.days("Thursday",primaryStage);
        });
        thursdayBox.getChildren().addAll(thursdayLabel, thursdayButton);
        weekGrid.add(thursdayBox, 6, 0);

        // Friday
        VBox fridayBox = new VBox();
        fridayBox.setAlignment(Pos.CENTER);
        fridayBox.setSpacing(10);
        fridayBox.setPrefSize(100,100);
        VBox.setMargin(fridayBox, new Insets(50));
        VBox.setVgrow(fridayBox, Priority.ALWAYS);
        fridayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label fridayLabel = new Label("Friday");
        fridayLabel.setStyle("-fx-font-size: 14px;");

        Button fridayButton = new Button("View");
        fridayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        fridayButton.setOnAction(event ->{
            days.days("Friday",primaryStage);
        });
        fridayBox.getChildren().addAll(fridayLabel, fridayButton);
        weekGrid.add(fridayBox, 1, 1);

        // Saturday
        VBox saturdayBox = new VBox();
        saturdayBox.setAlignment(Pos.CENTER);
        saturdayBox.setSpacing(10);
        saturdayBox.setPrefSize(100,100);
        saturdayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label saturdayLabel = new Label("Saturday");
        saturdayLabel.setStyle("-fx-font-size: 14px;");

        Button saturdayButton = new Button("View");
        saturdayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        saturdayButton.setOnAction(event ->{
            days.days("Saturday",primaryStage);
        });
        saturdayBox.getChildren().addAll(saturdayLabel, saturdayButton);
        weekGrid.add(saturdayBox, 3, 1);

        // Sunday
        VBox sundayBox = new VBox();
        sundayBox.setAlignment(Pos.CENTER);
        sundayBox.setPrefSize(100,100);
        sundayBox.setSpacing(10);
        sundayBox.setStyle("-fx-background-color: #87CEEB; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 5;");

        Label sundayLabel = new Label("Sunday");
        sundayLabel.setStyle("-fx-font-size: 14px;");

        Button sundayButton = new Button("View");
        sundayButton.setStyle("-fx-background-color: #3c7aa6; -fx-text-fill: white; -fx-font-size: 12px; -fx-background-radius: 5;");
        sundayButton.setOnAction(event ->{
            days.days("Sunday",primaryStage);
        });
        sundayBox.getChildren().addAll(sundayLabel, sundayButton);
        weekGrid.add(sundayBox, 5, 1);

        mainLayout.setTop(header);
        mainLayout.setCenter(weekGrid);

        Scene scene = new Scene(mainLayout, 800, 400);
        primaryStage.setTitle("Meal Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

