package weddingplannerfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class CardScene extends Application {
    private GridPane gridpane = new GridPane();
    private VBox vbox = new VBox();
    
    
    @Override
    public void start(Stage primaryStage) {
        //data layout
        gridpane.setPadding(new Insets(50,120,10,760)); 
        gridpane.setVgap(30);
        gridpane.setHgap(30);
        
        Label nameLabel = new Label("Name on the card");
        nameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(nameLabel, 0, 0);
        
        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Name");
        nameTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(nameTextField, 1, 0);
        
        Label ccLabel = new Label("Card number");
        ccLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(ccLabel, 0, 1);
        
        TextField ccTextField = new TextField();
        ccTextField.setPromptText("card number");
        ccTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(ccTextField, 1, 1);
                
        Label dateLabel = new Label("Expiration date");
        dateLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(dateLabel, 0, 2);
        
        TextField dateTextField = new TextField();
        dateTextField.setPromptText("expiration date");
        dateTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(dateTextField, 1, 2);
        
        Label cvvLabel = new Label("CVV");
        cvvLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(cvvLabel, 0, 3);
        
        TextField cvvTextField = new TextField();
        cvvTextField.setPromptText("cvv");
        cvvTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(cvvTextField, 1, 3);
        
        Button btnpay = new Button("FINISH PAYMENT");
        btnpay.setFont(new Font("Arial",22));
        
        btnpay.setOnAction(e -> {
            CreditCard card = new CreditCard();
           // boolean isccValid = card.formatCCInput();
           // if(isccValid){
             //   
               // System.out.println(isccValid);
            //}

            
        });
        
        
        
        //title
        Text title = new Text("Please enter the following details");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
       
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage); 
        Background bg = FXFuns.insertBackground(primaryStage);
        gridpane.getChildren().addAll(nameLabel,nameTextField,ccLabel,ccTextField,dateLabel,dateTextField,cvvLabel,cvvTextField);        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        vbox.getChildren().addAll(title,gridpane,btnpay);
        
        //scene layout
        StackPane root = new StackPane();
        root.setBackground(bg);
        root.getChildren().addAll(rectangle,vbox);

        //scene
        Scene scene = new Scene(root,1920,1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
    
    
}
