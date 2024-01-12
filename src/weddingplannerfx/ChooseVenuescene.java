package weddingplannerfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class ChooseVenuescene extends Application {
    
    public void start(Stage primaryStage) {
        BorderPane Venuelayout = new BorderPane();
        FXFuns.insertBackground(primaryStage);
        FXFuns.setMenu();
        Scene ChooseVenue=new Scene(Venuelayout, 1920,1080);
        
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
        table.getColumns().addAll(nameColumn, priceColumn, capacityColumn);
        Venuelayout.setCenter(table);
        table.setOpacity(0.8);
        Venuelayout.setCenter(table);
        
        
        Button chooseBtn = new Button("Choose");
        ObservableList<Venue> AllVenuesob = FXCollections.observableArrayList(Admin.ViewVenues());
        AllVenuesob.add(new Venue("Venue 2",50000f,300));
        AllVenuesob.add(new Venue("Venue 3",70000f,400));
        AllVenuesob.add(new Venue("Venue 4",30000f,200));
        table.setItems(AllVenuesob);
        Venue venue = new Venue();
        chooseBtn.setOnAction((ActionEvent e) -> {
            ObservableList<Venue> venueSelected, allVenues;
            allVenues = table.getItems();
            venueSelected = table.getSelectionModel().getSelectedItems();
        });
        HBox Hb1 = new HBox();
        Hb1.setPadding(new Insets(10, 10, 10, 10));
        Hb1.setSpacing(10);
        Hb1.getChildren().add(Hb1);
        Venuelayout.setBottom(Hb1);
        
        primaryStage.setScene(ChooseVenue);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
