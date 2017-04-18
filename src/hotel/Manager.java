/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author vjs00
 */
public class Manager extends Employee{
    
    //inherits Employee public or protected methods and variables
    private String passcode;
    
    //double newPrice as one parameter, but what would the other be? roomNumber?
    //or would we not want to change individual room cost, but change the cost of 
    //all rooms of the same type?
    public void modifyRoomCost(){
        
    }
    
    /*dont know how to pass in enum type- do we even want this function?
    public void modifyRoomType(Room changeRoom, roomType changeType){
      
    }*/
}
    

