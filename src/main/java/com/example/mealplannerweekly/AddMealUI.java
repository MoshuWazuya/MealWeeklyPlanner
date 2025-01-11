/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mealweeklyplanner;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author muhdk
 */
public class AddMealUI {
    TextField mealField = new TextField();
    TextField calField = new TextField();
    Button add = new Button("Add");
    Button cancel = new Button("Cancel");
    
    public void AddMeal(ObservableList<String> mealList,String mealType,ObservableList<Double> calorieList,Label totalLabel) {
        Stage stage = new Stage();
        
        HBox hb = new HBox(10);
        hb.getChildren().addAll(add, cancel);
        hb.setAlignment(Pos.CENTER);
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setVgap(6);
        pane.setHgap(10);
        
        pane.add(new Label("Meal name:"), 0, 0);
        pane.add(mealField, 1, 0);
        pane.add(new Label("Calorie:"), 0, 1);
        pane.add(calField, 1, 1);
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pane, hb);
        
        add.setOnAction(event ->{
        if(mealType.equals("Breakfast")){
            String meal = mealField.getText();
            double brCal = Double.parseDouble(calField.getText());
            mealList.add(meal + " - " + brCal + " cal");
            calorieList.add(brCal);
            double totalCalories = calorieList.stream().mapToDouble(Double::doubleValue).sum();
            totalLabel.setText("Total: " + totalCalories + " cal");
        }
        else if(mealType.equals("Lunch")){
            String meal = mealField.getText();
            double luCal = Double.parseDouble(calField.getText());
            mealList.add(meal + " - " + luCal + " cal");
            calorieList.add(luCal);
            double totalCalories = calorieList.stream().mapToDouble(Double::doubleValue).sum();
            totalLabel.setText("Total: " + totalCalories + " cal");
        }
        else if(mealType.equals("Dinner")){
            String meal = mealField.getText();
            double diCal = Double.parseDouble(calField.getText());
            mealList.add(meal + " - " + diCal + " cal");
            calorieList.add(diCal);
            double totalCalories = calorieList.stream().mapToDouble(Double::doubleValue).sum();
            totalLabel.setText("Total: " + totalCalories + " cal");
        }      
            mealField.clear();
            calField.clear();
            stage.close();
        });
        
        cancel.setOnAction(e -> {
            mealField.clear();
            calField.clear();
        });
        
        Scene scene = new Scene(root,250,150);
        
        stage.setScene(scene);
        stage.show();
    }   
}