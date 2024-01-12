package weddingplannerfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginScene_customer extends Application{
    protected GridPane gridpane = new GridPane();
    protected VBox vbox = new VBox();
    
    @Override
    public void start(Stage primaryStage) {
        //data layout
        gridpane.setPadding(new Insets(50,120,10,760)); 
        gridpane.setVgap(30);
        gridpane.setHgap(8);
        
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(usernameTextField, 1, 0);
 
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        GridPane.setConstraints(passwordTextField, 1, 1);
        passwordTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); 

        Button loginButton = new Button("Log in");
        loginButton.setFont(new Font("Arial",22));

        loginButton.setOnAction(e -> {
            String un = usernameTextField.getText();
            String pass = passwordTextField.getText();
            Customer customer = new Customer();
            try {
                customer.loginChecker(un, pass);
            } catch (IOException ex) {
                System.out.println("File is not found!");
            }
        });
        
                //title
        Text title = new Text("Please enter the following details:");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage); 
        Background bg = FXFuns.insertBackground(primaryStage);
        gridpane.getChildren().addAll(usernameLabel,usernameTextField,passwordLabel,passwordTextField);        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        vbox.getChildren().addAll(title,gridpane,loginButton);
        
        //scene layout
        StackPane logRoot = new StackPane();
        logRoot.setBackground(bg);
        logRoot.getChildren().addAll(rectangle,vbox);

        //scene
        Scene loginScene = new Scene(logRoot,1920,1080);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
   


    public static void main(String[] args) {
        launch(args);
    }
    
}
