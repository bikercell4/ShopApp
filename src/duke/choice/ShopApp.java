/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

/**
 *
 * @author morgenjohnson
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Duke Choice Shop");
        System.out.println("The minimum price is " + Clothing.MIN_PRICE);

        Customer c1 = new Customer("Pinkey", 3);

        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5, "S");
        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");

        Clothing[] items = {item1, item2, item3, item4};
        
        try{
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder()
                    .get("/items", list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        c1.addItems(items);

        System.out.println("Customer is " + c1.getName() + ", size " + c1.getSize());
        System.out.println("the total is " + c1.getTotalClothingCost());

        for (Clothing item : c1.getItems()) {
//            System.out.println("The items are " + item.getDescription() + ", its price is "
//                    + item.getPrice() + ", and its size is " + item.getSize());
                System.out.println("Item " + item);

        }

        int average = 0;
        int count = 0;

        for (Clothing item : c1.getItems()) {
            if (item.getSize().equals("L")) {
                count++;
                average += item.getPrice();
            }
        }

        try {
            average = average / count;
            System.out.println("Average price is " + average
                    + " for " + count + " items.");
        } catch (ArithmeticException e) {
            System.out.println("There are no items in your cart.");
        }
//        if (count > 0) {
//            average = average/ count;
//        }
        Arrays.sort(c1.getItems());
        
        for (Clothing item : c1.getItems()) {
//            System.out.println("The items are " + item.getDescription() + ", its price is "
//                    + item.getPrice() + ", and its size is " + item.getSize());
                System.out.println("Item " + item);
        }

    }
}
