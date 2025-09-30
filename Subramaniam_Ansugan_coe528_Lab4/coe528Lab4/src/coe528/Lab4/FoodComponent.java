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
    public abstract class FoodComponent {
    
  
   public String getName(){
            return name;
    }
    public abstract double getPrice();
    public abstract void print(int level);
    
    protected String name;
    
    public FoodComponent(String n){
        name = n;
    }
    
}

