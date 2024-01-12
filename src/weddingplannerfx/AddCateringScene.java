package weddingplannerfx;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class AddCateringScene extends Application implements Serializable{
    
    @Override
    public void start(Stage primaryStage) {
        Background bg = FXFuns.insertBackground(primaryStage);
        
        BorderPane cateringlayout = FXFuns.setMenu();
        Scene CateringScene = new Scene(cateringlayout,1920,1080);
        cateringlayout.setBackground(bg);
        
        BorderPane menu = FXFuns.setMenu();
        
        TableView<Catering> table = new TableView<>();
        TableColumn<Catering, String> nameColumn = new TableColumn<>("Catering name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("dishName"));
        nameColumn.setMinWidth(120);
        TableColumn<Catering, Float> priceColumn = new TableColumn<>("Catering Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("dishPrice"));
        priceColumn.setMinWidth(100);
        table.getColumns().addAll(nameColumn, priceColumn);
        cateringlayout.setCenter(table);
        table.setOpacity(0.8);
        
        TextField nameText = new TextField();
        nameText.setPromptText("Dish name");
        TextField priceText = new TextField();
        priceText.setPromptText("Dish price");
        
        Button addBtn = new Button("Add");
        ObservableList<Catering> AllCateringsob = FXCollections.observableArrayList(Admin.ViewCatering());
        table.setItems(AllCateringsob);
        Catering catering= new Catering();
        ArrayList<Catering> cateringList= new ArrayList<>();
        addBtn.setOnAction(e->{
            catering.setDishName(nameText.getText());
            catering.setDishPrice(Float.parseFloat(priceText.getText()));
            table.getItems().add(catering);
            cateringList.add(catering);
            Admin.AddCatering(catering);
            nameText.clear();
            priceText.clear();
            Admin.AddCatering(catering);
        });
        
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e->{
            ObservableList<Catering> cateringSelected, allcatering;
            allcatering = table.getItems();
            cateringSelected = table.getSelectionModel().getSelectedItems();
            cateringSelected.forEach(allcatering::remove);
        });
        
        HBox Hb1 = new HBox();
        Hb1.setPadding(new Insets(10, 10, 10, 10));
        Hb1.setSpacing(10);
        Hb1.getChildren().addAll(nameText, priceText,addBtn, deleteBtn);
        cateringlayout.setBottom(Hb1);
        
        primaryStage.setScene(CateringScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
