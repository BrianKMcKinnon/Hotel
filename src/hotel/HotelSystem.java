/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author brian
 */

public class HotelSystem 
{
    // variables
    public String hotelName;
    public int numRooms;
    public ArrayList<Employee> employees;
    public ArrayList<Manager> managers;
    public ArrayList<Guest> guests;
    private ArrayList<Room> allRooms;
    private ArrayList<Room> searchResultRooms;
    private ReservationDatabase rd;
    
    /**
     * Add java documentation
     * @param roomCount 
     */
    public HotelSystem(int roomCount){
        for(int i=0;i<roomCount;i++){
            if(i%2==0){
                //Every other room is a King room
                //King max occupancy is 2 people
                //King room rate is $100.00/night
                allRooms.add(new Room(i+1, 2, 100.00, 0));
            }
            else
                allRooms.add(new Room(i+1, 4, 125.00, 0)); // Queen room 
                
        }
        rd = new ReservationDatabase();
    }
    
    /**
     * Add java documentation
     * @param startDate
     * @param endDate
     * @return 
     */
    public ArrayList<Room> findAvailableRoom(Calendar startDate, Calendar endDate){
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = rd.queryDatabase(startDate, endDate);     //occupied rooms are returned
        for(int i=1;i<=numRooms-temp.size();i++){
            occupied=false;
            for(int j=0;j<temp.size();j++){
                if(temp.get(j).roomNumber == i){
                    occupied=true;      //if the current room number (i) is one of the room numbers held in temp, mark occupied
                }
            }
            if(!occupied){              //if current room not occupied, add to searchResultRooms
                searchResultRooms.add(temp.get(i));
            }
        }
        return searchResultRooms;
    }
    
    /**
     * Add java documentation
     * @param roomType
     * @return 
     */
    public ArrayList<Room> findAvailableRoom(Room roomType){
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = rd.queryDatabase(roomType);     //occupied rooms are returned
        for(int i=1;i<=numRooms-temp.size();i++){
            occupied=false;
            for(int j=0;j<temp.size();j++){
                if(temp.get(j).roomNumber == i){
                    occupied=true;      //if the current room number (i) is one of the room numbers held in temp, mark occupied
                }
            }
            if(!occupied){              //if current room not occupied, add to searchResultRooms
                searchResultRooms.add(temp.get(i));
            }
        }
        return searchResultRooms;
    }
    
    /**
     * Add java documentation
     * @param res
     * @return 
     */
    public Reservation lookUpReservation(int res){
        Reservation result = rd.queryDatabase(res);
        return result;
    }
    
    /**
     * Add java documentation
     * @param startDate
     * @param endDate
     * @return 
     */
    public ArrayList<Room> findOccupiedRoom(Calendar startDate, Calendar endDate){
        searchResultRooms = rd.queryDatabase(startDate, endDate, false);
        return searchResultRooms;
    }
    
    /**
     * Add java documentation
     * @param lastName
     * @return 
     */
    public ArrayList<Room> findOccupiedRoom(String lastName){
        searchResultRooms = rd.queryDatabase(lastName);
        return searchResultRooms;
    }
    
    /**
     * Add java documentation
     * @return 
     */
    public ArrayList<Room> allRooms(){
        
        return allRooms;
    }
    
    /**
     * Add java documentation
     * @param res 
     */
    public void changeReservation(Reservation res){
        rd.changeReservation(res);
    }
    
    /**
     * Add java documentation
     * @param res 
     */
    public void makeReservation(Reservation res){
        rd.makeReservation(res);
    }
    
}
