package weddingplannerfx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WeddingInfo {
    int weddingId;
    Venue myVenue;
    Catering myCatering ;
    DecorationDetails decorations;
    Customer customer;
    Organizer organizer;
    
    public void WriteToFile(){
         try {
            ObjectOutputStream addWeddingInfo = new ObjectOutputStream(new FileOutputStream("WeddingInfo.bin",true));
            addWeddingInfo.write(22);
            addWeddingInfo.writeObject(new Venue("venue 3",70000f,400));
            addWeddingInfo.writeObject(new Catering("Chicken",100f));
            addWeddingInfo.writeObject(new DecorationDetails("Seating",150f));
            addWeddingInfo.writeObject(new Customer("Dr.walaa","Dr.walaa@gmail.com","1234","01234567890"));
            addWeddingInfo.writeObject(new Organizer("Mahmoud","Mahmoud@gmail.com","1122","01234567899"));
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("");
        }
    }
}