//package HotelManagementSystem; 
package Hotel;
import java.util.ArrayList;
import java.util.Calendar;
/**
	A reservation object
*/
public class Reservation
{	
	/**
		creates Reservation object, initalizes
	*/
	public Reservation(int res, int roomNum, double rate, double total, Guest g, Calendar start, Calendar end)
	{
		reservationNumber = res;
                roomNumber = roomNum;
                roomRate = rate;
                roomTotal = total;
                guest = g;
                startDate = start;
                endDate = end;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public int getReservationNumber(){
	    return reservationNumber;
	}
	public int getRoomNumber(){
            return roomNumber;
        }
        public double getRoomRate(){
            return roomRate;
        }
        public double getRoomTotal(){
            return roomTotal;
        }
        public Guest getRoomGuest(){
            return guest;
        }
        public Calendar getStartDate(){
            Calendar clone = Calendar.getInstance();
            clone = (Calendar)startDate.clone();
            return clone;   //return shallow copy of date
        }
        public Calendar getEndDate(){
            Calendar clone = Calendar.getInstance();
            clone = (Calendar)endDate.clone();
            return clone;
        }
	
	public void setAdditionalNotes(String notes) {
	    additionalNotes = notes;
	}
	
	public String getAdditionalNotes() {
	    return additionalNotes;
	}
	//lol is that all the methods we need?.....
	
	//variables- do any of these need to be public? what about the guest and room list?
	private int reservationNumber;
        private int roomNumber;
        private double roomRate;
        private double roomTotal;
	private Guest guest;
	private Room room;
	private String additionalNotes;
	//private ArrayList<Room> rooms;
	private Calendar startDate;
	private Calendar endDate;
	
}
