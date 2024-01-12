package weddingplannerfx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin extends User{

    static void AddOrganizer(ArrayList<Organizer> organizerList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Admin() {
    }

    public Admin(String name, String number, String username, String password) {
        super(name, number, username, password);
    }
    
    
    public static void AddVenues(Venue venue) throws FileNotFoundException {
        try {
            try (ObjectOutputStream addVenue = new ObjectOutputStream(new FileOutputStream("venues.bin",true))) {
                addVenue.writeObject(venue);
                addVenue.close();
            }
        } catch (IOException ex) {
            System.out.println("");
        }
    }
    
    public static ArrayList<Venue> ViewVenues() {
        Venue v = new Venue();
        ArrayList<Venue>venues= new ArrayList<>();
           try( ObjectInputStream viewvenue = new ObjectInputStream(new FileInputStream("venues.bin"))){
                while( (v = (Venue) viewvenue.readObject()) != null){
                    venues.add(v);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("");
        }
        return venues;
    }
    
    public static void AddCatering(Catering catering){
        try {
            ObjectOutputStream addCatering = new ObjectOutputStream(new FileOutputStream("catering.bin",true));
            addCatering.writeObject(catering);
            addCatering.close();
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("");
        }
    }
    public static ArrayList<Catering> ViewCatering (){
        Catering catering = new Catering();
        ArrayList<Catering>cateringList= new ArrayList<>();
           try( ObjectInputStream viewcatering = new ObjectInputStream(new FileInputStream("catering.bin"))){
                while( (catering = (Catering) viewcatering.readObject()) != null){
                    cateringList.add(catering);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("");
        }
        return cateringList;
    }
    public static void AddDecoration(DecorationDetails decoration){
        try {
            ObjectOutputStream addDecoration = new ObjectOutputStream(new FileOutputStream("DecorationDetails.bin",true));
            addDecoration.writeObject(decoration);
            addDecoration.close();
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("");
        }
    }
    public static ArrayList<DecorationDetails> ViewDecoration (){
        DecorationDetails decoration = new DecorationDetails();
        ArrayList<DecorationDetails>decorationList= new ArrayList<>();
           try( ObjectInputStream viewdecoration = new ObjectInputStream(new FileInputStream("DecorationDetails.bin"))){
                while( (decoration = (DecorationDetails) viewdecoration.readObject()) != null){
                    decorationList.add(decoration);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("");
        }
        return decorationList;
    }
    public static void AddOrganizer(Organizer organizers){
        try {
            ObjectOutputStream addOrganizer = new ObjectOutputStream(new FileOutputStream("organizers.bin",true));
            addOrganizer.writeObject(organizers);
            addOrganizer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("");
        }
    }
    public static ArrayList<Organizer> ViewOrganizer(){
        Organizer organizer = new Organizer();
        ArrayList<Organizer>OrganizerList= new ArrayList<>();
           try( ObjectInputStream vieworganizer = new ObjectInputStream(new FileInputStream("organizers.bin"))){
                while( (organizer = (Organizer) vieworganizer.readObject()) != null){
                    OrganizerList.add(organizer);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("");
        }
        return OrganizerList;
    }

    public Scene LoginSceneAdmin(){
        Stage stage = new Stage();

        gridpane.setPadding(new Insets(50,120,10,760)); 
        gridpane.setVgap(30);
        gridpane.setHgap(8);
        
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(usernameTextField, 1, 0);
 
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        GridPane.setConstraints(passwordTextField, 1, 1);
        passwordTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); 

        
        loginButton = new Button("Log in");
        loginButton.setFont(new Font("Arial",22));
        loginButton.setOnAction(e -> {
        username = usernameTextField.getText();
        password = passwordTextField.getText();
            try {
                saveData();
                loginChecker(username,password);
            } catch (IOException ex) {
                System.out.println("File is not found");;
            }
        });
        
        //title
        Text title = new Text("Sign in");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));
        
        Rectangle rectangle = FXFuns.insertRectangle(stage); 
        Background bg = FXFuns.insertBackground(stage);
        gridpane.getChildren().addAll(usernameLabel,usernameTextField,passwordLabel,passwordTextField);        
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        vbox.getChildren().addAll(title,gridpane,loginButton);
        
        //scene layout
        StackPane logRoot = new StackPane();
        logRoot.setBackground(bg);
        logRoot.getChildren().addAll(rectangle,vbox);

       //scene
        Scene loginScene = new Scene(logRoot,1920,1080);
        return loginScene;

    }
    
    public void saveData() throws IOException{
        FileOutputStream outstream = new FileOutputStream("Admin Login.bin");
        DataOutputStream out = new DataOutputStream(outstream);
        out.writeUTF("sara2003@gmail.com");
        out.writeUTF("Sara=2003");        
        out.writeUTF("safeya2002@gmail.com");
        out.writeUTF("Safeya=2002");        
        out.writeUTF("mariam2002@gmail.com");
        out.writeUTF("Mariam=2002");        
        out.writeUTF("jana2003@gmail.com");
        out.writeUTF("Jana=2003");
        System.out.println("Data saved");
        out.flush();
        out.close();
    }

    @Override
    public void loginChecker(String enteredUsername,String enteredPass) throws IOException{
        Stage stage = new Stage();
        boolean isValid = false;
        boolean found = false;
        FileInputStream instream = new FileInputStream("Admin Login.bin");
        DataInputStream in = new DataInputStream(instream);
        try{
            try{
                while(true){
                    String fileUsername = in.readUTF();
                    String filepass = in.readUTF();
                    if(fileUsername.equals(enteredUsername)){
                        found = true;
                        if(filepass.equals(enteredPass)){
                            isValid = true;
                            break;
                        }
                    }
                }
            }catch(EOFException e){
                System.out.println("Done reading file");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        in.close();   
        if(isValid){
            AdminUI admins = new AdminUI();
            Stage s = new Stage();
            admins.start(s);
            stage.close();
            System.out.println("Welcomee");
        }
        else if(!isValid && found)
            FXFuns.displayMessage("Log in Error", "Incorrect Password,Please try again..");
        else if(!found )
            FXFuns.displayMessage("Log in Error", "Email is not found!");
    }
}
