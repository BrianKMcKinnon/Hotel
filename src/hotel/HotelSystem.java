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
    // Variables
    public String hotelName;
    public int numRooms;
    private final ArrayList<Room> allRooms;
    private ArrayList<Room> searchResultRooms;
    private ArrayList<Reservation> searchResultReservations;
    private final ReservationDatabase reservationDatabase;
    private static HotelSystem instance = null;     // Actually implement Singleton design pattern
    
    
    /**
     * Builds the appropriate ArrayLists
     * @param roomCount 
     */
    protected HotelSystem(int roomCount){
        allRooms = new ArrayList<>();
        searchResultRooms = new ArrayList<>();
        searchResultReservations = new ArrayList<>();
        for(int i=0;i<roomCount;i++){
            if(i%4==0){
                allRooms.add(new Room(i+1, 300.00, Room.RoomType.SUITE));
            }
            else if(i%4==1){
                allRooms.add(new Room(i+1, 200.00, Room.RoomType.KING));
            }
            else if(i%4==2){
                allRooms.add(new Room(i+1, 150.00, Room.RoomType.QUEEN)); 
            }
            else{
                allRooms.add(new Room(i+1, 100.00, Room.RoomType.SINGLE));
            }
        }
        reservationDatabase = new ReservationDatabase();
    }
    
    /**
     * Necessary to implement Singleton design pattern
     * @param roomCount
     * @return instance of HotelSysetm
     */
    
    public static HotelSystem getInstance(int roomCount) {
        if (instance == null)
            instance = new HotelSystem(roomCount);
        
        return instance;
    }
    
    /**
     * Returns a list of the available rooms within the given date range
     * @param startDate
     * @param endDate
     * @return ArrayList of Room
     */
    public ArrayList<Room> findAvailableRoom(Calendar startDate, Calendar endDate){
        System.out.println("Entered findAvailableRoom (Calendar, Calendar)");
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = reservationDatabase.queryDatabase(startDate, endDate);     //occupied rooms are returned
        if(temp != null){
            for(int i=1;i<=numRooms-temp.size();i++){
                occupied=false;
                for(int j=0;j<temp.size();j++){
                    if(temp.get(j).getRoomNumber() == i){
                        occupied=true;      //if the current room number (i) is one of the room numbers held in temp, mark occupied
                    }
                }
                if(!occupied){              //if current room not occupied, add to searchResultRooms
                    searchResultRooms.add(temp.get(i));
                }
            }
        }
        else{
            searchResultRooms = (ArrayList<Room>) allRooms.clone();
        }
        return searchResultRooms;
    }
    
    /**
     * Returns a list of the available rooms within the given date range and of the room type
     * @param startDate
     * @param endDate
     * @return ArrayList of Room
     */
    public ArrayList<Room> findAvailableRoom(Calendar startDate, Calendar endDate, Room.RoomType roomtype){
        searchResultRooms.clear();
        ArrayList<Room> tempResults = new ArrayList<Room>();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        System.out.println(roomtype.toString());
        temp = reservationDatabase.queryDatabase(startDate, endDate, roomtype);     //occupied rooms are returned
        if(temp != null){
            for(int i=0;i<numRooms-temp.size();i++){
                occupied=false;
                for(int j=0;j<temp.size();j++){
                    if(temp.get(j).getRoomNumber() == i){
                        occupied=true;      //if the current room number (i) is one of the room numbers held in temp, mark occupied
                    }
                }
                if(!occupied){              //if current room not occupied, add to searchResultRooms
                   
                    tempResults.add(temp.get(i));
                }
            }
        }
        else{
            tempResults = (ArrayList<Room>) allRooms.clone();
        }
        for(int i=0;i<tempResults.size();i++){
            if(tempResults.get(i).getRoomType() == roomtype)
                searchResultRooms.add(tempResults.get(i));
        }
        return searchResultRooms;
    }
    
    /**
     * Returns a list of the available rooms of the room type
     * @param roomType
     * @return ArrayList of Room
     */
    public ArrayList<Room> findAvailableRoom(Room roomType){
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = reservationDatabase.queryDatabase(roomType);     //occupied rooms are returned
        for(int i=1;i<=numRooms-temp.size();i++){
            occupied=false;
            for(int j=0;j<temp.size();j++){
                if(temp.get(j).getRoomNumber() == i){
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
     * Returns the found reservation
     * @param res
     * @return Reservation
     */
    public Reservation lookUpReservation(String res){
        Reservation result = reservationDatabase.queryDatabase(res);
        return result;
    }
    
    /**
     * Returns true if the reservation code exists
     * @param res
     * @return Boolean
     */
    public boolean reservationExist(String res) {
        Reservation result = reservationDatabase.queryDatabase(res);
        return (result != null);
    }
    
    /**
     * Searches for reservations that matches the start and end date
     * @param startDate
     * @param endDate
     * @return ArrayList of reservation objects
     */
    public ArrayList<Reservation> findOccupiedRoom(Calendar startDate, Calendar endDate){
        searchResultReservations = reservationDatabase.findReservations(startDate, endDate);
        return searchResultReservations;
    }
    
    /**
     * Searches for reservations that matches the first and last name of guest
     * @param firstName
     * @param lastName
     * @return Arraylist of reservation objects
     */
    public ArrayList<Reservation> findOccupiedRoom(String firstName, String lastName){
        searchResultReservations.clear();
        searchResultReservations = reservationDatabase.queryDatabase(firstName,lastName);
        return searchResultReservations;
    }
    
    /**
     * Returns all the room
     * @return Arraylist of room objects
     */
    public ArrayList<Room> allRooms(){
        
        return allRooms;
    }
    
    /**
     * Modifies a reservation
     * @param res 
     */
    public void changeReservation(Reservation res){
        reservationDatabase.changeReservation(res);
    }
    
    /**
     * Makes a reservation
     * @param res 
     */
    public void makeReservation(Reservation res){
        reservationDatabase.makeReservation(res);
    }
    
    /**
     * Removes a reservation
     * @param res 
     */
    public void removeReservation(Reservation res) {
        reservationDatabase.deleteReservation(res.getReservationCode());
    }
    
}
