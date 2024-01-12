package weddingplannerfx;

import java.io.Serializable;

public class Venue implements Serializable{
    String venueName;
    float venuePrice;
    int venueCapacity;

    public Venue() {
    }

    public Venue(String venueName, float venuePrice, int venueCapacity) {
        this.venueName = venueName;
        this.venuePrice = venuePrice;
        this.venueCapacity = venueCapacity;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public float getVenuePrice() {
        return venuePrice;
    }

    public void setVenuePrice(float venuePrice) {
        this.venuePrice = venuePrice;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }
}