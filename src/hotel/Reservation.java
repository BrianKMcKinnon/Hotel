/**
 *
 * @author Atchima
 */

package hotel;
import static java.sql.Types.NULL;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Reservation {
    
    //variables- do any of these need to be public? what about the guest and room list?
    private HotelSystem system;
    private String reservationNumber;
    private String firstName;
    private String lastName;
    private int roomNumber;
    private double roomRate;
    private double roomTotal;
    private Room room;
    private String additionalNotes;
    //private ArrayList<Room> rooms;
    private Calendar startDate;
    private Calendar endDate;
    private Room.roomType type;
    
    /**
     * Class constructor 
     */
    public Reservation(String res, int roomNum, double rate, double total, String first, String last, Calendar start, Calendar end, Room.roomType roomtype)
    {
            reservationNumber = res;
            roomNumber = roomNum;
            roomRate = rate;
            roomTotal = total;
            firstName = first;
            lastName = last;
            startDate = start;
            endDate = end;
            type = roomtype;
    }
    
    public Reservation(HotelSystem hs, String res, int roomNum, double rate, double total, String first, String last, Calendar start, Calendar end, Room.roomType roomtype)
    {
            system = hs;
            reservationNumber = res;
            roomNumber = roomNum;
            roomRate = rate;
            roomTotal = total;
            firstName = first;
            lastName = last;
            startDate = start;
            endDate = end;
            type = roomtype;
    }
    
    /**
     * Obtains reservation number by calling generatesRandom() for a random number
     * @return a reservation number
     */
    public String getReservationNumber()
    {   
        return reservationNumber;
    }
    
    /*public void setReservationNumber()
    {
        long resNum = 0;
        reservationNumber = generateRandom();
        //resNum = Integer.toString(reservationNumber);
        // ensure the number is not taken
        Reservation temp = system.lookUpReservation(reservationNumber);
        
        while((temp) != null)
        {
            // returns null if available, so not null if not free
            reservationNumber = generateRandom();
            temp = system.lookUpReservation(reservationNumber);

        }
    }*/
    
    public void setReservationNumber() {
        long resNum = 0;
        reservationNumber = generateRandom();
        while(system.reservationExist(reservationNumber))
        {
            reservationNumber = generateRandom();
        }
    }
    
    public int getDurationOfStay()
    {
        return (int) ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
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
    public String getRoomTypeString(){
        return type.name();
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
