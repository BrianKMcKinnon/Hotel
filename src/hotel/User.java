/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author vjs00
 */
public class User {
     /**
     * Creates a Reservation object then adds it to database
     * @param room
     * @param guest
     * @param start
     * @param end 
     */
    public void createReservation(Room room, Guest guest, Calendar start, Calendar end)
    {
        int resNum = 0;
        double rate = 0.0;
        double total = 0.0;
        //Randomn rand;
        //resNum = rand.nextInt(99999999);
        Reservation newReservation = new Reservation(resNum, room.getRoomNumber(), rate, total, guest, start, end);
        ReservationDatabase.addReservation(newReservation);
    }
    
    /**
     * Cancels a reservation from database
     * @param reservationNumber 
     */
    public void cancelReservation(int reservationNumber){
        database.query(reservationNumber);       
        /* try {
            database.query(reservationNumber);
        }
        
        catch(Exception e)
        {
         // Display unfound reservation in GUI   
        }*/
    }
    
    /**
     * Modifies a reservation from database
     * @param reservationNumber 
     */
    public void modifyReservation(int reservationNumber){
        database.query(reservationNumber);
        /*try {
            database.query(reservationNumber);
            // Create a new reservation
            // Delete the old reservation
        }
        
        catch(Exception e)
        {
            // Display unfound reservation in GUI
        }*/
    }
}
