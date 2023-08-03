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
    @FXML
    protected void onHelloButtonClick() {

        String str = input.getText();
        //parseNums() : 1. arr 2. "" 3. aaaa
        List<Double> list = parseNums(str);
        if(list.size() == 0){
            //a b c 1 2 3
            calculate.setText("Please enter numeric values.");
            return;
        }

        double result = 0;

        if (autoSum.isSelected()) {
            result = calSum(list);
        } else if (average.isSelected()){
            result = calAvg(list);
        } else if (max.isSelected()){
            result = calMax(list);
        }else if (min.isSelected()){
            result = calMin(list);
        }


        calculate.setText(String.valueOf(result));

    }


    private double calSum(List<Double> list){
        double total = 0.0;
        for(Double e: list){
            total += e;
        }
        return total;

    }
    private double calAvg(List<Double> list){
        return calSum(list) / list.size();

    }
    private double calMax(List<Double> list){

        double max = list.get(0);
        for(Double e: list){
            if(e>max){
                max = e;
            }
        }
        return max;

    }

    private double calMin(List<Double> list){
        double min = list.get(0);
        for(Double e: list){
            if(e<min){
                min = e;
            }
        }
        return min;

    }

    private List<Double> parseNums(String str){
        // 1         2 3 4
        String[] strArr = str.split(" ");
        List<Double> strList = new ArrayList<>();
//        Arrays.stream(strArr).filter()
        for(String string: strArr){
            if(!"".equals(string)){
                for(int i = 0;i<string.length();i++){
                    //not a number 1 2 3 a b c
                    if(!(string.charAt(i)>='0' && string.charAt(i)<='9')){
                        return new ArrayList<>();
                    }
                }
                strList.add(Double.parseDouble(string));
            }
        }

        return strList;

    }

}