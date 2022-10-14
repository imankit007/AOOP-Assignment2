package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Q2 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("Menu Design");
			
			BorderPane root = new BorderPane();
			
			root.setPadding(new Insets(0,0,0,0));
			Scene scene = new Scene(root,300,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			
			MenuBar menuBar = new MenuBar();

			Menu fileMenu = new Menu("File");
		
			
			MenuItem fnewMenuItem = new MenuItem("New");
			MenuItem fopenMenuItem = new MenuItem("Open");
			MenuItem fsaveMenuItem = new MenuItem("Save");
			
			fileMenu.setMnemonicParsing(true);
			
			fnewMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+n"));
			fopenMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+o"));
			fsaveMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+s"));
			
			fileMenu.getItems().addAll(fnewMenuItem,fopenMenuItem,fsaveMenuItem);
			
			menuBar.getMenus().add(fileMenu);
			
			Menu editMenu = new Menu("Edit");
			
			MenuItem cutMenuItem = new MenuItem("Cut");
			MenuItem copyMenuItem = new MenuItem("Copy");
			MenuItem pasteMenuItem = new MenuItem("Paste");
			
			editMenu.setMnemonicParsing(true);
			
			cutMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+x"));
			copyMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+c"));
			pasteMenuItem.setAccelerator(KeyCombination.keyCombination("shortcut+v"));
			
			editMenu.getItems().addAll(cutMenuItem,copyMenuItem,pasteMenuItem);
			menuBar.getMenus().add(editMenu);
			
			Menu helpMenu = new Menu("Help");
			
			MenuItem helpcentreMenuItem = new MenuItem("Help Centre");
			MenuItem aboutMenuItem = new MenuItem("About Us");
			
			helpMenu.setMnemonicParsing(true);
			
			helpcentreMenuItem.setAccelerator(KeyCombination.keyCombination("F1"));
			
			
			helpMenu.getItems().addAll(helpcentreMenuItem,aboutMenuItem);
			menuBar.getMenus().add(helpMenu);
			
			Label response = new Label();
			
			root.setTop(menuBar);
			root.setCenter(response);
			
			EventHandler<ActionEvent> menuEventHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae) {
					String outputString = ((MenuItem)ae.getTarget()).getText();
					if(outputString.equals("Exit")) {
						System.exit(0);
					}
					
					response.setText(outputString + " selected");
					
				}
			};
			
			fnewMenuItem.setOnAction(menuEventHandler);
			fopenMenuItem.setOnAction(menuEventHandler);
			fsaveMenuItem.setOnAction(menuEventHandler);
			cutMenuItem.setOnAction(menuEventHandler);
			copyMenuItem.setOnAction(menuEventHandler);
			pasteMenuItem.setOnAction(menuEventHandler);
			helpcentreMenuItem.setOnAction(menuEventHandler);
			aboutMenuItem.setOnAction(menuEventHandler);
			
			
				
			primaryStage.show();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


