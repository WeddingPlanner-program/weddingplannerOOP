package weddingplannerfx;

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

public class AddOrganizerScene extends Application implements Serializable{
    
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
        BorderPane Organizerlayout = new BorderPane();
        Scene OrganizerScene = new Scene(Organizerlayout, 500, 500);
        Organizerlayout.setBackground(bg);
        
        Menu adminMenu1 = new Menu("Home");
        Menu adminMenu2 = new Menu("Add...");
        MenuItem AddItem1 = new MenuItem("Add organizers...");
        MenuItem AddItem2 = new MenuItem("Add venues...");
        MenuItem AddItem3 = new MenuItem("Add catering...");
        MenuItem AddItem4 = new MenuItem("Add decoration details...");
        adminMenu2.getItems().addAll(AddItem1, AddItem2, AddItem3, AddItem4);
        MenuBar adminMenuBar = new MenuBar();
        adminMenuBar.getMenus().addAll(adminMenu1, adminMenu2);
        Organizerlayout.setTop(adminMenuBar);
        
        TableView<Organizer> table = new TableView<>();
        TableColumn<Organizer, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameColumn.setMinWidth(120);
        TableColumn<Organizer, String> passColumn = new TableColumn<>("Password");
        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        passColumn.setMinWidth(100);
        TableColumn<Organizer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMinWidth(100);
        TableColumn<Organizer, String> numberColumn = new TableColumn<>("Phone number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        numberColumn.setMinWidth(100);
        table.getColumns().addAll(usernameColumn, passColumn, nameColumn, numberColumn);
        Organizerlayout.setCenter(table);
        
        TextField usernameText = new TextField();
        usernameText.setPromptText("Username");
        TextField passText = new TextField();
        passText.setPromptText("Password");
        TextField nameText = new TextField();
        nameText.setPromptText("Name");
        TextField numberText = new TextField();
        numberText.setPromptText("Phone number");
        
        Button addBtn = new Button("Add");
        ObservableList<Organizer> AllOrganizersob = FXCollections.observableArrayList(Admin.ViewOrganizer());
        AllOrganizersob.add(new Organizer ("mariam","1234", "mariam","01234567890"));
        AllOrganizersob.add(new Organizer ("jana","5678", "jana","01234567890"));
        AllOrganizersob.add(new Organizer ("sara","1122", "sara","01234567890"));
        AllOrganizersob.add(new Organizer ("safeya","4466", "safeya","01234567890"));
        table.setItems(AllOrganizersob);
        Organizer organizers= new Organizer();
        ArrayList<Organizer> organizerList= new ArrayList<>();
        addBtn.setOnAction(e->{
            organizers.setUsername(usernameText.getText());
            organizers.setPassword(passText.getText());
            organizers.setName(nameText.getText());
            organizers.setNumber(numberText.getText());
            table.getItems().add(organizers);
            organizerList.add(organizers);
            //Admin.AddOrganizer(organizerList);
            usernameText.clear();
            passText.clear();
            nameText.clear();
            numberText.clear();
            Admin.AddOrganizer(organizers);
        });
        
        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e->{
            ObservableList<Organizer> organizerSelected, allorganizers;
            allorganizers = table.getItems();
            organizerSelected = table.getSelectionModel().getSelectedItems();
            organizerSelected.forEach(allorganizers::remove);
            //AllOrganizersob.remove(new Organizer ("mariam","1234", "mariam","01234567890"));
        });
        
        HBox Hb1 = new HBox();
        Hb1.setPadding(new Insets(10, 10, 10, 10));
        Hb1.setSpacing(10);
        Hb1.getChildren().addAll(nameText,passText,nameText,numberText,addBtn,deleteBtn);
        Organizerlayout.setBottom(Hb1);
        
        primaryStage.setScene(OrganizerScene);
        primaryStage.show();
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

