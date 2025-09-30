/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public void bookFileWrite(ArrayList<Book> books) throws IOException {
        FileWriter bookFile = new FileWriter("books.txt", true);            //creates new fileWriter named bookFile for books.txt
        for (Book b : books) {
            String bookInfo = b.getBookName() + ", " + b.getBookPrice() + "\n";     //puts bookname and bookprice into bookInfo string
            bookFile.write(bookInfo);                                               //writes bookinfo into bookfile so it can go to books.txt
        }
        bookFile.close();                                                           //closes book file
    }

    public void customerFileWrite(ArrayList<Customer> customers) throws IOException {
        FileWriter customerFile = new FileWriter("customers.txt", true);            //creates new fileWriter named customerFile for customers.txt
        for (Customer c : customers) {
            String outputText = c.getCustomerUser() + ", " + c.getCustomerPass() + ", " + c.getCustomerPass() + "\n";       //puts customerUser and customerPass into outputText string
            customerFile.write(outputText);                                         //writes outputText into customerfile so it can go to customers.txt
        }
        customerFile.close();                                                       //closes customerfile
    }

    public void bookFileReset() throws IOException {
        FileWriter bookFile = new FileWriter("books.txt", false);           //resets books.txt file
        bookFile.close();                                                   //closes bookFile
    }

    public void customerFileReset() throws IOException {
        FileWriter customerFile = new FileWriter("customers.txt", false);       //resets customers.txt file
        customerFile.close();                                                   //coses customerFile
    }

    public ArrayList<Book> readBookFile() throws IOException {
        Scanner scan = new Scanner(new FileReader("books.txt"));            //scan from books.txt
        ArrayList<Book> tempBookHolder = new ArrayList<>();                 //creates arraylist with temporary book holder

        while (scan.hasNext()) {
            String[] bookInfo = scan.nextLine().split(",");                 //takes book info seperated by ,
            String title = bookInfo[0];                                     //first thing is the book title (before ,)
            double price = Double.parseDouble(bookInfo[1]);                 //seconf thing is book price (after ,)
            tempBookHolder.add(new Book(title, price));                     //adds book title and price to temporary book holder
        }
        return tempBookHolder;
    }

    public ArrayList<Customer> readCustomerFile() throws IOException {
        Scanner scan = new Scanner(new FileReader("customers.txt"));        //scan from customers.txt
        ArrayList<Customer> tempCustomerHolder = new ArrayList<>();         //creates arraylist with temoorary customer holder

        while (scan.hasNext()) {
            String[] customerInfo = scan.nextLine().split(", ");            //takes customer info seperated by ,
            String username = customerInfo[0];                              //first rhing is customer user (before ,)
            String password = customerInfo[1];                              //second thing is customer pass (after ,)
            int points = Integer.parseInt(customerInfo[2]);                 //third thing is customer ponts (after 2nd ,)
            tempCustomerHolder.add(new Customer(username, password));       //adds customer user and pass to temporary customer holder
            tempCustomerHolder.get(tempCustomerHolder.size() - 1).setCustomerPoints(points);
        }
        return tempCustomerHolder;
    }
}