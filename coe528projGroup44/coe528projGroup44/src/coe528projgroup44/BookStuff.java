/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;
import java.io.IOException;
import java.util.ArrayList;

public class BookStuff {
    private static final Files files = new Files();
    protected static ArrayList<Book> books = new ArrayList<>(); //do same here as customer

    public void restockArrays() throws IOException {
        ArrayList<Book> tempBooks = files.readBookFile();
        books.addAll(tempBooks);
    }
}
