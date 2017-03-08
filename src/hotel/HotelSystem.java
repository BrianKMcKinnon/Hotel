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
public class HotelSystem {
    public HotelSystem(int roomCount){
        for(int i=0;i<roomCount;i++){
            if(i%2==0){
                //Every other room is a King room
                //King max occupancy is 2 people
                //King room rate is $100.00/night
                allRooms.add(new Room(i+1, 2, 100.00, 0));
            }
            else
                allRooms.add(new Room(i+1, 4, 125.00, 0));
                
        }
    }
    
    public String hotelName;
    public int numRooms;
    public ArrayList<Employee> employees;
    public ArrayList<Manager> managers;
    public ArrayList<Guest> guests;
    private ArrayList<Room> allRooms;
    private ArrayList<Room> searchResultRooms;
    
    public ArrayList<Room> findAvailableRoom(int roomNum){
        searchResultRooms = ReservationDatabase.queryDatabase(roomNum, true);
        return searchResultRooms;
    }
    public ArrayList<Room> findAvailableRoom(Calendar startDate, Calendar endDate){
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = ReservationDatabase.queryDatabase(startDate, endDate, true);     //occupied rooms are returned
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
    public ArrayList<Room> findAvailableRoom(int minOccupancy, int maxOccupancy){
        searchResultRooms = ReservationDatabase.queryDatabase(minOccupancy, maxOccupancy, true);
        return searchResultRooms;
    }
    public ArrayList<Room> findAvailableRoom(Room roomType){
        searchResultRooms = ReservationDatabase.queryDatabase(roomType, true);
        return searchResultRooms;
    }
    public ArrayList<Room> findOccupiedRoom(Calendar startDate, Calendar endDate){
        searchResultRooms = ReservationDatabase.queryDatabase(startDate, endDate, false);
        return searchResultRooms;
    }
    public ArrayList<Room> findOccupiedRoom(String lastName){
        searchResultRooms = ReservationDatabase.queryDatabase(lastName);
        return searchResultRooms;
    }
    public ArrayList<Room> allRooms(){
        
        return allRooms;
    }
    
    
}
