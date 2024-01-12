package weddingplannerfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


public class BudgetScene extends Application {
    VBox vbox = new VBox();
    GridPane gridpane = new GridPane();
    
    @Override
    public void start(Stage primaryStage) {
        vbox.setPadding(new Insets(100,1000,100,1000)); 

        TextField budgetTextField = new TextField();
        budgetTextField.setPromptText("Budget");
        budgetTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));

        Button budgetButton = new Button("Set Budget");
        budgetButton.setFont(new Font("Arial",22));
        budgetButton.setOnAction(e -> {
            
        });
        
      
                //title
        Text title = new Text("Enter your Budget");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
        Rectangle rectangle = FXFuns.insertRectangle(primaryStage); 
        Background bg = FXFuns.insertBackground(primaryStage);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        vbox.getChildren().addAll(title,budgetTextField,budgetButton);
        
        //scene layout
        StackPane root = new StackPane();
        root.setBackground(bg);
        root.getChildren().addAll(rectangle,vbox);

        //scene
        Scene budgets = new Scene(root,1920,1090);
        primaryStage.setScene(budgets);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
