package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Q4 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			VBox root = new VBox();
			root.setAlignment(Pos.CENTER);
			root.setSpacing(10);
			root.setPadding(new Insets(0,10,0,50));
			Scene scene = new Scene(root,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			Label headingLabel = new Label("Employee Registration Form");
			headingLabel.setFont(Font.font(22));
			BorderPane.setAlignment(headingLabel, Pos.CENTER);
			
			Label nameLabel = new Label("Enter Your Name:");
			

			TextField nameField = new TextField();
			nameField.setPromptText("Enter Your Name");
			nameField.setFocusTraversable(false);
			
			HBox nameBox = new HBox();
			nameBox.setSpacing(10);
			nameBox.getChildren().addAll(nameLabel,nameField);
			
			Label genderLabel = new Label("Enter Your Gender");
			RadioButton maleButton = new RadioButton("Male");
			RadioButton femaleButton = new RadioButton("Female");
			
			ToggleGroup genderGroup = new ToggleGroup();
			maleButton.setToggleGroup(genderGroup);
			femaleButton.setToggleGroup(genderGroup);
			
			HBox genderBox = new HBox();
//			genderBox.setPadding(new Insets(10));
			genderBox.setSpacing(10);
			genderBox.getChildren().addAll(genderLabel, maleButton,femaleButton);
			
			
			
			Label dobLabel = new Label("Enter Date of Birth");
			DatePicker dobDatePicker = new DatePicker();
			
			HBox dateBox = new HBox();
			dateBox.setSpacing(10);
			dateBox.getChildren().addAll(dobLabel,dobDatePicker);
			
			Label stateLabel = new Label("Select Your State");
			ComboBox<String> stateComboBox = new ComboBox<>();
			stateComboBox.setPrefWidth(130);
			stateComboBox.getItems().addAll("Karnataka","Assam", "Bihar");
			
			
			HBox stateBox =new HBox();
			stateBox.setSpacing(10);
			stateBox.getChildren().addAll(stateLabel,stateComboBox);

			Label qualifiLabel = new Label("Select Your Qualification");
			CheckBox ugCheckBox = new CheckBox("UG");
			CheckBox pgCheckBox = new CheckBox("PG");
			CheckBox phdCheckBox = new CheckBox("PhD");
			
			HBox qualifiBox = new HBox();
			
			qualifiBox.setSpacing(10);
			qualifiBox.getChildren().addAll(qualifiLabel, ugCheckBox,pgCheckBox,phdCheckBox);
		
			Button registerButton = new Button("Register");
			
			registerButton.setOnAction((ae)->{
				
				Alert registerDialog = new Alert(AlertType.INFORMATION);
				registerDialog.setTitle("Registration Successful");
				
				registerDialog.setHeaderText("Registration Status");
				registerDialog.setContentText("Employee Registration Successful!!");			
				registerDialog.showAndWait();
				
			} );;
			
			
			
			root.getChildren().addAll(headingLabel,nameBox,genderBox,dateBox,stateBox,qualifiBox,registerButton);
			primaryStage.show();		
			
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

