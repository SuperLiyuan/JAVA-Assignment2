package com.example.assignment2new;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // The entry point of your JavaFX application.
    @Override
    public void start(Stage stage) throws IOException {
        // Create an FXMLLoader to load the FXML layout file.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Load the FXML layout and create a Scene with the loaded content.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the application window.
        stage.setTitle("Excel Formula Javafx window");

        // Set the created Scene as the content of the stage (window).
        stage.setScene(scene);

        // Display the application window.
        stage.show();
    }

    // The main method that launches the JavaFX application.
    public static void main(String[] args) {
        // Call the launch() method to start the JavaFX application.
        launch();
    }
}
