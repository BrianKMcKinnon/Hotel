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
    
    public int roomNumber;
    public int maxOccupancy;
    public double roomCost;
    public int roomType;
    
    
}
