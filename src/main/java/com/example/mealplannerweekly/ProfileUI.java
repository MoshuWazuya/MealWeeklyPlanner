package com.example.mealplannerweekly;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;

// MUHAMMAD FIKRI HAZIQ BIN ZAKI 2328631

public class ProfileUI  {

    public static void openProfileStage(String name) {
        Stage profileStage = new Stage();
        profileStage.setTitle("Profile");

        // Profile title
        Label profileTitleLabel = new Label("User Profile");
        profileTitleLabel.setTextFill(javafx.scene.paint.Color.BLACK);
        profileTitleLabel.setAlignment(Pos.CENTER);

        HBox titleContainer = new HBox();
        titleContainer.setMinHeight(50);
        titleContainer.getChildren().add(profileTitleLabel);
        titleContainer.setAlignment(Pos.CENTER);

        String titleStyle = " -fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: gray;";
        String dayStyle = titleStyle +
                "-fx-background-color: skyblue;";

        titleContainer.setStyle(dayStyle);

        // User info labels
        Label nameLabel = new Label("Name: " + name );
        Label ageLabel = new Label("Age: ");
        Label emailLabel = new Label("Email: ");
        Label phoneLabel = new Label("Phone: ");

        // Default profile data
        int currentAge = 30;
        String currentEmail = "john.doe@example.com";
        String currentPhone = "123-456-7890";

        // Set initial profile data
        ageLabel.setText("Age: " + currentAge);
        emailLabel.setText("Email: " + currentEmail);
        phoneLabel.setText("Phone: " + currentPhone);

        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));

        // Create a button to open the edit profile page
        Button editButton = new Button("Edit Profile");
        editButton.setPrefSize(80, 10);  // Set button size


        // Set action on the edit button
        editButton.setOnAction(e -> openEditStage(profileStage, nameLabel, ageLabel, emailLabel, phoneLabel, currentAge, currentEmail, currentPhone));

        // VBox for user profile data
        VBox body = new VBox(10);  // The 10 here is the spacing between the elements
        body.setAlignment(Pos.CENTER);  // Center the contents of the VBox


        // Add the labels and button to the VBox
        body.getChildren().addAll(nameLabel, ageLabel, emailLabel, phoneLabel, editButton);


        // Create the default image
        Image defaultImage = new Image("am-a-19-year-old-multimedia-artist-student-from-manila--21.png");
        ImageView imageView = new ImageView(defaultImage);

        // Set image size
        imageView.setFitWidth(250);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);

        // Button to change image
        Button changeImageButton = new Button("Change Image");
        editButton.setPrefSize(80, 10);  // Set button size

        changeImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(profileStage);
            if (selectedFile != null) {
                Image newImage = new Image(selectedFile.toURI().toString());
                imageView.setImage(newImage);
            }
        });

        // StackPane layout for profile image and button
        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, changeImageButton);
        StackPane.setMargin(changeImageButton, new Insets(150, 0, 20, 0));
        StackPane.setMargin(imageView, new Insets(25, 0, 20, 0));
        root.setAlignment(Pos.TOP_CENTER);

        // Layout container (VBox)
        VBox profileLayout = new VBox(10);
        profileLayout.setStyle("-fx-background-color: #e0e0e0;");
        profileLayout.getChildren().addAll(titleContainer, root, body);
        profileLayout.setAlignment(Pos.CENTER);

        // Profile scene
        Scene profileScene = new Scene(profileLayout, 500, 500);
        profileStage.setScene(profileScene);
        profileStage.show(); // Show the profile stage
    }

    private static void openEditStage(Stage profileStage, Label nameLabel, Label ageLabel, Label emailLabel, Label phoneLabel, int age, String email, String phone) {
        Stage editStage = new Stage();
        editStage.setTitle("Edit Profile");

// Form fields for editing profile
        Label nameLabelEdit = new Label("Name:");
        TextField nameField = new TextField(nameLabel.getText().substring(6));

        Label ageLabelEdit = new Label("Age:");
        Spinner<Integer> ageSpinner = new Spinner<>(0, 120, age);

        Label emailLabelEdit = new Label("Email:");
        TextField emailField = new TextField(emailLabel.getText().substring(7));

        Label phoneLabelEdit = new Label("Phone Number:");
        TextField phoneField = new TextField(phoneLabel.getText().substring(8));

        Button saveButton = new Button("Save");

// GridPane layout for editing
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(nameLabelEdit, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabelEdit, 0, 1);
        grid.add(ageSpinner, 1, 1);
        grid.add(emailLabelEdit, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(phoneLabelEdit, 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(saveButton, 1, 4);
        grid.setAlignment(Pos.CENTER);

// Alert for validation messages
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);

// Save button action with validation
        saveButton.setOnAction(e -> {
            String updatedName = nameField.getText().trim();
            int updatedAge = ageSpinner.getValue();
            String updatedEmail = emailField.getText().trim();
            String updatedPhone = phoneField.getText().trim();

            // Validate Name
            if (updatedName.isEmpty()) {
                alert.setContentText("Name cannot be empty.");
                alert.showAndWait();
                return;
            }

            // Validate Email
            if (!updatedEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                alert.setContentText("Please enter a valid email address.");
                alert.showAndWait();
                return;
            }

            // Validate Phone Number
            if (!updatedPhone.matches("\\d{7,15}")) {
                alert.setContentText("Phone number must be 7 to 15 digits long.");
                alert.showAndWait();
                return;
            }

            // Update profile labels
            nameLabel.setText("Name: " + updatedName);
            ageLabel.setText("Age: " + updatedAge);
            emailLabel.setText("Email: " + updatedEmail);
            phoneLabel.setText("Phone: " + updatedPhone);

            // Close the edit stage
            editStage.close();
        });



        // Set the scene and show the edit stage
        Scene editScene = new Scene(grid, 400, 300);
        editStage.setScene(editScene);
        editStage.show();
    }
}
