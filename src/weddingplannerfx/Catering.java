
package weddingplannerfx;

import java.io.Serializable;


public class Catering implements Serializable{
    String dishName;
    float dishPrice;

    public Catering() {
    }

    public Catering(String dishName, float dishPrice) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(float dishPrice) {
        this.dishPrice = dishPrice;
    }
    
}