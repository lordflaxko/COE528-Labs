/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList ;
import javafx.collections.FXCollections ;
import java.text.*;
import java.util.*;
import java.io.*;
/**
/**
 *
 * @author Ansugan
 */

public class Books extends Owners {
    TextField bookNameField ;
    TextField bookPriceField ;
    
    
    String bookName = bookNameField.getText() ;
    String bookPrice= bookPriceField.getText() ;
    
    private final ObservableList<Books> data =FXCollections.observableArrayList() ;
    private TableView<Books> table ;
    
    public String getBookName( ){
    return bookName ;
    }
    
    public String getBookPrice(){
        return bookPrice ;
    }
    
    public Books getBooks(Books book){
     return book ;
    }
    public void setBookName(String bookName){
        this.bookName= bookName ;
    }
    
    public void setBookPrice(String bookPrice){
      this.bookPrice=bookPrice ;   
    }
    public Books(String bookName, String bookPrice){
        super(bookName, bookPrice) ;
    }
    
    @Override
    public void deleteItem(CheckBox selection, ActionEvent event){
        
        if (selection.isSelected()){
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem()) ;
        }
    }
      
    
 
            public void handle(ActionEvent e) {
                data.add(new Books(
                        bookNameField.getText(),
                        bookPriceField.getText()));
                bookNameField.clear();
                bookPriceField.clear();

            }
}
 
    

