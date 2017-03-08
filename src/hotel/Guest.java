//package HotelManagementSystem;  ??? whatever you will call it
package Hotel;
/**
	Guest User
*/
public class Guest
{
	/**	
		creates Guest object
	*/
	public Guest(String aFirstName, String aLastName)
	{
		firstName = aFirstName;
                lastName = aLastName;
	}
	
	/**
		"driver function for reserving a room: checks available rooms, ensures payment is successful."
	*/
	public void reserveRoom()
	{
		
	}
	
	/**
		Refunds room payment and removes the reservation
	*/
	public void cancelReservation()
	{
		
	}
	
	/**
		??? is this actually returning the room?
	*/
	public Room getRoom()
	{
		
	}
	
	/**
		??? returns just the room number? also not sure about parameter...
	*/
	public int getRoomNumber(Room currentRoom)
	{
		//should this be a function of Room? cuz we could just call Room.getRoomNumber from here
	}
	
	//variables
	private String firstName;
	private String lastName;
	//private Room currentRoom;
	//class specification mentions a "Payment info" variable....
	
}