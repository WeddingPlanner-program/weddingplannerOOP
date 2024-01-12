package weddingplannerfx;


import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public abstract class User{
    //Attributes
    protected static Stage stage;
    protected String name;
    protected String number;
    protected String username;
    protected String password;
    protected Button loginButton;
    protected GridPane gridpane = new GridPane();
    protected VBox vbox = new VBox();
    protected Background bg = FXFuns.insertBackground(stage);
    protected Rectangle rectangle = FXFuns.insertRectangle(stage); 
    
    //Constructor
    public User() {
    }
    
    public User(String name, String number, String username, String password) {
        this.name = name;
        this.number = number;
        this.username = username;
        this.password = password;
    }
    
       
    

    
    public abstract void loginChecker(String enteredUsername,String enteredPass)throws IOException;
    
    
    
}
