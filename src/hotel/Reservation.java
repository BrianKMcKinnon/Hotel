/**
 *
 * @author Atchima
 */

package hotel;
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
     * Obtains reservation number by calling generatesRandom() for a random number
     * @return a reservation number
     */
    public String getReservationNumber()
    {
        long resNum = 0;
        reservationNumber = generateRandom();
        //resNum = Long.parseLong(reservationNumber);
        
        // ensure the number is not taken
        while((system.lookUpReservation(reservationNumber)) != NULL)
        {
            // returns null if available, so not null if not free
            reservationNumber = generateRandom();
        }
        return reservationNumber;
    }
    
    /**
     * Generates a random number with length = 12
     * @return a random generated number of a reservation number
     */
    public String generateRandom()
    {
        int length = 8;
        
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
     * Obtains a room object for the specific reservation number
     * @return a room object
     */
    public Room getRoom()
    {
        return room;
    }
    
    /**
     * Obtains a rate for the specific room of the reservation number
     * @return room rate for pricing
     */
    public double getRoomRate()
    {
        return roomRate;
        // associate with room somehow? other than getting info from initialization? or nah?
    }
    
    /**
     * Obtains the total number of rooms in a specific reservation
     * @return total room
     */
    public double getRoomTotal()
    {
        return roomTotal;
    }
    
    /**
     * Obtains the guest object for a specific reservation
     * @return a guest object
     */
    public Guest getRoomGuest()
    {
        return guest;
    }
    
    /**
     * Obtains a room number of the specific reservation number
     * @return a room number
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    /**
     * Obtains a start date of the specific reservation number
     * @return a start date
     */
    public Calendar getStartDate()
    {
        Calendar clone = Calendar.getInstance();
        clone = (Calendar)startDate.clone();
        return clone;   //return shallow copy of date
    }
    
    /**
     * Obtains an end date of the specific reservation number
     * @return an ending date
     */
    public Calendar getEndDate()
    {
        Calendar clone = Calendar.getInstance();
        clone = (Calendar)endDate.clone();
        return clone;
    }
    
    /**
     * Sets additional notes taken from a customer
     * @param notes 
     */
    public void setAdditionalNotes(String notes) 
    {
	    additionalNotes = notes;
    }
	
    /**
     * Obtains any additional notes from a customer
     * @return any additional notes
     */
    public String getAdditionalNotes() 
    {
        return additionalNotes;
    }

}
