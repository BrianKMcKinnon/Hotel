/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author brian
 */
public class ReservationDatabase {
    public ReservationDatabase(){
        //public Reservation(int res, int roomNum, Guest g, Date start, Date end)
        Calendar startDate1 = Calendar.getInstance();
        startDate1.set(2017, 5, 12);
        Calendar endDate1 = Calendar.getInstance();
        endDate1.set(2017,5,14);
        currentReservations.add(new Reservation(1,1, new Guest("Brian","McKinnon"), startDate1, endDate1));
        
        Calendar startDate2 = Calendar.getInstance();
        startDate2.set(2017, 6, 1);
        Calendar endDate2 = Calendar.getInstance();
        endDate2.set(2017,6,2);
        currentReservations.add(new Reservation(2,2, new Guest("Atchima","Klomkaew"), startDate2, endDate2));
        
        Calendar startDate3 = Calendar.getInstance();
        startDate3.set(2017, 5, 11);
        Calendar endDate3 = Calendar.getInstance();
        endDate3.set(2017,5,15);
        currentReservations.add(new Reservation(3,3, new Guest("Victoria","Shouse"), startDate3, endDate3));
        
        Calendar startDate4 = Calendar.getInstance();
        startDate4.set(2017, 6, 11);
        Calendar endDate4 = Calendar.getInstance();
        endDate4.set(2017,6,15);
        currentReservations.add(new Reservation(3,3, new Guest("Chandler","Davidson"), startDate4, endDate4));
    }
    private ArrayList<Reservation> currentReservations;
    public ArrayList<Room> queryDatabase(Calendar start, Calendar end, boolean available){
        ArrayList<Room> takenRooms = null;
        for(int i=0; i<currentReservations.size(); i++){
            if((currentReservations.get(i).getEndDate().before(start)) || (currentReservations.get(i).getStartDate().after(end))){
                //good
            }
            else{
                takenRooms.add(new Room(currentReservations.get(i).getRoomNumber(),0,0.0,0)); // Adds a room with the unavailable room number
            }
        }
        return takenRooms;
    }
    
}
