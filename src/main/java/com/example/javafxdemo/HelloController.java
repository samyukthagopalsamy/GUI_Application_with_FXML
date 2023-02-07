package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class HelloController {

    private Stage mainStage;

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
        this.mainStage = stage;
    }

    @FXML
    private void makeSandwich() {
        StringBuilder meats = new StringBuilder();
        int count = 0;
        if (ham.isSelected()) {
            meats.append("Ham");
            count++;
        }
        if (turkey.isSelected()) {
            if (count != 0) {
                meats.append(", Turkey");
            } else {
                meats.append("Turkey");
            }
            count++;
        }
        if (roastBeef.isSelected()) {
            if (count != 0) {
                meats.append(", Roast Beef");
            } else {
                meats.append("Roast Beef");
            }
        }

        String cheese = cheeseCombo.getSelectionModel().getSelectedItem();
        if (cheese == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("Select Cheese");
            alert.setHeaderText("Cheese not selected");
            alert.setContentText("Please select a cheese");
            alert.showAndWait();
            return;
        }

        StringBuilder veggies = new StringBuilder();
        count = 0;
        if (lettuce.isSelected()) {
            veggies.append("Lettuce");
            count++;
        }
        if (tomato.isSelected()) {
            if (count != 0) {
                veggies.append(", Tomato");
            } else {
                veggies.append("Tomato");
            }
            count++;
        }
        if (olives.isSelected()) {
            if (count != 0) {
                veggies.append(", Olives");
            } else {
                veggies.append("Olives");
            }
        }
        sandwich.setText("Meat: " + meats + "\nCheese: " + cheese + "\nVeggies: " + veggies);
    }
}
