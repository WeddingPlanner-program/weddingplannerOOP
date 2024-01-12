package weddingplannerfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class WeddingPlannerFX extends Application {
    private StackPane root = new StackPane();;
    private Scene scene;
    private GridPane layout;
    

    public static void main(String[] args) {
        launch(args);
    }
    static Stage mystage = new Stage();
    
        @Override
    public void start(Stage primaryStage) {
                //****first Scene
                
         //layout
        layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(30);
        scene = new Scene(root,1920,1080);  //scene
       
        //background
        Background background = FXFuns.insertBackground(primaryStage);

        //insert rectangle
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage);

        //insert image in button
        ImageView adminImageView = FXFuns.insertImage("file:userLogo.png",primaryStage,50,25,250,250);        
        ImageView customerImageView = FXFuns.insertImage("file:userLogo.png",primaryStage,50,25,250,250);
        ImageView organizerImageView = FXFuns.insertImage("file:userLogo.png",primaryStage,50,25,250,250);
       
        //Admin Button
        Button adminButton = new Button("Admin",adminImageView);
        adminButton.setFont(new Font("Arial",35));
        GridPane.setConstraints(adminButton, 0, 0);
        adminButton.setContentDisplay(ContentDisplay.TOP);
        adminButton.setOnAction(e ->{
            Admin admin = new Admin();
            primaryStage.setScene(admin.LoginSceneAdmin());
        });
 
        //Customer Button
        Button customerButton = new Button("Customer",customerImageView);
        customerButton.setFont(new Font("Arial",35));
        GridPane.setConstraints(customerButton, 1, 1);
        customerButton.setContentDisplay(ContentDisplay.TOP);
        customerButton.setOnAction(e -> {
            Customer customer = new Customer();
            primaryStage.setScene(customer.registerationForm());
        });  
        

        //Organizer Button
        Button organizerButton = new Button("Organizer",organizerImageView);
        organizerButton.setFont(new Font("Arial",35));
        GridPane.setConstraints(organizerButton, 2, 0);
        organizerButton.setContentDisplay(ContentDisplay.TOP);
        organizerButton.setOnAction(e ->{
            Organizer organizer = new Organizer();
            primaryStage.setScene(organizer.LoginSceneOrganizer());
        });
        
        
        //layout
        layout.getChildren().addAll(adminButton,customerButton,organizerButton);
        root.getChildren().addAll(rectangle,layout);  
        root.setBackground(background);
        
        //satge
        primaryStage.setTitle("Wedding Planner");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
}


    