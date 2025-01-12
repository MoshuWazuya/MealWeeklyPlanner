package com.example.mealplannerweekly;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;




import java.io.*;

/**
 *
 * @author Wazir
 * Mohamad Wazir bin Nordin 2215353
 */


public class LoginPageUI extends Application  {
    @Override
    public void start(Stage stage)  {



        //UI for main page
        Label titleLabel = new Label("Login");
        titleLabel.setFont(new Font("Arial", 20));
        titleLabel.setTextFill(Color.BLACK);


        Label namelabel = new Label("Name");
        Label passwordlabel = new Label("Password");
        Label messagelabel = new Label("");

        //Input field for credentials
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");


        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-background-color: #00bfff; -fx-text-fill: white;");

        Button registerButton = new Button("Sign Up");
        registerButton.setStyle("-fx-background-color: #00bfff; -fx-text-fill: white;");

        //Action

        continueButton.setOnAction(e -> {
            String name = nameField.getText();
            String password = passwordField.getText();

            //Call method to verify credentials
            ProfileUI profile = new ProfileUI();
            if(verifyCredentials(name,password)){
                messagelabel.setText("User verified.Welcome!");
                messagelabel.setTextFill(Color.GREEN);

                //Hide the primary stage before opening the profile stage
                stage.hide();

                // Pass the name to the ProfileUI and open the profile stage
                MainMenuUI.setUserName(name);  // Pass the name to ProfileUI

                //Open the MainMenuUI
                new com.example.mealplannerweekly.MainMenuUI().start(stage);
            }else {
                messagelabel.setText("Invalid credentials. Try again.");
                messagelabel.setTextFill(Color.RED);
            }
        });

        //Register button action (Open page for registration)

        registerButton.setOnAction(event -> openRegisterStage());

        //Setup stage
        Stage primaryStage = new Stage();

        //Button Layout
        HBox buttonBox = new HBox(10,registerButton,continueButton);
        buttonBox.setAlignment(Pos.CENTER);


        //Main layout for login page
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #87CEEB; -fx-padding: 20;");
        layout.getChildren().addAll(titleLabel,namelabel,nameField,passwordlabel,passwordField,buttonBox);





        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Simple Weekly Meal Planner");
        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();


    }

    //Method to open registration page

    private void openRegisterStage(){
        Stage registeringStage = new Stage();
        registeringStage.setTitle("Register New User");

        Label registerTitleLabel = new Label("Register");
        registerTitleLabel.setFont(new Font("Arial", 20));
        registerTitleLabel.setTextFill(Color.BLACK);

        Label nameLabel = new Label("Name");
        Label passwordLabel = new Label("Password");
        Label messageLabel = new Label("");

        // Input fields
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        //Register Button

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #00bfff; -fx-text-fill: white;");

        // Action for Register Button
        registerButton.setOnAction(event -> {
            String name = nameField.getText(); // Get the entered name
            String password = passwordField.getText(); // Get the entered password

            if (name.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Fields cannot be empty.");
                messageLabel.setTextFill(Color.RED);
                return;
            }

            // Register the user in the text file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true))) {
                writer.write(name + "," + password);
                writer.newLine();
                messageLabel.setText("User registered successfully!");
                messageLabel.setTextFill(Color.GREEN);
            } catch (IOException ioException) {
                messageLabel.setText("Error: Could not register the user. Please try again.");
                messageLabel.setTextFill(Color.RED);
            }
        });



        VBox registerLayout = new VBox(10);
        registerLayout.setStyle("-fx-background-color: #87CEEB; -fx-padding: 20;");
        registerLayout.getChildren().addAll(registerTitleLabel,nameLabel,nameField,passwordLabel,passwordField,messageLabel,registerButton);


        Scene registerScene = new Scene(registerLayout,300,300);
        registeringStage.setScene(registerScene);
        registeringStage.show();





    }

    //Method to verify credential from TXT file

    private boolean verifyCredentials(String name ,String password) {
        File file = new File("Users.txt"); //file name

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split name and Password
                if (parts.length == 2 && parts[0].trim().equals(name) && parts[1].trim().equals(password)) {
                    return true; //User already exist
                }
            }

        } catch (FileNotFoundException e) {
            try {
                new File("Users.txt").createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }




    public static void main(String[] args) {

        launch();
    }
}