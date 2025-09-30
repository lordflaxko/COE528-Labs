/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab4;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

/**
 *
 * @author Ansugan
 */
public class Record {     
    // Name of the associated file     
    private String filename;
    private static final Record instance = new Record("record.txt");
    private Record(String n) {         
        filename = n;     
    }          
    
    public static Record getInstance()
    {
    return instance;
    }
    
    
    // Effects: Reads and prints the contents of the associated      
    // file to the standard output.       
    public void read() {         
        try {             
            Scanner scan = new Scanner(new File(filename));
            String s = "";
            while(scan.hasNext()) {
                s += scan.nextLine()+ "\n";
            }
            System.out.println(s);

        } catch (IOException e) {             
            System.out.println("An error occurred.");             
            e.printStackTrace();         
        }     
    }       
 
    // Effects: Appends the specified message, msg, to the      
    // associated file.     
    public void write(String msg) {         
        try {             
            FileWriter f = new FileWriter(filename,true);
            f.write(msg);
            f.close();
            
        } catch (IOException e) {             
            System.out.println("An error occurred.");
            e.printStackTrace();  
        }                          
    }
    
 
    public static void main(String[] args) {         
        // Fill the blank below that obtains the sole instance          
        // of the Record class.          
        // (You should not invoke the Record constructor here.) 
        Record r = Record.getInstance();          
        // Do not modify the code below         
        r.write("Hello-1\n");         
        r.write("Hello-2\n");                  
        System.out.println("Currently the file record.txt " + "contains the following lines:");         
        r.read();     
    } 
}

