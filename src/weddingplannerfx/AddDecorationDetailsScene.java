package weddingplannerfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class AddDecorationDetailsScene extends Application implements Serializable{
    
    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("file:background.png");
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT, //x
                BackgroundRepeat.NO_REPEAT, //y
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );
        Background bg = new Background(bgImage);
        BorderPane Decorationlayout = new BorderPane();
        Scene DecorationScene = new Scene(Decorationlayout, 1920, 1080);
        Decorationlayout.setBackground(bg);
        
        Menu adminMenu1 = new Menu("Home");
        Menu adminMenu2 = new Menu("Add...");
        MenuItem AddItem1 = new MenuItem("Add organizers...");
        MenuItem AddItem2 = new MenuItem("Add venues...");
        MenuItem AddItem3 = new MenuItem("Add catering...");
        MenuItem AddItem4 = new MenuItem("Add decoration details...");
        adminMenu2.getItems().addAll(AddItem1, AddItem2, AddItem3, AddItem4);
        MenuBar adminMenuBar = new MenuBar();
        adminMenuBar.getMenus().addAll(adminMenu1, adminMenu2);
        Decorationlayout.setTop(adminMenuBar);
        
        TableView<DecorationDetails> table = new TableView<>();
        TableColumn<DecorationDetails, String> nameColumn = new TableColumn<>("Decoration name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("DecorationName"));
        nameColumn.setMinWidth(120);
        TableColumn<DecorationDetails, Float> priceColumn = new TableColumn<>("Decoration Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("DecorationPrice"));
        priceColumn.setMinWidth(100);
        table.getColumns().addAll(nameColumn, priceColumn);
        Decorationlayout.setCenter(table);
        table.setOpacity(0.8);
        
        TextField nameText = new TextField();
        nameText.setPromptText("Decoration name");
        TextField priceText = new TextField();
        priceText.setPromptText("Decoration price");
        
        Button addBtn = new Button("Add");
        ObservableList<DecorationDetails> AllDecorationsob = FXCollections.observableArrayList(Admin.ViewDecoration());
        AllDecorationsob.add(new DecorationDetails("Welcome sign",300f));
        AllDecorationsob.add(new DecorationDetails("Seating",150f));
        AllDecorationsob.add(new DecorationDetails("Aisle markers",100f));
        AllDecorationsob.add(new DecorationDetails("Program display",1500f));
        AllDecorationsob.add(new DecorationDetails("Order of events sign",300f));
        table.setItems(AllDecorationsob);
        DecorationDetails decoration= new DecorationDetails();
        ArrayList<DecorationDetails> decorationList= new ArrayList<>();
        addBtn.setOnAction(e->{
            decoration.setDecorationName(nameText.getText());
            decoration.setDecorationPrice(Float.parseFloat(priceText.getText()));
            table.getItems().add(decoration);
            decorationList.add(decoration);

            Admin.AddDecoration(decoration);
        });
        
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e->{
            ObservableList<DecorationDetails> decorationSelected, alldecoration;
            alldecoration = table.getItems();
            decorationSelected = table.getSelectionModel().getSelectedItems();
            decorationSelected.forEach(alldecoration::remove);
        });
        
        HBox Hb1 = new HBox();
        Hb1.setPadding(new Insets(10, 10, 10, 10));
        Hb1.setSpacing(10);
        Decorationlayout.setBottom(Hb1);
        
        primaryStage.setScene(DecorationScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
