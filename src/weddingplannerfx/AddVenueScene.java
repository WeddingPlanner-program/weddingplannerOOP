package weddingplannerfx;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddVenueScene extends Application implements Serializable{
    
    @Override
    public void start(Stage primaryStage) {
        Background bg = FXFuns.insertBackground(primaryStage);
        BorderPane Venuelayout = FXFuns.setMenu();

        Scene VenueScene = new Scene(Venuelayout, 1920, 1080);
        Venuelayout.setBackground(bg);
        
        TableView<Venue> table = new TableView<>();
        TableColumn<Venue, String> nameColumn = new TableColumn<>("Venue name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("venueName"));
        nameColumn.setMinWidth(120);
        TableColumn<Venue, Float> priceColumn = new TableColumn<>("Venue Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("venuePrice"));
        priceColumn.setMinWidth(100);
        TableColumn<Venue, Integer> capacityColumn = new TableColumn<>("Venue Capacity up to");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("venueCapacity"));
        capacityColumn.setMinWidth(100);
        //table.setItems(venues);
        table.getColumns().addAll(nameColumn, priceColumn, capacityColumn);
        table.setOpacity(0.8);
        Venuelayout.setCenter(table);
        
        
        TextField nameText = new TextField();
        nameText.setPromptText("name");
        TextField priceText = new TextField();
        priceText.setPromptText("price");
        TextField capacityText = new TextField();
        capacityText.setPromptText("capacity");
        
        Button addBtn = new Button("Add");
        Venue venue = new Venue();
        //ArrayList<Venue> AllVenues = new ArrayList<>();
        //AllVenues = (ArrayList<Venue>) Admin.ViewVenues();
      //  ObservableList<Venue> AllVenuesob = FXCollections.observableArrayList(Admin.ViewVenues());
      //  table.setItems(AllVenuesob);
        addBtn.setOnAction( e -> {
            //Admin.ViewVenues();
            //table.setItems(AllVenuesob);
            ArrayList<Venue> AddVenues = new ArrayList<>();
            venue.setVenueName(nameText.getText());
            venue.setVenuePrice(Float.parseFloat(priceText.getText()));
            venue.setVenueCapacity(Integer.parseInt(capacityText.getText()));
            table.getItems().add(venue);
         //   Admin.AddVenues(AddVenues);
            nameText.clear();
            priceText.clear();
            capacityText.clear();
        });
        
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            ObservableList<Venue> venueSelected, allVenues;
            allVenues = table.getItems();
            venueSelected = table.getSelectionModel().getSelectedItems();
            venueSelected.forEach(allVenues::remove);
        });
        
        HBox Hb1 = new HBox();
        Hb1.setPadding(new Insets(10, 10, 10, 10));
        Hb1.setSpacing(10);
        Hb1.getChildren().addAll(nameText, priceText, capacityText, addBtn, deleteBtn);
        Venuelayout.setBottom(Hb1);
        
        primaryStage.setScene(VenueScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
