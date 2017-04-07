/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author brian
 */
public class Room {
    public Room(int num, int occ, double cost, int type){
        roomNumber = num;
        maxOccupancy = occ;
        roomCost = cost;
        roomType = type;
    }
    
    public void setCost(double cost)
    {
        roomCost = cost;
    }
    
    public void setRoomType(int roomTypeEnum)
    {
        roomType = roomTypeEnum;
        maxOccupancy = roomType + 1;
    }
    
    public double getCost()
    {
        return roomCost;
    }
    
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    public int getMaxOccupancy()
    {
        return maxOccupancy;
    }
    
    public String getRoomType()
    {
        if (roomType == 0)
            return "Single";
        else
            return "King";
    }
    
    public int roomNumber;
    public int maxOccupancy;
    public double roomCost;
    public int roomType;
    
    
}
