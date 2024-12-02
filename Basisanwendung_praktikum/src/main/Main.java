package main;

import gui.guifahrraeder.FahrradControl;
import gui.guifahrraeder.Fahrradview;
import gui.guifahrraeder.FahrraederUndZubehoerControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		
		new FahrradControl(primaryStage);
		
	//	new FahrraederUndZubehoerControl(primaryStage);
		
		Stage fenster = new Stage ();
		
		new FahrraederUndZubehoerControl(fenster);
		
		
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
