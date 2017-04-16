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
    
    //private int roomType;
    public enum roomType
    {
        SUITE, KING, QUEEN, SINGLE          // enum as a description of bed size
    }
    
    roomType type;
    
    // methods
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
    
    public void setCost(double cost)
    {
        roomCost = cost;
    }
    
    public double getCost()
    {
        return roomCost;
    }
    
    public int getRoomNumber()
    {
        return roomNumber;
    }
}