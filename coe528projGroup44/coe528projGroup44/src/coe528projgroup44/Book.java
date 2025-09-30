/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Lukas Wong
 */
/*
WHAT IS NEEDED:
get book name & price
set book title & price
select book
 */
public class Book {
    //inst var for Book.java
    private final String bookName;
    private final double bookPrice;
    public CheckBox select;

    public Book(String bookName, double bookPrice) {       //book constructor
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        select = new CheckBox();
    }

    public String getBookName() {      //get bookName methods
        return this.bookName;
    }

    public double getBookPrice() {      //get book price method
        return this.bookPrice;
    }

    public CheckBox getSelect() {       //checkbox method
        return select;
    }

    public void setSelect(CheckBox select) {        //selecting method for checkbox
        this.select = select;
    }

    @Override
    public String toString() {
        return "Title: " + bookName + "\nPrice: $" + bookPrice + "\n";
    }
}
