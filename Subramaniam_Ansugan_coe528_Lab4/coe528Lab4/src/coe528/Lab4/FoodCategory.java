/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.Lab4;
import java.util.ArrayList;

/**
 *
 * @author Ansugan
 */
public class FoodCategory extends FoodComponent {
    
    private ArrayList<FoodComponent> FoodComp = new ArrayList<FoodComponent>();
      public FoodCategory(String name) {
                super(name);
                
        }
        public void add(FoodComponent comp) {
                FoodComp.add(comp);
        }
       
        public double getPrice() {
                double sum =0; 
                for(FoodComponent f : FoodComp) { 
                        sum+=f.getPrice();
                }
                return sum;
        }
        public void print(int level){
        for(int i = 0; i < level ; i++){
            System.out.print("\t");
        }
        
        System.out.println("FoodCategory: (" + name + ", " + getPrice() + ") contains: ");
        
        for(FoodComponent f : FoodComp){
            f.print(level + 1);
        }
    }
  
}