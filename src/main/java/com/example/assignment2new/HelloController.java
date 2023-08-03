package com.example.assignment2new;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private Label calculate;

    @FXML
    private TextField input;

    @FXML
    private ToggleGroup terms;

    @FXML
    private RadioButton autoSum;

    @FXML
    private RadioButton average;

    @FXML
    private RadioButton max;

    @FXML
    private RadioButton min;

    // This method is called when the "Calculate" button is clicked.
    @FXML
    protected void onHelloButtonClick() {

        // Get the text entered in the input TextField.
        String str = input.getText();

        // Parse the input string to extract numeric values.
        List<Double> list = parseNums(str);

        // If no numeric values are found, display an error message and return.
        if (list.size() == 0) {
            calculate.setText("Please enter numeric values.");
            return;
        }

        double result = 0;

        // Determine which operation (Auto Sum, Average, Max, Min) is selected and calculate the result accordingly.
        if (autoSum.isSelected()) {
            result = calSum(list);
        } else if (average.isSelected()) {
            result = calAvg(list);
        } else if (max.isSelected()) {
            result = calMax(list);
        } else if (min.isSelected()) {
            result = calMin(list);
        }

        // Display the calculated result in the "calculate" Label.
        calculate.setText(String.valueOf(result));
    }

    // Calculate the sum of a list of numbers.
    private double calSum(List<Double> list) {
        double total = 0.0;
        for (Double e : list) {
            total += e;
        }
        return total;
    }

    // Calculate the average of a list of numbers.
    private double calAvg(List<Double> list) {
        return calSum(list) / list.size();
    }

    // Calculate the maximum value in a list of numbers.
    private double calMax(List<Double> list) {
        double max = list.get(0);
        for (Double e : list) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    // Calculate the minimum value in a list of numbers.
    private double calMin(List<Double> list) {
        double min = list.get(0);
        for (Double e : list) {
            if (e < min) {
                min = e;
            }
        }
        return min;
    }

    // Parse a string to extract numeric values and return them in a list.
    private List<Double> parseNums(String str) {
        String[] strArr = str.split(" ");
        List<Double> strList = new ArrayList<>();
        for (String string : strArr) {
            if (!"".equals(string)) {
                for (int i = 0; i < string.length(); i++) {
                    // Check if each character is a digit (0-9).
                    if (!(string.charAt(i) >= '0' && string.charAt(i) <= '9')) {
                        // If non-numeric character found, return an empty list.
                        return new ArrayList<>();
                    }
                }
                // Convert the numeric string to a Double and add it to the list.
                strList.add(Double.parseDouble(string));
            }
        }
        return strList;
    }
}
