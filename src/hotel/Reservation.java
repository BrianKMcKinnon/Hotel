/**
 *
 * @author Atchima
 */

package Hotel;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Reservation {
    
    //variables- do any of these need to be public? what about the guest and room list?
    private HotelSystem system;
    private String reservationNumber;
    private int roomNumber;
    private double roomRate;
    private double roomTotal;
    private Guest guest;
    private Room room;
    private String additionalNotes;
    //private ArrayList<Room> rooms;
    private Calendar startDate;
    private Calendar endDate;
    
    /**
     * Class constructor 
     */
    public Reservation(int res, int roomNum, double rate, double total, Guest g, Calendar start, Calendar end)
    {
            reservationNumber = Long.toString(res);
            roomNumber = roomNum;
            roomRate = rate;
            roomTotal = total;
            guest = g;
            startDate = start;
            endDate = end;
    }
    
    /**
     * 
     * @return a reservation number
     * calls generateRandom() for a random number
     */
    public String getReservationNumber()
    {
        reservationNumber = generateRandom();
        // ensure the number is not taken
        while((system.lookUpReservation(reservationNumber)) != NULL)
        {
            // returns null if available, so not null if not free
            reservationNumber = generateRandom();
        }
        return reservationNumber;
    }
    
    /**
     * 
     * @return a random generated number of a reservation number
     * generate a random number with length = 12
     */
    public String generateRandom()
    {
        int length = 12;
        
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for(int i = 1; i < length; i++)
        {
            digits[i] = (char)(random.nextInt(1) + '0');
        }
        
        // makeReservation();
        
        return String.valueOf(digits);
    }
    
    /**
     * 
     * @return room object for the specific reservation number
     */
    public Room getRoom()
    {
        return room;
    }
    
    /**
     * 
     * @return room rate for pricing
     */
    public double getRoomRate()
    {
        return roomRate;
    }
    
    /**
     * 
     * @return total of room(s) in a specific reservation
     */
    public double getRoomTotal()
    {
        return roomTotal;
    }
    
    /**
     * 
     * @return guest object for a specific reservation
     */
    public Guest getRoomGuest()
    {
        return guest;
    }
    
    /**
     * 
     * @return a room number
     * obtain a room number of the specific reservation number
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    /**
     * 
     * @return a start date
     * obtain a start date of the specific reservation number
     */
    public Calendar getStartDate()
    {
        Calendar clone = Calendar.getInstance();
        clone = (Calendar)startDate.clone();
        return clone;   //return shallow copy of date
    }
    
    /**
     * 
     * @return an ending date
     * obtain an end date of the specific reservation number
     */
    public Calendar getEndDate()
    {
        Calendar clone = Calendar.getInstance();
        clone = (Calendar)endDate.clone();
        return clone;
    }
    
    /**
     * 
     * @param notes 
     * sets additional notes taken from a customer
     */
    public void setAdditionalNotes(String notes) 
    {
	    additionalNotes = notes;
    }
	
    /**
     * 
     * @return any additional notes taken from a customer
     */
    public String getAdditionalNotes() 
    {
        return additionalNotes;
    }

}
