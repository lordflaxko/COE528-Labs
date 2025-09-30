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
public class Ticket {
       private Passenger passenger;
       private Flight flight;
       private double price;
       private int id;
       private static int num = 0;

        public Ticket(Passenger passenger, Flight flight, double price) {
                this.passenger = passenger;
                this.flight = flight;
                this.price = price;
                this.id = num;
                num++;
        }

        public Passenger getPassenger() {
                return passenger;
        }

        public void setPassenger(Passenger passenger) {
                this.passenger = passenger;
        }

        public Flight getFlight() {
                return flight;
        }

        public void setFlight(Flight flight) {
                this.flight = flight;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

       @Override
        public String toString() {
                return passenger.getName() + ", " + flight.toString() + ", ticket price: " + price + "$";
        }
}