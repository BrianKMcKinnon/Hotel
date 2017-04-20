/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author Atchima
 */
public class Room {
    
    // Variables
    private final int roomNumber;
    private final double roomCost;
    public final RoomType type;
    
    /**
     * Enumerator as a description of bed size
     */
    public enum RoomType
    {
        SUITE, KING, QUEEN, SINGLE          
    }
    
    /**
     * Class constructor 
     * @param roomNumber
     * @param roomCost
     * @param type
     */
    public Room(int roomNumber, double roomCost, RoomType type)
    {
        this.roomNumber = roomNumber;
        this.roomCost = roomCost;
        this.type = type;
    }
    
    /**
     * Obtains a room number
     * @return room number
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    /**
     * Obtains a room cost
     * @return room cost
     */
    public double getCost()
    {
        return roomCost;
    }
    
    /**
     * Obtains a type of a room
     * @return type of a room
     */
    public RoomType getRoomType()
    {
        return type;
    }
    
    /**
     * Returns the roomType name
     * @return room type name
     */
    public String getRoomTypeString()
    {
        return (type.name());
    }
    
    /**
     * Obtains room type as an integer
     * @return an integer of room type
     */
    public int getRoomTypeInt()
    {
        //if(type == null)  // SHOULD default in the switch statement
            //return 3;
        //else 
        switch (type) {
            case SUITE:
                return 0;
            case KING:
                return 1;
            case QUEEN:
                return 2;
            default:
                return 3;
        }
    }
    
    /**
     * Obtains the name of room type
     * @param input
     * @return the name of room type
     */
    public static RoomType translateType(int input){
        switch(input){
            case 0 :
                return RoomType.SUITE;
            case 1 :
                return RoomType.KING;
            case 2 :
                return RoomType.QUEEN;
            case 3 :
                return RoomType.SINGLE;
            default :
                return RoomType.SUITE;
        }
    }
}