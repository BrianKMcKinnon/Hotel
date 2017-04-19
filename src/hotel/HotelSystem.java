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
    private ArrayList<Room> allRooms;
    private ArrayList<Room> searchResultRooms;
    private ArrayList<Reservation> searchResultReservations;
    private ReservationDatabase rd;
    
    /**
     * Add java documentation
     * @param roomCount 
     */
    public HotelSystem(int roomCount){
        allRooms = new ArrayList<Room>();
        searchResultRooms = new ArrayList<Room>();
        searchResultReservations = new ArrayList<Reservation>();
        for(int i=0;i<roomCount;i++){
            if(i%4==0){
                allRooms.add(new Room(i+1, 300.00, Room.roomType.SUITE));
            }
            else if(i%4==1){
                allRooms.add(new Room(i+1, 200.00, Room.roomType.KING));
            }
            else if(i%4==2){
                allRooms.add(new Room(i+1, 150.00, Room.roomType.QUEEN)); 
            }
            else{
                allRooms.add(new Room(i+1, 100.00, Room.roomType.SINGLE));
            }
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
        System.out.println("Entered findAvailableRoom (Calendar, Calendar)");
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = rd.queryDatabase(startDate, endDate);     //occupied rooms are returned
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
    
    public ArrayList<Room> findAvailableRoom(Calendar startDate, Calendar endDate, Room.roomType roomtype){
        searchResultRooms.clear();
        ArrayList<Room> temp = null;
        boolean occupied=false;
        temp = rd.queryDatabase(startDate, endDate, roomtype);     //occupied rooms are returned
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
     * Add java documentation
     * @param res
     * @return 
     */
    public Reservation lookUpReservation(String res){
        Reservation result = rd.queryDatabase(res);
        return result;
    }
    
    /**
     * Add java documentation
     * @param startDate
     * @param endDate
     * @return 
     */
    public ArrayList<Reservation> findOccupiedRoom(Calendar startDate, Calendar endDate){
        searchResultReservations = rd.findReservations(startDate, endDate);
        return searchResultReservations;
    }
    
    /**
     * Add java documentation
     * @param firstName
     * @param lastName
     * @return 
     */
    public ArrayList<Reservation> findOccupiedRoom(String firstName,String lastName){
        searchResultReservations.clear();
        searchResultReservations = rd.queryDatabase(firstName,lastName);
        return searchResultReservations;
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
