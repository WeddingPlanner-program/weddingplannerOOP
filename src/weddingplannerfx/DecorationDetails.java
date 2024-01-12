
package weddingplannerfx;

import java.io.Serializable;

    
public class DecorationDetails implements Serializable{
    String DecorationName;
    float DecorationPrice;

    public DecorationDetails(String DecorationName, float DecorationPrice) {
        this.DecorationName = DecorationName;
        this.DecorationPrice = DecorationPrice;
    }

    DecorationDetails() {
        
    }

    public String getDecorationName() {
        return DecorationName;
    }

    public void setDecorationName(String DecorationName) {
        this.DecorationName = DecorationName;
    }

    public float getDecorationPrice() {
        return DecorationPrice;
    }

    public void setDecorationPrice(float DecorationPrice) {
        this.DecorationPrice = DecorationPrice;
    }
    
}