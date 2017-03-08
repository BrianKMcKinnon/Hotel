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
	public Reservation(int res, int roomNum, Guest g, Calendar start, Calendar end)
	{
		reservationNumber = res;
                roomNumber = roomNum;
                guest = g;
                startDate = start;
                endDate = end;
	}
	
	/**
		returns reservation number
	*/
	public int getReservationNumber()
	{
		//ok this returns an int but we've got reservationNumber as a String
		//so do whatever you think is best I guess...
	}
	public int getRoomNumber(){
            
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
	//lol is that all the methods we need?.....
	
	//variables- do any of these need to be public? what about the guest and room list?
	private int reservationNumber;
        private int roomNumber;
	private Guest guest;
	//private ArrayList<Room> rooms;
	private Calendar startDate;
	private Calendar endDate;
	
}