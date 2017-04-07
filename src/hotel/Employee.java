/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author brian
 */
public class Employee {
    public Employee(){
        
    }
    
    private String userName;
    private int idNumber;
    private String passcode;
    
    private void changePasscode(){
        
    }
    private void createReservation(Room room, Guest guest, Date start, Date end){
        Randomn rand;
        resNum = rand.nextInt(99999999);
        Reservation newReservation = new Reservation(resNum, room.roomNumber, guest, start, end);
        ReservationDatabase.addReservation(newReservation);
    }
    
    private void cancelReservation(int reservationNumber){
        try {
            ReservationDatabase.query(reservationNumber);
        }
        
        catch(Exception e)
        {
         // Display unfound reservation in GUI   
        }
    }
    public void modifyReservation(){
        try {
            ReservationDatabase.query(reservationNumber);
            // Create a new reservation
            // Delete the old reservation
        }
        
        catch(Exception e)
        {
            // Display unfound reservation in GUI
        }
    }
}
