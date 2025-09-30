/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Ansugan
 */
public abstract class Passenger {
        private String name;
        int age;

         public Passenger(String name, int age){
      this.name = name;
      this.age = age;
   }

    /**
     *
     * @return
     */
    public String getName() {
      return name;
   }
 public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }


        abstract double applyDiscount(double p);
}
