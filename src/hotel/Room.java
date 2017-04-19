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
    
    // variables
    private int roomNumber;
    private double roomCost;
    
    public enum roomType
    {
        SUITE, KING, QUEEN, SINGLE          // enum as a description of bed size
    }
    
    public roomType type;
    
    /**
     * Class constructor 
     */
    public Room(int num, double cost, roomType type)
    {
        // constructor
        roomNumber = num;
        roomCost = cost;
        //enumTest(room);
        this.type = type;
    }
   
    /**
     * Identifies a case for each room type
     * @param room 
     */
    public void enumTest(roomType room)
    {
        switch(room)
        {
            case SUITE:
                System.out.println("Suite room was selected.");
                break;
               
            case KING:
                System.out.println("King room was selected.");
                break;
                
            case QUEEN:
                System.out.println("Queen room was selected.");
                break;
                
            case SINGLE:
                System.out.println("Single room was selected.");
                break;
                
            default:
                System.out.println("No room was selected.");
                break;
        }
    }
    
    /**
     * Obtains a room cost
     * @return room cost
     */
    public double getCost()
    {
        return roomCost;
    }
    
    public roomType translateType(int input){
        
        switch(input){
            case 0 :
                return roomType.SUITE;
            case 1 :
                return roomType.KING;
            case 2 :
                return roomType.QUEEN;
            case 3 :
                return roomType.SINGLE;
            default :
                return roomType.SUITE;
        }
        
    }
    
    
    /**
     * Obtains a room number
     * @return room number
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    public roomType getRoomType()
    {
        return type;
    }
    
    public String getRoomTypeString()
    {
        System.out.println("room type to string");
        return (type.name());
    }
    
    public int getRoomTypeInt()
    {
        if(null == type)
            return 3;
        else switch (type) {
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
    
    
    
}