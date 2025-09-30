/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lukas Wong
 */
public class CustomerStuff {
    private static final Files files = new Files();
    private static final ArrayList<Customer> customers = new ArrayList<>();        //arraylist of type Customer named customers

    public void restockArrays() throws IOException {
        ArrayList<Customer> tempCustomers = files.readCustomerFile();
        customers.addAll(tempCustomers);
    }

    public void addCustomer(Customer created) {         //add a customer
        customers.add(created);
    }

    public void deleteCustomer(Customer selected) {         //delete the customer the user selects
        customers.remove(selected);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Customer> getCustomers() {
        return (ArrayList<Customer>) customers.clone();
    }
    
}
