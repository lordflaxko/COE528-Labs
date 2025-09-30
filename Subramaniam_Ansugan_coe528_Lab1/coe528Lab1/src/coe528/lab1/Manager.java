/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;
import java.util.Scanner;

/**
 *
 * @author Ansugan
 */
public class Manager {
        Flight flights[] = new Flight[100];
        Ticket tickets[] = new Ticket[100];

        public void createFlights() {
            try (Scanner sc = new Scanner(System.in)) {
                for (int a = 0; a < 100; a++) {
                    System.out.println("Enter the following information in order - Flight Number, Origin, Destination, Seat Number, Price  :  " + (a + 1) + ": ");
                    flights[a] = new Flight(sc.nextInt(), sc.nextLine(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                }
            }
        }

        public void displayAvailableFlights(String origin, String destination) {
                for (int a = 0; a < 100; a++) {
                        if (flights[a].getOrigin().equals(origin) && flights[a].getDestination().equals(destination)) {
                                System.out.println(flights[a].toString());
                        }
                }
        }

        public Flight getFlight(int flightNumber) {
                for (int a = 0; a < 100; a++) {
                        if (flights[a].getFlightNumber() == flightNumber)
                                return flights[a];
                }
                return null;
        }

        public void bookSeat(int flightNumber, Passenger p) {
                for (int a = 0; a < 100; a++) {
                        if (flights[a].getFlightNumber() == flightNumber) {
                                if (flights[a].bookSeat()) {
                                        p.applyDiscount(flights[a].getOriginalPrice());
                                }
                        }
                }
        }
        public static void main(String[] args) {
                Manager m =new Manager();
                String origin ="";
                String destination ="";
                int flightNumber =0;
                m.createFlights();
                m.displayAvailableFlights(origin, destination);
                m.getFlight(flightNumber);
        }
}