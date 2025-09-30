/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author Ansugan
 */
public class Controller3 implements Initializable {
    private List<Books> books = new ArrayList<Books>();
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private TableView<Books> tableview;
    @FXML
    private TableColumn<Books, CheckBox> colCheck;
    @FXML
    private TableColumn<Books, String> colTitle;
    @FXML
    private TableColumn<Books, Double> colPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCheck.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        initializeBooks();
        tableview.setItems(ol);
        
    }   
    
    ObservableList<Books> ol = FXCollections.observableList(books);    

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void deleteBook(ActionEvent event) {
    }

    @FXML
    private void goBack(ActionEvent event) {
    }
    private void initializeBooks() {
        
    }
    
}
    

