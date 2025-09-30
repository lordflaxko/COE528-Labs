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
public class FlightTest {
    //@Test

    /**
     *
     */
      public void testConstructor(){
         Flight flight;
          flight = new Flight(1,"Toronto","Kolkata","7 pm",300,100);
         assertEquals("Toronto", flight.getOrigin());
         assertEquals("Kolkata", flight.getDestination());
         assertEquals("7 pm", flight.getDepartureTime());
         assertEquals(300, flight.getCapacity());
         assertEquals(300, flight.getNumberOfSeatsLeft());
         assertEquals(100, flight.getOriginalPrice());
         flight.bookASeat();
         assertEquals(299, flight.getNumberOfSeatsLeft());
      }

      //@Test
      public void testInvalidConstructor(){
         Flight flight;
          flight = new Flight(1,"Toronto","Toronto","7 pm",300,100);
         assertEquals("Toronto", flight.getOrigin());
         assertEquals("Kolkata", flight.getDestination());
         assertEquals("7 pm", flight.getDepartureTime());
         assertEquals(300, flight.getCapacity());
         assertEquals(300, flight.getNumberOfSeatsLeft());
         assertEquals(100, flight.getOriginalPrice());
         flight.bookASeat();
         assertEquals(299, flight.getNumberOfSeatsLeft());
      }

    private void assertEquals(String Toronto, String origin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertEquals(int i, int capacity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertEquals(int i, double originalPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }
