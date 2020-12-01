package edu.hm.rluft.thesis.calculator.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorJavaFxApp extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    CalculatorController controller = CalculatorController.load();
    Parent root = controller.getParent();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(CalculatorJavaFxApp.class.getResource("calculator.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
