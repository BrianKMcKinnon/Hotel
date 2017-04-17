/**
 * @author Victoria, Atchima
 */

package hotel;
/**
	Guest User
*/
public class Guest
{
    /**
     * Class constructor
     * @param aFirstName
     * @param aLastName 
     * Initializes first and last names
     */
    public Guest(String aFirstName, String aLastName, Room rm)
    {
            firstName = aFirstName;
            lastName = aLastName;
            room = rm;
    }

    /**
     * Reserves a room
     * It checks available rooms and ensures payment is successful
     */
    public void reserveRoom()
    {
        // do we need this in Guest?
        // checks if room is available
        // ensures payment is successful
        // reserve room
    }

    /**
     * Refunds room payment and removes reservation from the database
     */
    public void cancelReservation()
    {
        // do we need this in Guest?
        // refunds room payment
        // removes reservation from database
    }

    /**
     * Obtains a room object for a specific Guest
     * @return a room object
     */
    public Room getRoom()
    {
        return room;
    }

    // May not need this in Guest
    /*
    public int getRoomNumber(Room currentRoom)
    {
            //should this be a function of Room? cuz we could just call Room.getRoomNumber from here
    }
    */
    
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
    
    //variables
    private String firstName;
    private String lastName;
    private Room room;
    //private Room currentRoom;
    //class specification mentions a "Payment info" variable....
	
}