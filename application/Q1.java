package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Q1 extends Application {
	String usrNameString= "ankit";
	String passwordString="1234";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setHgap(20);
			root.setVgap(20);
			root.setPadding(new Insets(0,10,0,10));
			Scene scene = new Scene(root,300,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			root.setGridLinesVisible(false);
			
			Label usrNameLabel = new Label("User Name");
			root.add(usrNameLabel, 0, 1);
			Label passWdLabel = new Label("Password");
			root.add(passWdLabel, 0, 2);
			Label responseLabel = new Label();
			root.add(responseLabel, 2, 4);
			
			TextField usrnNameTextField = new TextField();
			root.add(usrnNameTextField, 2, 1);
			PasswordField passwordField = new PasswordField();
			root.add(passwordField, 2, 2);
			
			Button suButton = new Button("Submit");
			
			root.add(suButton, 2, 3);
			
			suButton.setOnAction(new EventHandler<ActionEvent>() {				
				@Override
				public void handle(ActionEvent arg0) {
					String str1 = usrnNameTextField.getText();
					String str2 = passwordField.getText();
					
					try {
						if(str1.equalsIgnoreCase(usrNameString)&&str2.equals(passwordString)) {
								responseLabel.setText("Login Succesful");
						}else {
							throw new InvalidUserNameOrPasswordException();
						}
					} catch (InvalidUserNameOrPasswordException e) {
						System.out.println(e);
					}
					
				}
			});
			
			//root.getChildren().addAll(usrNameLabel,usrnNameTextField,passWdLabel,passwordField,suButton,responseLabel);
			
			primaryStage.show();		
			
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

class InvalidUserNameOrPasswordException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidUserNameOrPasswordException() {
		super("Invalid UserName or Password!!");
	}
}
