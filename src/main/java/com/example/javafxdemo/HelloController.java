package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HelloController {

    Stage mainStage;

    @FXML
    private CheckBox ham;

    @FXML
    private CheckBox turkey;

    @FXML
    private CheckBox roastBeef;

    @FXML
    private CheckBox lettuce;

    @FXML
    private CheckBox tomato;

    @FXML
    private CheckBox olives;

    @FXML
    private ComboBox<String> cheeseCombo;

    @FXML
    private TextArea sandwich;

    public void setMainStage(Stage stage) {
        mainStage = stage;
    }

    @FXML
    private void makeSandwich() {
        // get meats
        String meats="";
        int count=0;
        if (ham.isSelected()) {
            meats += "Ham";
            count++;
        }
        if (turkey.isSelected()) {
            if (count != 0) {
                meats += ", Turkey";
            } else {
                meats += "Turkey";
            }
            count++;
        }
        if (roastBeef.isSelected()) {
            if (count != 0) {
                meats += ", Roast Beef";
            } else {
                meats += "Roast Beef";
            }
        }
        //System.out.println("Meat: " + meats);

        // get the cheese
        String cheese = cheeseCombo.getSelectionModel().getSelectedItem();
        if (cheese == null) { // nothing selected
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("Select Cheese");
            alert.setHeaderText("Cheese not selected");
            alert.setContentText("Please select a cheese");
            alert.showAndWait();
            return;
        }
        //System.out.println("Cheese: " + cheese);

        // get veggies
        String veggies="";
        count=0;
        if (lettuce.isSelected()) {
            veggies += "Lettuce";
            count++;
        }
        if (tomato.isSelected()) {
            if (count != 0) {
                veggies += ", Tomato";
            } else {
                veggies += "Tomato";
            }
            count++;
        }
        if (olives.isSelected()) {
            if (count != 0) {
                veggies += ", Olives";
            } else {
                veggies += "Olives";
            }
        }
        sandwich.setText("Meat: " + meats + "\nCheese: " + cheese + "\nVeggies: " + veggies);

    }

}
