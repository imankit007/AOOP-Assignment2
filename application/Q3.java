package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Q3 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("Menu Design");
			
			FlowPane root = new FlowPane(10,10);
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(0,0,0,0));
			Scene scene = new Scene(root,300,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			Label responseLabel = new Label();
			
			
			
			Menu newMenu = new Menu("New");
			
			MenuItem fileMenuItem = new MenuItem("File");
			MenuItem folderMenuItem = new MenuItem("Folder");
			MenuItem imageMenuItem = new MenuItem("Image");
			
			newMenu.getItems().addAll(fileMenuItem,folderMenuItem,imageMenuItem);
			
			
			Menu viewMenu = new Menu("View");
			
			MenuItem largeMenuItem = new MenuItem("Large");
			MenuItem mediuMenuItem = new MenuItem("Medium");
			MenuItem smallMenuItem = new MenuItem("Small");
			
			viewMenu.getItems().addAll(largeMenuItem,mediuMenuItem,smallMenuItem);
			
			ContextMenu contextMenu = new ContextMenu();
			 contextMenu.getItems().addAll(newMenu,viewMenu);
			
			TextField txTextField = new TextField();
			
			txTextField.setPrefColumnCount(20);
			txTextField.setContextMenu(contextMenu);
			
			EventHandler<ActionEvent> meEventHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent ae){
					String name = ((MenuItem) ae.getTarget()).getText();
					
					responseLabel.setText(name +" selected");
				}
			};
			
			
			fileMenuItem.setOnAction(meEventHandler);
			folderMenuItem.setOnAction(meEventHandler);
			imageMenuItem.setOnAction(meEventHandler);
			largeMenuItem.setOnAction(meEventHandler);
			mediuMenuItem.setOnAction(meEventHandler);
			smallMenuItem.setOnAction(meEventHandler);
			
			
			root.getChildren().addAll(txTextField,responseLabel);
			
			primaryStage.show();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


