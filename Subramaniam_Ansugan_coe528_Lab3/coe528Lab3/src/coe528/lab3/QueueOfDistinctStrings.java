/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab3;
import java.util.ArrayList; 
/**
 *
 * @author Ansugan
 */
public class QueueOfDistinctStrings {
   

 // a) The abstraction function is:
 // 
 //     d is a QueueOfDistinctStrings object.  
 //     q.list is the array list of string elements
 //     d.list(i) is the distinct string element, i is for the q.list with a size [1..n]
 //     d.list(0) is the front of the list
 //     d.list((d.list.size()-1)) is the end of the list
 //
 // b) The rep invariant is:
 // 
 //              q.list(i) == will return null false
 //              q.list(i) != will <String> return false 
 //              q.list(i) contains duplicate elements, it will return false 


// the rep

    private final ArrayList<String> items;
    
    //constructor

    public QueueOfDistinctStrings() {
        items = new ArrayList<>();
    }

    //MODIFIES: this
//EFFECTS: Appends the element at the end of the queue
//          if the element is not in the queue, otherwise
//          does nothing.

    public void enqueue(String element) throws Exception {
        if (element == null)
            throw new Exception();

        if (false == items.contains(element))
            items.add(element);
    }

    public String dequeue() throws Exception {
          //MODIFIES: this
    //EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0)
            throw new Exception();
        return (items.remove(0));
    }

   public boolean repOK() throws Exception {
       //Effects: Returns true if the rep invariant holds for this
    //          object; otherwise returns false
        if(items.isEmpty()) {
    return false;
    }
    else{
    for(int a = 0;a<items.size();a++){
        for(int b = 0; b < items.size() ; b++){
            return items.get(b) != items.get(a);
        }
    }   
   }
  return false;  
}

     @Override
    public String toString() {
      // EFFECTS: Returns a strin that contains the zdtrings in the 
//          queue, the front element and the end element.
//          implements the abstraction function.
String s, c = null;
    s = "Here " + items.size() + " the items are {";
    for(int i = 0; i < items.size() ; i++) 
    {c = " " + c + items.get(i) + ",";}

    return s + c + "}/n" + "Front: " + items.get(0)+ " /nEnd: " + items.get(items.size());
}

}