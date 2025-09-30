/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;
import java.util.ArrayList;     //to get arraylists
import java.util.List;          //to get lists
/**
 *
 * @author Lukas Wong
 */
/*
WHAT IS NEEDED:
add customer with username and password
delete customer
checkout items
checkout and redeem points
get points, total cost
set points
*/
public class CheckoutStuff {
    //inst var for checkout stuff
    double totalCost = 0;
    int points;
    ArrayList<Book> checkoutItems = new ArrayList<>();      //arraylist of type Book named checkoutItems
    
    public void checkoutAdd(Book b) {       //checkout add book method
        checkoutItems.add(b);
    }
    
    public void checkoutAdd(List<Book> list) {      //checkout add book method
        checkoutItems.addAll(list);
    }
    
    public void checkoutDelete(Book b) {        //checkout delete book method
        checkoutItems.remove(b);
    }
    
    public void checkoutDelete(List<Book> list) {       //checkout delete book method
        checkoutItems.removeAll(list);
    }
    
    public void Checkout() {
        checkoutItems.clear();
        totalCost = 0;
    }
    
    public double redeemPointsAndBuy() {        //redeem points and buy method
        while (points >= 100) {                 //while statement keeps going until there are no points left
            totalCost = totalCost - 1;          //decucts $1 from total cost since 100points = $1
            points = points - 100;              //updates total points by subtracting 100 since its converting them to dollars  
            if (totalCost < 1) {                //if the total cost hits 0 before points are done, while statement ends
                break;
            }
        }
        return totalCost;
    }
    
    public ArrayList<Book> getCheckout() {      //checkout method
        return checkoutItems;
    }
    
    public int getPoints() {        //get points method
        return points;
    }

    public double getTotalCost() {      //get total cost method
        totalCost = 0;

        for (Book bk : checkoutItems) {
            totalCost += bk.getBookPrice();
        }
        
        System.out.println("Total Cost(TC): $" + totalCost);
        
        return totalCost;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
}
