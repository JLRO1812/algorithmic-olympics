package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main (String[]args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("AlgorithmsRace.fxml"));
		Scene scene= new Scene(root);
		stage.setScene(scene);
		
		stage.setWidth(606);
		stage.setHeight(629);
		stage.setResizable(false);
		stage.getIcons().add(new Image("images/iconito.png"));
		stage.setTitle("Basic Algorithms Race");
		stage.show();
	}
}