/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528projgroup44;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;

public class GUI extends Application {

    private final BookStuff bookStuff = new BookStuff();
    private final CustomerStuff customerStuff = new CustomerStuff();
    private Customer currentCustomer;
    private static final Files files = new Files();

    TableView<Book> booksTable = new TableView<>();                                             //creates a tableview named booksTable using books arraylist
    final TableView.TableViewFocusModel<Book> defaultFocusModel = booksTable.getFocusModel();   
    ObservableList<Book> books = FXCollections.observableArrayList();                           //observablelist based on books arraylist

    TableView<Customer> customersTable = new TableView<>();                                     //creates a tableview named customerstable using customer arraylist
    ObservableList<Customer> customers = FXCollections.observableArrayList();                   //observablelsit based on customers arraylist

    Button loginButton = new Button("Log in");                                  //login button
    Button logoutButton = new Button("Log out");                                //log out button
    Button booksButton = new Button("Books");                                   //books button
    Button customersButton = new Button("Customers");                           //customers button
    Button backButton = new Button("\uD83E\uDC60");                             //back button
    Button buyButton = new Button("Buy");                                       //buy button
    Button redeemPointsAndBuyButton = new Button("Redeem points And Buy");     //redeem points and buy button

    TextField userTextField = new TextField();                      //text box (shows what you type) 
    PasswordField passTextField = new PasswordField();              //text box (shows dots when you type)

    HBox hb = new HBox();

    public ObservableList<Book> addBooks() {                    //add method to observablelist
        books.addAll(BookStuff.books);
        return books;
    }

    public ObservableList<Customer> addCustomers() {
        customers.addAll(customerStuff.getCustomers());
        return customers;
    }

    public Group loginScreen(boolean userDNE) {
        Group lIns = new Group();                                                                   //creates new group named Lins (login Screen)
        HBox header = new HBox();                                                                   //creates new Hbox named header

        VBox loginBox = new VBox();                                                                 //creates new pane named loginBox
        loginBox.setPadding(new Insets(60, 60, 60, 60));
        loginBox.setSpacing(10);

        Label creditsLabel = new Label("Book Store Application created by:\n\tLukas Wong (501033716)\n\tSarim Aamir (501011722)\n\tAdemola Bello (501033487)\n\tAnsugan Subramaniam (501045133)");       //prompt on screen
        creditsLabel.setTranslateX(-135);                                                           //text x coordinate
        creditsLabel.setTranslateY(-500);                                                           //text y coordinate

        Text user = new Text("Username:");                                                          //creates textbox named user with Username: above it
        Text pass = new Text("Password:");                                                          //creates textbox named pass with Password: above it

        loginButton.setMinWidth(174);                                                               //sets width of login button
        loginButton.setTranslateX(200);                                                             //login button x coordinate
        loginButton.setTranslateY(75);                                                              //login button y coordiante

        loginBox.getChildren().addAll(user, userTextField, pass, passTextField, loginButton);       //adds user with userTExtField, pass with passTextField, and login button to loginBox pane

        if (userDNE) {                                                                              //if the boolean named loginError is true
            System.out.println("Error: user does not exist.");                                      //prompt on screen
        }

        VBox background = new VBox();                                                               //creates new pane named background
        background.getChildren().addAll(header, loginBox, creditsLabel);                            //adds header, loginBox, and creadts as nodes to background pane    
        background.setPadding(new Insets(80, 280, 200, 150));
        background.setSpacing(80);

        lIns.getChildren().addAll(background);                                                      //adds background to lIns group
        return lIns;
    }

    public Group ownerStartScreen() {
        Group oss = new Group();                                                        //creates new group named oss (Owner Start Screen)
        HBox header = new HBox();

        VBox ownerBox = new VBox();                                                     //creates a pane called ownerBox
        ownerBox.setPadding(new Insets(60, 60, 60, 60));
        ownerBox.setSpacing(10);

        booksButton.setMinWidth(174);                                                   //books button width
        booksButton.setTranslateY(-15);                                                 //books button y coordinate

        customersButton.setMinWidth(174);                                               //customer button width
        customersButton.setTranslateY(0);                                               //customer button y coordinate

        logoutButton.setMinWidth(174);                                                  //log out button width
        logoutButton.setTranslateY(15);                                                 //log out button y coordinate
        ownerBox.getChildren().addAll(booksButton, customersButton, logoutButton);      //sets books, customers, log out as nodes of the pane ownerBox

        VBox background = new VBox();                                                   //creates a pane called background
        background.getChildren().addAll(header, ownerBox);                              //adds header and ownerBox to background
        background.setPadding(new Insets(80, 280, 200, 150));
        background.setSpacing(80);

        oss.getChildren().addAll(background);                                           //adds background to oss group

        return oss;
    }

    public Group ownerBooksScreen() {
        Group obs = new Group();
        hb.getChildren().clear();
        booksTable.getItems().clear();
        booksTable.getColumns().clear();
        booksTable.setFocusModel(defaultFocusModel);

        Label booksLabel = new Label("Books");                                    //creates a label named booksLabel
        booksLabel.setTranslateY(25);                                             //text y coordinate

        Label addABookLabel = new Label("Add a Book ->");                         //creates a label named addABookLabel 
        addABookLabel.setTranslateX(-105);                                        //text x coordinate
        addABookLabel.setTranslateY(435);                                         //text y coordinate

        TableColumn<Book, String> titleColumn = new TableColumn<>("Book Name");     //book name coloumn label
        titleColumn.setMinWidth(200);                                               //book name coloumn width
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));    //shows BookName method from Book.java in book name coloumn in table

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Book Price");    //book price coloumn label
        priceColumn.setMinWidth(100);                                               //book price coloumn width
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));   //shows BookPrice method from Book.java in book price coloumn in table

        booksTable.setItems(addBooks());
        booksTable.getColumns().addAll(titleColumn, priceColumn);

        final TextField addBookName = new TextField();                            //textField named addBookName
        addBookName.setPromptText("Book Name");                                   //text inside textField addBookName
        addBookName.setMaxWidth(titleColumn.getPrefWidth());

        final TextField addBookPrice = new TextField();                           //textField named addBookPrice
        addBookPrice.setPromptText("Book Price");                                 //text inside textField addBookPrice
        addBookPrice.setMaxWidth(priceColumn.getPrefWidth());

        VBox core = new VBox();
        final Button addButton = new Button("Add");                               //creates button named addButton
        final Button deleteButton = new Button("Delete");                         //creates button named dleeteButton

        addButton.setOnAction(e -> {                                                                //when button named addButton is clicked
            try {
                double price = Math.round((Double.parseDouble(addBookPrice.getText())) * 100);      //creates double named price and rounds it
                BookStuff.books.add(new Book(addBookName.getText(), price / 100));              //creates book and adds it to arrayList books with the name and price
                booksTable.getItems().clear();                                                      //refresh page
                booksTable.setItems(addBooks());

                addBookName.clear();                                                                //clears textField addBookName
                addBookPrice.clear();                                                               //clears textField addBookPrice

                String bName = addBookName.getText();
                System.out.println("Adding book: " + bName);
            } catch (Exception exception) {                                                         //catch exception errors
            }
        });

        deleteButton.setOnAction(e -> {                                                 //when button naemd deleteButton is clicked
            Book selectedItem = booksTable.getSelectionModel().getSelectedItem();       //selects highlighted
            booksTable.getItems().remove(selectedItem);                                 //removes from table
            BookStuff.books.remove(selectedItem);                                   //removes from books arraylist
            System.out.println("Deleting Book: ");
        });

        hb.getChildren().addAll(addBookName, addBookPrice, addButton, deleteButton);        //adds addBookName, addBookPrice, addButton, deleteButton nodes horizontal to each other in the pane
        hb.setSpacing(3);

        HBox back = new HBox();
        back.setPadding(new Insets(5));
        back.getChildren().addAll(backButton);                                              //adds backButton node to back pane

        core.setSpacing(5);
        core.setPadding(new Insets(0, 0, 0, 150));
        core.getChildren().addAll(booksLabel, addABookLabel, booksTable, hb);               //adds booksLabel, addABookLabel, bookTable, hb node to core pane

        VBox vbox = new VBox();                                                             //creates  named vbox
        vbox.setPadding(new Insets(0, 200, 60, 0));
        vbox.getChildren().addAll(back, core);                                              //adds back and core nodes vertical to each other in the pane

        obs.getChildren().addAll(vbox);                                                     //adds vbox pane to Scene

        return obs;
    }

    public Group ownerCustomersScreen() {
        Group ocs = new Group();
        hb.getChildren().clear();
        customersTable.getItems().clear();
        customersTable.getColumns().clear();

        Label customersLabel = new Label("Customers");

        TableColumn<Customer, String> userColumn = new TableColumn<>("Customers Username");             //creates a column named userColumn with text
        userColumn.setMinWidth(160);                                                                    //sets width of column
        userColumn.setCellValueFactory(new PropertyValueFactory<>("customerUser"));                     //shows CustomerUser method from customer.java in user column in table

        TableColumn<Customer, String> passColumn = new TableColumn<>("Customers Password");             //creates a column named passCOlumn with text
        passColumn.setMinWidth(160);                                                                    //sets width of column
        passColumn.setCellValueFactory(new PropertyValueFactory<>("customerPass"));                     //shows CustomerPass method from customer.java in pass column in table

        TableColumn<Customer, Integer> pointsColumn = new TableColumn<>("Points");                      //creates a column named pointsColumn with text
        pointsColumn.setMinWidth(100);                                                                  //sets width of column
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("customerPoints"));                 //shows CustomerPoints method from customer.java in points column in table

        customersTable.setItems(addCustomers());
        customersTable.getColumns().addAll(userColumn, passColumn, pointsColumn);

        final TextField addUsername = new TextField();                                                  //creates textField named addUsername
        addUsername.setPromptText("Username");                                                          //text inside textField
        addUsername.setMaxWidth(userColumn.getPrefWidth());

        final TextField addPassword = new TextField();                                                  //creates textField named addPassword
        addPassword.setPromptText("Password");                                                          //text inside textField
        addPassword.setMaxWidth(passColumn.getPrefWidth());

        final Button addButton = new Button("Add");                                                     //creates button named addButton
        final Button deleteButton = new Button("Delete");                                               //creates button named deleteButton

        addButton.setOnAction(e -> {                                                                    //when add button is clicked
            boolean duplicate = false;
            for (Customer c : customerStuff.getCustomers()) {
                if ((c.getCustomerUser().equals(addUsername.getText()) && c.getCustomerPass().equals(addPassword.getText()))) {
                    duplicate = true;
                }
            }
            if (!(addUsername.getText().equals("") || addPassword.getText().equals("")) && !duplicate) {
                customerStuff.addCustomer(new Customer(addUsername.getText(), addPassword.getText()));  //add customer with the input username and password
                customersTable.getItems().clear();                                                      //refresh the table
                customersTable.setItems(addCustomers());

                addPassword.clear();                                                                    //clears password textField
                addUsername.clear();                                                                    //clears username textField

                System.out.println("Adding customer: ");
            }
        });

        deleteButton.setOnAction(e -> {                                                                 //when delete button is clicked
            Customer selectedItem = customersTable.getSelectionModel().getSelectedItem();
            customersTable.getItems().remove(selectedItem);                                             //remove from tableview
            customerStuff.deleteCustomer(selectedItem);                                                 //removes from arraylist
            System.out.println("Deleting customer: ");
        });

        hb.getChildren().addAll(addUsername, addPassword, addButton, deleteButton);                     //adds addUsername, addPassword, addButton, deleteButton nodes horizontal to each other to pane
        hb.setSpacing(3);

        HBox back = new HBox();                                                                         //creates HBox named back
        back.setPadding(new Insets(5));
        back.getChildren().addAll(backButton);                                                          //adds back button

        VBox core = new VBox();                                                                         //creates Vbox named core
        core.setSpacing(5);
        core.setPadding(new Insets(0, 0, 0, 110));
        core.getChildren().addAll(customersLabel, customersTable, hb);                                  //adds customersLabel, customersTable, hb nodes to pane

        VBox background = new VBox();                                                                   //creates VBox named background
        background.setPadding(new Insets(0, 150, 60, 0));
        background.getChildren().addAll(back, core);                                                    //adds back, core nodes vertical to each other in pane

        ocs.getChildren().addAll(background);                                                           //adds background to ocs screen (scene)
        return ocs;
    }

    public Group customerStartScreen(int type) {
        Group css = new Group();

        booksTable.getItems().clear();
        booksTable.getColumns().clear();
        booksTable.setFocusModel(null);

        String user = currentCustomer.getCustomerUser();                                        //string named user that gets the current customers username
        Text welcomeText = new Text("Welcome " + user + ". ");                                  //text named welcomeText

        int p = currentCustomer.getCustomerPoints();                                            //int named p that gets the current customers points
        Text pointsText = new Text("You have " + p + " points. ");                              //text named pointsText

        String s = currentCustomer.getCustomerStatus();                                         //string named s that gets the current customers status        
        Text statusText = new Text("Your status is " + s + ". ");                               //text named statusText

        HBox message = new HBox();                                                              //horizontal box named message
        message.getChildren().addAll(welcomeText, pointsText, statusText);                      //welcomeText, pointsText, statusText are nodes of message pane
        BorderPane header = new BorderPane();                                                   //border pane named header
        header.setLeft(message);                                                                //message is located left using header

        TableColumn<Book, String> titleColumn = new TableColumn<>("Book Name");                 //book name coloumn label
        titleColumn.setMinWidth(200);                                                           //book name coloumn width
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));                //shows BookName method from Book.java in book name coloumn in table

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Book Price");                //book price coloumn label
        priceColumn.setMinWidth(100);                                                           //book price coloumn width
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));               //shows BookPrice method from Book.java in book price coloumn in table

        TableColumn<Book, String> selectColumn = new TableColumn<>("Select");                   //book select coloumn label
        selectColumn.setMinWidth(80);                                                           //book select coloumn width
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));                 //shows select method from Book.java in book select coloumn in table

        booksTable.setItems(addBooks());
        booksTable.getColumns().addAll(titleColumn, priceColumn, selectColumn);                 //titleColumn, priceColumn, selectColumn set as labels to booksTable

        HBox options = new HBox();                                                              //horizontal box named
        options.setSpacing(10);
        options.getChildren().addAll(buyButton, redeemPointsAndBuyButton, logoutButton);        //buyButton, redeemPointsAndBuyBUtton, logoutButton set as nodes to options pane

        VBox background = new VBox();                                                           //VBox named background
        background.setSpacing(10);
        background.setPadding(new Insets(40, 200, 30, 100));
        background.getChildren().addAll(header, booksTable, options);                           //header, booksTable, options set as nodes to background pane

        css.getChildren().addAll(background);                                                   //background set to css screen (scene)

        return css;
    }

    public Group customerCostScreen(boolean pointsUsed) {
        Group ccs = new Group();
        //inst var for customerCostScreen
        double total = 0;
        double discountTotal;
        double totalCost;

        int pointsRecieved;
        int i = 0;
        int numOfBooks = 0;

        String[][] booksBought = new String[25][2];                                         //makes a string named booksBought of size 25x2 (up to 25 books)

        for (Book b : BookStuff.books) {
            if (b.getSelect().isSelected()) {                                               //if books are selected
                total += b.getBookPrice();                                                  //total = books price of all selected
                booksBought[i][0] = b.getBookName();                                        //book name is store in booksBought String
                booksBought[i][1] = String.valueOf(b.getBookPrice());                       //book price is stored in booksBought string
                i++;                                                                        //increment
            }
        }

        if (pointsUsed) {
            double p = currentCustomer.getCustomerPoints();                                 //100 points = $1
            if (p / 100 >= total) {                                                         //if the customer has points greater than or equal to the cost of the books, then the books are paid for by points           
                discountTotal = total;                                                      //discount total = total
                currentCustomer.setCustomerPoints(-(int) total * 100);                      //set the current customers points to subtract the number of points used ($1 = 100points), thats why it * total by 100 (look at CUstomer.java)
            } else {
                discountTotal = (p / 100);                                                  //total customer points / 100 = discount total
                currentCustomer.setCustomerPoints(-(int) p);                                //set current customers poitns to subtract number of points used (look at Customer.java)
            }
        } else {                                                                            //else if customer has less than 100 points or did not select use points
            discountTotal = 0;                                                              //no discount
        }

        totalCost = total - discountTotal;                                                  //calculate total cost
        pointsRecieved = (int) totalCost * 10;                                              //set totalCost to an int and *10, because $1 = 10points
        currentCustomer.setCustomerPoints(pointsRecieved);                                  //sets customer points to add pointsRecieved (look at Customer.java)

        VBox transaction = new VBox();                                                      //VBox named transaction
        transaction.setSpacing(7);
        Text transactionSumText = new Text("Transaction Summary: ");                        //text named transactionSumText
        Line lineOneLine = new Line(0, 150, 400, 150);                                      //Line named lineOne
        transaction.getChildren().addAll(transactionSumText, lineOneLine);                  //sets transactionSumText, lineOne as nodes to transaction pane

        VBox bookTransaction = new VBox();                                                  //VBox named bookTransaction
        bookTransaction.setSpacing(7);
        for (i = 0; i < 25; i++) {                                                          //goes through booksBought string
            if (booksBought[i][0] != null) {
                Text bookTitle = new Text(booksBought[i][0]);                               //sets text of book title from booksBought string for all books in String
                Text bookPrice = new Text(booksBought[i][1]);                               //sets text of book price from booksBouhgt string for all books in string
                BorderPane item = new BorderPane();                                         //makes borderpane named item
                item.setLeft(bookTitle);                                                    //bookTitle moved to left side
                item.setRight(bookPrice);                                                   //bookPrice moved to right side
                Line lineThreeLine = new Line(0, 150, 400, 150);                            //line named lineThreeLine   
                bookTransaction.getChildren().addAll(item, lineThreeLine);                  //sets item, lineThreeLine as nodes to bookTransaction pane
                numOfBooks++;                                                               //increment numOfBooks
            }
        }

        Text totalText = new Text("Total: \t\t\t$" + (Math.round(total * 100.0)) / 100.0);                              //total rounded to become an int
        Text discountTotalText = new Text("Discount Total: \t$" + (Math.round(discountTotal * 100.0)) / 100.0);         //discountTotal rounded to become an int
        Text totalCostText = new Text("Total Cost (TC): \t$" + (Math.round(totalCost * 100.0)) / 100.0);                //totalCost rounded to become an int
        Line lineTwoLine = new Line(0, 150, 400, 150);                                                                  //line named lineTwo
        transaction.getChildren().addAll(totalText, discountTotalText, totalCostText, lineTwoLine);                     //sets totalText, discountTOtalText, totalCostText, lineTwoLine as nodes to transaction pane

        VBox bottom = new VBox();                                                                                       //Vbox named bottom
        bottom.setSpacing(40);
        String s = currentCustomer.getCustomerStatus();                                                                 //String named s that gets current customers status
        Text checkoutMessageText = new Text(pointsRecieved + " points recieved, Status: " + s);                         //text named checkoutMessageText
        bottom.getChildren().addAll(checkoutMessageText, logoutButton);                                                 //sets checkoutMessageText, logoutButton as nodes of bottom pane

        VBox background = new VBox();                                                                                   //Vbox named background
        background.setPadding(new Insets(60, 105, 500, 100));
        background.setSpacing(10);
        background.getChildren().addAll(transaction, bottom);                                                           //sets transaction, bottom as nodes to background pane

        ccs.getChildren().addAll(background);                                                                           //adds background to ccs screen (scene)
        BookStuff.books.removeIf(b -> b.getSelect().isSelected());

        return ccs;
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("COE528 Section 9, Book Store Project, Group 44");        //tab title
        primaryStage.setResizable(false);                                               //makes the scene not resizable
        primaryStage.setScene(new Scene(loginScreen(false), 605, 550));                 //sets defult scene to the login screen
        primaryStage.show();                                                            //shows defult screen
        System.out.println("Book Store Application created by:\n\tLukas Wong (501033716)\n\tSarim Aamir (501011722)\n\tAdemola Bello (501033487)\n\tAnsugan Subramaniam (501045133)");      //prompt on screen

        try {
            bookStuff.restockArrays();
            customerStuff.restockArrays();
        } catch (IOException e) {
            System.out.println("File Importing Error");
        }

        loginButton.setOnAction(e -> {                  //when log in button is clicked
            String user = userTextField.getText();      //sets a String named user to the userText field
            String pass = passTextField.getText();      //sets a String named pass to the passText field
            boolean logged_in = false;                  //sets logged_in to false

            if ((user.equals("admin")) && (pass.equals("admin"))) {                 //if the user inputs admin in the userTExt & passText
                System.out.println("logging in as: admin.");                         //prompt on screen
                primaryStage.setScene(new Scene(ownerStartScreen(), 605, 550));     //switch to OwnerStartScreen
                logged_in = true;                                                   //then sets the boolean named logged_in to true
            }
            for (Customer c : customerStuff.getCustomers()) {
                if ((userTextField.getText().equals(c.getCustomerUser())) && (passTextField.getText().equals(c.getCustomerPass()))) {
                    currentCustomer = c;
                    primaryStage.setScene(new Scene(customerStartScreen(0), 605, 550));
                    logged_in = true;
                    System.out.println("Logging in as: " + c.getCustomerUser());
                }
            }
            if (!logged_in) {                                                       //if the user is not logged in keeps the scene as the log in screen
                primaryStage.setScene(new Scene(loginScreen(true), 605, 550));
            }
        });

        logoutButton.setOnAction(e -> {                                                     //when the log out button is clicked
            primaryStage.setScene(new Scene(loginScreen(false), 605, 550));                 //switches the scene to the log in screen
            System.out.println("log out selected: redirecting to Login-screen");            //pronmpt on screen
            userTextField.clear();                                                          //makes userText field clear
            passTextField.clear();                                                          //makes passText field clear
        });

        booksButton.setOnAction(e -> {                                                          //when the books button is clicked
            primaryStage.setScene(new Scene(ownerBooksScreen(), 605, 550));                     //switches to ownerBooksScreen
            System.out.println("Books selected: redirecting to the Owner-books-screen.");       //prompt on screen
        });

        customersButton.setOnAction(e -> {                                                          //when the customerss button is clicked
            primaryStage.setScene(new Scene(ownerCustomersScreen(), 605, 550));                     //switches to ownerCustomersScreen
            System.out.println("Books selected: redirecting to the Owner-customers-screen.");       //prompt on screen
        });

        backButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(ownerStartScreen(), 605, 550));                     //switches to ownerBooksScreen
            System.out.println("Back selected: redirecting.");                                  //prompt on screen
        });

        buyButton.setOnAction(e -> {                                                            //when buyButton is clicked
            boolean selected = false;                                                           //boolean named selected defult set to false
            for (Book b : BookStuff.books) {
                if (b.getSelect().isSelected()) {                                               //if something is selected in the checkbox set selected to true
                    selected = true;
                }
            }
            if (selected) {                                                                     //if selected = true
                primaryStage.setScene(new Scene(customerCostScreen(false), 605, 550));          //switches to customerCostScreen
                System.out.println("Buy selected: redirecting to the Customer-cost-screen.");   //prompt on screen
            } else {                                                                            //if nothing selected
                primaryStage.setScene(new Scene(customerStartScreen(1), 605, 550));             //screen stays the same
                System.out.println("No Book(s) selected.");                                      //prompt on screen
            }
        });

        redeemPointsAndBuyButton.setOnAction(e -> {                                             //when redeemPointsAndBuyButton is clicked
            boolean selected = false;                                                           //boolean named selected defult set to false                   
            for (Book b : BookStuff.books) {
                if (b.getSelect().isSelected()) {                                               //if book selected, selected set to true
                    selected = true;
                }
            }
            int p = currentCustomer.getCustomerPoints();                                        //creates int p that gets current customers points
            if (!selected) {                                                                    //if nothing selected
                primaryStage.setScene(new Scene(customerStartScreen(1), 605, 550));             //scene stays as customerStartScreen
                System.out.println("No book(s) selected.");
            } else if (p == 0) {                                                                //if customer has 0 points and click redeem points and Buy
                primaryStage.setScene(new Scene(customerStartScreen(2), 605, 550));             //scene stays as customerStartScreen
                System.out.println("No points available.");
            } else if (p != 0) {                                                                //if customer has anypoints at all
                primaryStage.setScene(new Scene(customerCostScreen(true), 605, 550));           //switches scene to customer cost screen
                System.out.println("Redeem Points and Buy selected: redirecting to the Customer-cost-screen.");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
