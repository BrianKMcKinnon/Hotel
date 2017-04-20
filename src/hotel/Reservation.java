/**
 *
 * @author Atchima
 */

package hotel;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Random;

public class Reservation {
    
    // Variables 
    private HotelSystem hotelSystem;
    private final String reservationCode;
    private final Room room;
    private final Calendar startDate;
    private final Calendar endDate;
    private String firstName;
    private String lastName;
    
    /**
     * Class constructor
     * @param room
     * @param startDate
     * @param endDate
     * @param firstName
     * @param lastName
     */
    public Reservation(Room room, Calendar startDate, Calendar endDate, String firstName, String lastName)
    {
        reservationCode = generateReservationCode();
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Reservation(String string, int aInt, double aDouble, double aDouble0, String string0, String string1, Calendar startDate, Calendar endDate, Room.RoomType valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Obtains reservation number
     * @return a reservation number
     */
    public String getReservationCode()
    {   
        return reservationCode;
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
     * Obtains the duration of stay, which is end - start date
     * @return duration of stay
     */
    public int getDurationOfStay()
    {
        return (int) ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
    }
    
    
    /**
     * Obtains first name
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Obtains last name
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }
    
    public void setName(String fName, String lName)
    {
        firstName = fName;
        lastName = lName;
    }
    
    /**
     * Obtains the total cost of the reservation
     * @return total room
     */
    public double getReservationTotal()
    {
        return getDurationOfStay() * room.getCost();
    }
    
    
    /**
     * Generates a random numeric string of a desired length
     * @return a random generated number of a reservation number
     */
    private String generateRandom()
    {
        int length = 8;
        
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for(int i = 1; i < length; i++)
            digits[i] = (char)(random.nextInt(1) + '0');

        return String.valueOf(digits);
    }
    
    /**
     * Sets reservation code by calling generatesRandom() for a random number
     */
    private String generateReservationCode() {
        String resCode = generateRandom();
        
        while(hotelSystem.reservationExist(resCode))
            resCode = generateRandom();
        return resCode;
    }

}
