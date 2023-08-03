module com.example.assignment2new {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment2new to javafx.fxml;
    exports com.example.assignment2new;
}