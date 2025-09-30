/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Lab4;

/**
 *
 * @author Ansugan
 */

public class FoodItem extends FoodComponent {
   
    private double price;
   
    
    public FoodItem(String name, double price){
        super(name); 
        this.price = price; 
    
    }
    
    @Override
    public double getPrice(){
        
        return price;
    }
  
    @Override
    public void print(int level){
        
        for(int i = 0; i < level ; i++){
            System.out.print("\t");
        }
        
        System.out.println("FoodItem: " + getName() + ", " + getPrice());
    }
    
}