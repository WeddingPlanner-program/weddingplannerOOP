package weddingplannerfx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Customer extends User{
    public TextField nameTextField;
    public TextField usernameTextField;
    public PasswordField passwordHidden;
    public TextField numberTextField;
    
   public Customer() {
    }

    Customer(String drwalaa, String drwalaagmailcom, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Scene registerationForm(){
        Stage stage = new Stage();
        LoginScene_customer logins = new LoginScene_customer();
       
        //data layout
        gridpane.setPadding(new Insets(20,10,10,670)); 
        gridpane.setVgap(20);
        gridpane.setHgap(8);
                  
        //title
        Text title = new Text("Registeration Form");
        title.setFont(Font.font("Arial",FontWeight.BOLD,35));

        //labels,textfields,buttons
        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(nameLabel, 0, 1);
        
        nameTextField = new TextField();
        nameTextField.setPromptText("Name");
        nameTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(nameTextField, 1, 1);
        
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(usernameLabel, 0, 2);

        usernameTextField = new TextField();
        usernameTextField.setPromptText("example@example.com");
        usernameTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(usernameTextField, 1, 2); 
        
        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(passwordLabel, 0, 3);
        
        passwordHidden = new PasswordField();
        passwordHidden.setPromptText("Password");
        GridPane.setConstraints(passwordHidden, 1, 3);
        passwordHidden.setFont(Font.font("Arial", FontWeight.NORMAL, 18));

        
        Label numberLabel = new Label("Phone Number");
        numberLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(numberLabel, 0, 4);
   
        numberTextField = new TextField();
        numberTextField.setPromptText("Phone Number");
        numberTextField.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        GridPane.setConstraints(numberTextField, 1, 4);
        
        Button signupButton = new Button("Sign up");
        signupButton.setFont(new Font("Arial",22));
        GridPane.setConstraints(signupButton, 1, 5);
        signupButton.setOnAction(e -> {
            //Retrieve data
            name = nameTextField.getText();
            username = usernameTextField.getText();
            password = passwordHidden.getText();
            number = numberTextField.getText();
            if( name != null && number != null && username != null && password!=null && ! name.isEmpty() && !number.isEmpty() && !username.isEmpty() && !password.isEmpty()){
                try {
                    boolean isusernamevalid = usernameValidation(username);
                    if(isusernamevalid){
                        saveData(username,password,name,number);
                        Stage s = new Stage();
                        logins.start(s);
                        stage.close();   
                    }
                    else if(!isusernamevalid) 
                        FXFuns.displayMessage("Sign up Error","username is invalid!,\n username should be: example@example.com");

                }catch (IOException ex) {
                    System.out.println("File not found!");
                }
            } else{
                FXFuns.displayMessage("Sign up Error","Data is not completed!");
            } 
        });
        
        Text accountQues = new Text("Already have an account?");
        accountQues.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 22));
        GridPane.setConstraints(accountQues, 0, 6);
        
        Button loginButton_cust = new Button("Log in");
        loginButton_cust.setFont(new Font("Arial",22));
        GridPane.setConstraints(loginButton_cust, 1, 6);

        loginButton_cust.setOnAction(e ->{
            Stage s = new Stage();
            logins.start(s);
            stage.close();
        });
       
        //layout (title-data)
        StackPane registerRoot = new StackPane();                               //root layout
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title,gridpane);
        gridpane.getChildren().addAll(accountQues,loginButton_cust,signupButton,nameLabel,usernameLabel,passwordLabel,numberLabel,nameTextField,usernameTextField,passwordHidden,numberTextField);
        
        //scene layout
        registerRoot.setBackground(bg);
        registerRoot.getChildren().addAll(rectangle,vbox);

        //scene
        Scene registerationScene = new Scene(registerRoot,1920,1080);
        stage.setScene(registerationScene);
        return registerationScene;
    }
    
    public void saveData(String username,String pass,String name,String num) throws IOException{
        FileOutputStream outstream = new FileOutputStream("Registeration.bin",true);
        DataOutputStream out = new DataOutputStream(outstream);
        try{
            out.writeUTF(username);
            out.writeUTF(pass);
            out.writeUTF(name);
            out.writeUTF(num);
            System.out.println("Data saved");
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0); 
        }
        out.flush();
        out.close();
    }   

    
    @Override
    public void loginChecker(String enteredUsername,String enteredPass) throws IOException{
        Stage stage = new Stage();
        boolean isValid = false;
        boolean found = false;
        FileInputStream instream = new FileInputStream("Registeration.bin");
        DataInputStream in = new DataInputStream(instream);
        try{
            try{
                while(true){
                    String fileUsername = in.readUTF();
                    String pass = in.readUTF();
                    String n = in.readUTF();
                    String num = in.readUTF();
                    if(fileUsername.equals(enteredUsername)){
                        found = true;
                        if(pass.equals(enteredPass)){
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
            BudgetScene budgets = new BudgetScene();
            Stage s = new Stage();
            budgets.start(s);
            stage.close();
        }
        else if(!isValid && found)
            FXFuns.displayMessage("Log in Error", "Incorrect Password,Please try again..");
        if(!found)
            FXFuns.displayMessage("Log in Error", "Email is not found!");
            
    }
    
    
    public boolean usernameValidation(String username){
        String regexPattern = "\\w+[-._=*+/]*\\w@[a-zA-Z]+\\.com";
        String tex = username;
        Pattern pt= Pattern.compile(regexPattern);
        Matcher mt = pt.matcher(tex);
        return mt.matches();
    }
   

}
