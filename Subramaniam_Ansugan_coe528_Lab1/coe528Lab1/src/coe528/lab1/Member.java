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
public class Member extends Passenger {
        int yearOfMembership;

    public Member(String name, int age) {
        super(name, age);
    }

        @Override
        double applyDiscount(double p) {
                if (yearOfMembership > 5)
                        return p * 0.5;
                if (yearOfMembership > 1)
                        return p * 0.9;
                return p;
        }

}