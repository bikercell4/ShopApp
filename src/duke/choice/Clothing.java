/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 *
 * @author morgenjohnson
 */
public class Clothing implements Comparable<Clothing> {
   
    private String description;
    private double price;
    private String size = "M";
    public static final double MIN_PRICE = 10;
    public static final double TAX = .2;
    
     public Clothing(String description, double price, String newSize) {
        this.description = description;
        this.price = price;
        size = newSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return (price * TAX) + price;
    }
    
    public void setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price: MIN_PRICE;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getMinPrice() {
        return MIN_PRICE;
    }
    
     @Override
   public String toString() {
        return getDescription() + ", " + getPrice() + ", " + getSize();
    }
    
   @Override
   public int compareTo(Clothing c) {
       return this.description.compareTo(c.description);
   }

}

   

    
    

