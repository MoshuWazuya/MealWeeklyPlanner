/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mealplannerweekly;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;

import javafx.stage.Stage;




/**
 *
 * @author khalid sem
     --> Muhammad Khalid bin Abdul Jabar 2326293
 */
public class DaysUI {
    Label brLabel = new Label("Breakfast");
    Label luLabel = new Label("Lunch");
    Label diLabel = new Label("Dinner");
    Label brTotalCal = new Label();
    Label luTotalCal = new Label();
    Label diTotalCal = new Label();
    Label day = new Label();
    ObservableList<String> brMealList = FXCollections.observableArrayList();
    ObservableList<String> luMealList = FXCollections.observableArrayList();
    ObservableList<String> diMealList = FXCollections.observableArrayList();
    ObservableList<Double> brCalList = FXCollections.observableArrayList();
    ObservableList<Double> luCalList = FXCollections.observableArrayList();
    ObservableList<Double> diCalList = FXCollections.observableArrayList();
    ListView<String> brMealView = new ListView<>(brMealList);
    ListView<String> luMealView = new ListView<>(luMealList);
    ListView<String> diMealView = new ListView<>(diMealList);
    
    public void days(String days,Stage stage){
        day.setText(days);
        AddMealUI add = new AddMealUI();
                                                    
        //layout
        Button brAdd = new Button("Add");   
        Button luAdd = new Button("Add");
        Button diAdd = new Button("Add");
        Button brRemove = new Button("Remove");
        Button luRemove = new Button("Remove");
        Button diRemove = new Button("Remove");
        Button back = new Button("← back");
        VBox brBox = new VBox(5);
        VBox luBox = new VBox(5);
        VBox diBox = new VBox(5);
        VBox breakfast = new VBox(10);
        VBox lunch = new VBox(10);
        VBox dinner = new VBox(10);
        HBox brBtn = new HBox(10);
        HBox luBtn = new HBox(10);
        HBox diBtn = new HBox(10);
        HBox root = new HBox(40); 
        VBox lastroot = new VBox(40);
        HBox titleContainer = new HBox();
        HBox backContainer = new HBox();
        titleContainer.getChildren().addAll(day);
        titleContainer.setAlignment(Pos.CENTER);
        backContainer.getChildren().addAll(back);
        backContainer.setAlignment(Pos.TOP_LEFT);
        StackPane sp =  new StackPane(titleContainer,backContainer);
        brBtn.getChildren().addAll(brAdd,brRemove);
        luBtn.getChildren().addAll(luAdd,luRemove);
        diBtn.getChildren().addAll(diAdd,diRemove);
        brBox.getChildren().addAll(brMealView,brTotalCal,brBtn);
        luBox.getChildren().addAll(luMealView,luTotalCal,luBtn);
        diBox.getChildren().addAll(diMealView,diTotalCal,diBtn);
        breakfast.getChildren().addAll(brLabel,brBox);
        lunch.getChildren().addAll(luLabel,luBox);
        dinner.getChildren().addAll(diLabel,diBox);
        root.getChildren().addAll(breakfast,lunch,dinner);
        lastroot.getChildren().addAll(sp,root);
        //layout
                                                    
        //setStyle template
        String buttonStyle = "-fx-background-radius: 10;" + 
                        "-fx-background-color: #3a7ca5;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-family: 'Courier New';";
        String backStyle = "-fx-background-color: transparent;" +
                        "-fx-font-family: 'Courier New';" +
                        "-fx-font-size: 15;" +
                        "-fx-font-weight: bold;" + 
                        "-fx-text-fill: white;";
        String mealStyle = "-fx-background-radius: 20;";
        String boxStyle = "-fx-background-color: skyblue;" + 
                        "-fx-background-radius: 20;" + 
                        "-fx-padding: 7;";
        String titleStyle = "-fx-font-size: 20;" + 
                            "-fx-font-weight: bold;" +
                            "-fx-font-family: 'Comic Sans MS';" +
                            "-fx-text-fill: gray;";
        String dayStyle = titleStyle + 
                            "-fx-background-color: skyblue;";
        String totalStyle = "-fx-font-family: 'Courier New';" +
                            "-fx-font-weight: bold;";
        //setStyle template
        
        //styling
        back.setStyle(backStyle);
        titleContainer.setStyle(dayStyle);
        brTotalCal.setStyle(totalStyle);
        luTotalCal.setStyle(totalStyle);
        diTotalCal.setStyle(totalStyle);
        brLabel.setStyle(titleStyle);
        luLabel.setStyle(titleStyle);
        diLabel.setStyle(titleStyle);
        brMealView.setStyle(mealStyle);
        luMealView.setStyle(mealStyle);
        diMealView.setStyle(mealStyle);
        brRemove.setStyle(buttonStyle);
        luRemove.setStyle(buttonStyle);
        diRemove.setStyle(buttonStyle);
        brBox.setStyle(boxStyle);
        luBox.setStyle(boxStyle);
        diBox.setStyle(boxStyle);
        brAdd.setStyle(buttonStyle);
        luAdd.setStyle(buttonStyle);
        diAdd.setStyle(buttonStyle);
        
        titleContainer.setMinHeight(50);
        brMealView.setMaxSize(150,100);
        luMealView.setMaxSize(150,100);
        diMealView.setMaxSize(150,100);     
        brBox.setMinSize(160,120);
        luBox.setMinSize(160,120);
        diBox.setMinSize(160,120);
        brBox.setMinHeight(150);
        luBox.setMinHeight(150);
        diBox.setMinHeight(150);
        brAdd.setMinWidth(50);
        luAdd.setMinWidth(50);
        diAdd.setMinWidth(50);
        
        brBtn.setAlignment(Pos.CENTER);
        luBtn.setAlignment(Pos.CENTER);
        diBtn.setAlignment(Pos.CENTER);
        brBox.setAlignment(Pos.CENTER);
        luBox.setAlignment(Pos.CENTER);
        diBox.setAlignment(Pos.CENTER);
        breakfast.setAlignment(Pos.CENTER);
        lunch.setAlignment(Pos.CENTER);
        dinner.setAlignment(Pos.CENTER);      
        root.setAlignment(Pos.CENTER);
        lastroot.setAlignment(Pos.TOP_CENTER);
        //styling
        
        //event-handling back
        back.setOnAction(event -> {
            MainMenuUI main = new MainMenuUI();
            main.start(stage);
        });
        //event-handling back
        
        //event-handling add
        brAdd.setOnAction(event -> {
            add.AddMeal(brMealList,"Breakfast",brCalList,brTotalCal);
        });
        luAdd.setOnAction(event -> {
            add.AddMeal(luMealList,"Lunch",luCalList,luTotalCal);
        });
        diAdd.setOnAction(event -> {
            add.AddMeal(diMealList,"Dinner",diCalList,diTotalCal);
        });
        //event-handling add
        
        //event-handling remove
        brRemove.setOnAction(event -> {
            try{
                String selected = brMealView.getSelectionModel().getSelectedItem();
                int index = brMealList.indexOf(selected);
                if (selected==null)
                    throw new IllegalStateException("No meal selected");
                brMealList.remove(index);
                brCalList.remove(index);
                double totalCalories = brCalList.stream().mapToDouble(Double::doubleValue).sum();
                brTotalCal.setText("Total: " + totalCalories + " cal");
            }
            catch(IllegalStateException e){
                System.out.println("No meal selected");
            }

        });
        luRemove.setOnAction(event -> {
            try{
                String selected = luMealView.getSelectionModel().getSelectedItem();
                int index = luMealList.indexOf(selected);
                if (selected==null)
                    throw new IllegalStateException("No meal selected");
                luMealList.remove(index);
                luCalList.remove(index);
                double totalCalories = luCalList.stream().mapToDouble(Double::doubleValue).sum();
                luTotalCal.setText("Total: " + totalCalories + " cal");
            }
            catch(IllegalStateException e){
                System.out.println("No meal selected");
            }
        });
        diRemove.setOnAction(event -> {
            try{
                String selected = diMealView.getSelectionModel().getSelectedItem();
                int index = diMealList.indexOf(selected);
                if (selected==null)
                    throw new IllegalStateException("No meal selected");
                diMealList.remove(index);
                diCalList.remove(index);
                double totalCalories = diCalList.stream().mapToDouble(Double::doubleValue).sum();
                diTotalCal.setText("Total: " + totalCalories + " cal");
            }
            catch(IllegalStateException e){
                System.out.println("No meal selected");
            }
        });
        //event-handling remove
        
        Scene scene = new Scene(lastroot,600,300);
        stage.setScene(scene);
        stage.setTitle("DaysUI");
        stage.show();
    }
}

