package weddingplannerfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PaymentScene extends Application {    
    @Override
    public void start(Stage primaryStage){            
        Background bg = FXFuns.insertBackground(primaryStage);
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(1000,1000,1000,1000)); 
        vbox.setSpacing(100);
        
        
        HBox hbox = new HBox();
        hbox.setSpacing(15);
        hbox.setAlignment(Pos.CENTER);

       
        Text title = new Text("Please choose your preferred payment method:");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
        Button btncash = new Button("Cash");
        btncash.setFont(new Font("Arial",22));

        Button btnvisa = new Button("Credit Card");
        btnvisa.setFont(new Font("Arial",22));
        
        hbox.getChildren().addAll(btncash,btnvisa);
        vbox.getChildren().addAll(title,hbox);
       

       btncash.setOnAction(e->{
          FXFuns.displayMessage("Cash Payment", "Your total amount is ... Please head to our office to finish the payment.");
       });
       
//       btnvisa.setOnAction(e->{
//           primaryStage.setScene (scene2);
//       });
//       
       StackPane root = new StackPane();
       root.getChildren().addAll(rectangle,vbox);
       root.setBackground(bg); 
       Scene scene = new Scene(root,1920,1080);
       
       primaryStage.setTitle ("Payment Method");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

          
    public static void main(String[] args) {
        launch(args);
    }
    
}
