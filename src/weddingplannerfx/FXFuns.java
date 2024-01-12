package weddingplannerfx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXFuns {
   public static Background insertBackground(Stage stage){
        Image image = new Image("file:background.png");
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,   //x
                BackgroundRepeat.NO_REPEAT,   //y
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true)
        );
        Background background = new Background(bgImage);
        return background;
    }
    
    public static Rectangle insertRectangle(Stage stage){
        Rectangle rectangle = new Rectangle(950,700);
        rectangle.setArcHeight(50);       
        rectangle.setArcWidth(50);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setOpacity(0.8);
        return rectangle;
    }
    
    public static ImageView insertImage(String img,Stage stage,int x,int y, int w,int h){
        Image image = new Image(img);
        ImageView imageView = new ImageView(image);                
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
        imageView.setPreserveRatio(true);
        return imageView;
    }
    
    public static void displayMessage(String title,String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);  //block user interaction with other windows until this window is closed
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);
        label.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));

        Button okButton = new Button("OK");
        okButton.setOnAction(e->window.close());
        
        VBox layout = new VBox(10,label,okButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout,400,170);
        window.setScene(scene);
        window.showAndWait();//display window and before returning to the previous window it should be closed  
    }
    
    public static BorderPane setMenu(){
        BorderPane layout = new BorderPane();

        MenuBar menubar = new MenuBar();
        
        Menu menu1 = new Menu("Home");
        Menu menu2 = new Menu("View");
        
        MenuItem homeItem = new MenuItem("Home");
        homeItem.setOnAction(e -> {
            AdminUI admins = new AdminUI();
            Stage s = new Stage();
            admins.start(s);
        });
        
        MenuItem organizerItem = new MenuItem("Organizers");
        organizerItem.setOnAction(e -> {
            AddOrganizerScene venueScene = new AddOrganizerScene();
            Stage s = new Stage();
            venueScene.start(s);           
        });
        
        MenuItem venueItem = new MenuItem("Venues");
        venueItem.setOnAction(e -> {
            AddVenueScene venueScene = new AddVenueScene();
            Stage s = new Stage();
            venueScene.start(s);           
        });
        
        
        MenuItem cateringItem = new MenuItem("Catering");
            cateringItem.setOnAction(e -> {
            AddCateringScene caterings = new AddCateringScene();
            Stage s = new Stage();
            caterings.start(s);
        });
        
        MenuItem DecorationItem = new MenuItem("Decoration details");
        DecorationItem.setOnAction(e -> {
            AddDecorationDetailsScene decorations = new AddDecorationDetailsScene();
            Stage s = new Stage();
            decorations.start(s);
        });
        menu1.getItems().add(homeItem);
        menu2.getItems().addAll(organizerItem, venueItem, cateringItem, DecorationItem);
        
        menubar.getMenus().addAll(menu1, menu2);
        layout.setTop(menubar);
        return layout;
    }
}
