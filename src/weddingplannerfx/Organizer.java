package weddingplannerfx;

import java.io.IOException;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Organizer extends User{

    public Organizer() {
    }

    public Organizer(String name, String number, String username, String password) {
        super(name, number, username, password);
    }
    
    public Scene LoginSceneOrganizer(){
        Stage stage = new Stage();
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
        username = usernameTextField.getText();
 
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        GridPane.setConstraints(passwordTextField, 1, 1);
        passwordTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); 
        password = passwordTextField.getText();

        
        loginButton = new Button("Log in");
        loginButton.setFont(new Font("Arial",22));
        //loginButton.setOnAction(e -> 
        
                //title
        Text title = new Text("Sign in");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
        Rectangle rectangle = FXFuns.insertRectangle(stage); 
        Background bg = FXFuns.insertBackground(stage);
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
        return loginScene;

    }



    @Override
    public void loginChecker(String enteredUsername,String enteredPass) throws IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }





    


}
