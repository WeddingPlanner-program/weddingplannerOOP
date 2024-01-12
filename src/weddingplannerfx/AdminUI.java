package weddingplannerfx;

import java.io.Serializable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


    
public class AdminUI extends Application implements Serializable{
    @Override
    public void start(Stage primaryStage) {
        Background bg = FXFuns.insertBackground(primaryStage);
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage);

        
        Text txt1 = new Text("Welcome...");
        txt1.setFont(Font.font("Arial",FontWeight.BOLD,45));
        
       

        //scene
        BorderPane layout = FXFuns.setMenu();
        StackPane root = new StackPane();
        
        //layout
        root.getChildren().addAll(rectangle,layout,txt1);  
        root.setBackground(bg);
        Scene AdminScene = new Scene(root, 1920, 1080);

        
        //satge
        primaryStage.setTitle("Admin");
        primaryStage.setScene(AdminScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
    

