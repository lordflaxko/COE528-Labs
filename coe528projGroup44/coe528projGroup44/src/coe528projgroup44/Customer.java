/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;

/**
 *
 * @author Lukas Wong
 */
/*
WHAT IS NEEDED:
get customer username & password
set customer username & password
set customer status
 */
public class Customer {
    //inst var for Customer.java
    private final String customerUser;
    private final String customerPass;
    private int customerPoints;
    private String customerStatus;

    Customer(String customerUser, String customerPass) {        //constructor for Customer
        setCustomerStatus(customerPoints);
        this.customerUser = customerUser;
        this.customerPass = customerPass;
        customerPoints = 0;
    }

    public String getCustomerUser() {       //get customer username method
        return customerUser;
    }

    public String getCustomerPass() {       //get customer password method
        return customerPass;
    }

    public int getCustomerPoints() {        //get customer points method
        return customerPoints;
    }
    
    public String getCustomerStatus() {                     //get customer status
        return customerStatus;
    }

    public void setCustomerPoints(int customerPoints) {     //set customer points
        this.customerPoints += customerPoints;              //sets customer poitns to its previous value + any new points
        setCustomerStatus(this.customerPoints);             //set customer status based on points
    }

    private void setCustomerStatus(int customerPoints) {        //set customer status to gold / silv based on points
        if (customerPoints >= 1000) {
            customerStatus = "Gold";
        } else {
            customerStatus = "Silver";
        }
    }
    
    @Override
    public String toString() {
        return "Username: " + customerUser + "\nPassword: " + customerPass + "\nPoints: " + customerPoints + "\n";
    }
}
