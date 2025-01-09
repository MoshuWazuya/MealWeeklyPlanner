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


public class LoginPageUI extends Application  {
    @Override
    public void start(Stage stage)  {



        //UI for main page
        Label titleLabel = new Label("Sign Up");
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

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #00bfff; -fx-text-fill: white;");

        //Action

        continueButton.setOnAction(e -> {
            String name = nameField.getText();
            String password = passwordField.getText();

            //Call method to verify credentials

            if(verifyCredentials(name,password)){
                messagelabel.setText("User verified.Welcome!");
                messagelabel.setTextFill(Color.GREEN);
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


        //Main layout for login page
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #a9a9a9; -fx-padding: 20;");
        layout.getChildren().addAll(titleLabel,namelabel,nameField,passwordlabel,passwordField,buttonBox);





        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Simple Weekly Meal Planner");
        primaryStage.show();
        primaryStage.setScene(scene);


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


        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #00bfff; -fx-text-fill: white;");

        // Action for Register Button
        registerButton.setOnAction(event -> {
            String name = nameField.getText();
            String password = passwordField.getText();

            // Register the user in the text file
            //Call method to register the user
            if (registerUser(name, password)) {
                messageLabel.setText("User registered successfully!");
                messageLabel.setTextFill(Color.GREEN);
                System.out.println("User registration is successful");
            } else {
                messageLabel.setText("Registration failed. User might already exist."); // Display error message
                messageLabel.setTextFill(Color.RED); // Set message color to red
            }
        });



        VBox registerLayout = new VBox(10);
        registerLayout.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 20;");
        registerLayout.getChildren().addAll(registerTitleLabel,nameLabel,nameField,passwordLabel,passwordField,messageLabel,registerButton);
        registerLayout.setAlignment(Pos.CENTER);

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

        } catch (IOException e) {
            //To show error alert if reading it is a fail
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("No user matched. Please try again.");
            alert.showAndWait();
        }

        return false;
    }

    //Method to register new user
    private boolean registerUser(String name, String password) {
        File file = new File("users.txt");


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(name)) {
                    return false; // User already exists
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("User already registered. Please try again.");
            alert.showAndWait();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(name + "," + password); //Append new suer data
            writer.newLine();
            return true; // Registration successful
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("Unable to access the user data file. Please try again.");
            alert.showAndWait();
        }

        return false; // Registration failed
    }




    public static void main(String[] args) {

        launch();
    }
}