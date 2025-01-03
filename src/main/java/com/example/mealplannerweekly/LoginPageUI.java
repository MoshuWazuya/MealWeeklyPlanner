package com.example.mealplannerweekly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;


public class LoginPageUI extends Application  {
    @Override
    public void start(Stage stage)  {

        Label titleLabel = new Label("Sign Up");
        titleLabel.setFont(new Font("Arial", 20));
        titleLabel.setTextFill(Color.BLACK);

        Label namelabel = new Label("Name");
        Label passwordlabel = new Label("Password");
        Label messagelabel = new Label("");

        //Input field
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

            if(verifyCredentials(name,password)){
                messagelabel.setText("User verified.Welcome!");
                messagelabel.setTextFill(Color.GREEN);
            }else {
                messagelabel.setText("Invalid credentials. Try again.");
                messagelabel.setTextFill(Color.RED);
            }
        });


        registerButton.setOnAction(e -> {
            String name = nameField.getText(); // Get the entered name
            String password = passwordField.getText(); // Get the entered password

            // Register the user in the text file
            if (registerUser(name, password)) {
                messagelabel.setText("User registered successfully!"); // Display success message
                messagelabel.setTextFill(Color.GREEN); // Set message color to green
            } else {
                messagelabel.setText("Registration failed. User might already exist."); // Display error message
                messagelabel.setTextFill(Color.RED); // Set message color to red
            }
        });


        Stage primaryStage = new Stage();

        HBox buttonBox = new HBox(10,registerButton,continueButton);



        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #a9a9a9; -fx-padding: 20;");
        layout.getChildren().addAll(titleLabel,namelabel,nameField,passwordlabel,passwordField,buttonBox);




        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Simple Weekly Meal Planner");
        primaryStage.show();
        primaryStage.setScene(scene);


    }

    private boolean verifyCredentials(String name ,String password) {
        File file = new File("User.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(name) && parts[1].trim().equals(password)) {
                    return true; //User already exist
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


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
            e.printStackTrace();
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(name + "," + password);
            writer.newLine();
            return true; // Registration successful
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Registration failed
    }




    public static void main(String[] args) {
        launch();
    }
}