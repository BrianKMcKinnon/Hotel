/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Calendar;

/**
 *
 * @author Brian, Atchima
 */
public class Employee 
{
    // variables
    //think these should be protected so Manager can inherit
    protected String userName;
    protected int idNumber;
    //private String passcode;      // I dont think we need passcode for employee, but we do for manager
    protected Room room;
    protected ReservationDatabase database;
    
    /**
     * Class constructor
     */
    public Employee(String name, int id, Room rm){
        userName = name;
        idNumber = id;
        room = rm;
    }
    
    //private void changePasscode(){
        // change passcode may not be needed for employee, but it is for manager
    //}
    
    
    ////////////////////////////////////////////////////////////////////////////////////
    //moving this to User, which Employee extends, then Manager extends Employee
    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * Creates a Reservation object then adds it to database
     * @param room
     * @param guest
     * @param start
     * @param end 
     */
    /*public void createReservation(Room room, Guest guest, Calendar start, Calendar end)
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
    /*public void cancelReservation(int reservationNumber){
        database.query(reservationNumber);       
        /* try {
            database.query(reservationNumber);
        }
        
        catch(Exception e)
        {
         // Display unfound reservation in GUI   
        }*/
   // }
    
    /**
     * Modifies a reservation from database
     * @param reservationNumber 
     */
   /* public void modifyReservation(int reservationNumber){
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
    //}
}
