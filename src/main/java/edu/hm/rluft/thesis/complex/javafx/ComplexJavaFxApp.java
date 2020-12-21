package edu.hm.rluft.thesis.complex.javafx;

import edu.hm.rluft.thesis.complex.javafx.browse.BrowserController;
import edu.hm.rluft.thesis.complex.javafx.data.DataLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComplexJavaFxApp extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BrowserController controller = BrowserController.load();
		controller.setData(DataLoader.loadData());
		Parent root = controller.getParent();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
