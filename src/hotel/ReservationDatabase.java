/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.sql.*;
import java.text.SimpleDateFormat;

//import static java.sql.JDBCType.NULL;
/**
 *
 * @author brian
 */

public class ReservationDatabase 
{
    
    // variables
    private ArrayList<Reservation> currentReservations;
    private Connection con = null;
    
    /**
     * Class Constructor
     * Add java documentation
     */
    public ReservationDatabase(){

        System.out.println("Entering ReservationDatabase constructor");
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Reservations");
           
        }catch(Exception e){
            System.out.println("Error opening connections: " + e);
            e.printStackTrace();
        }
    }
    
    /**
     * Add java documentation
     * @param start
     * @param end
     * @return 
     */
    public ArrayList<Room> queryDatabase(Calendar start, Calendar end){
        System.out.println("Entered queryDatabase (Calendar, Calendar)");
        ResultSet rs = null;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startQuery = format1.format(start.getTime());
        String endQuery = format1.format(end.getTime());
        String query = "SELECT * FROM RESERVATIONS WHERE (STARTDATE BETWEEN '" + startQuery + "' AND '" + endQuery + 
                       "') OR (ENDDATE BETWEEN '" + startQuery + "' AND '" + endQuery + "')";
        ArrayList<Room> takenRooms = null;
        if(con != null){
            try{
                Statement stmt= con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next())
                    takenRooms.add(new Room(rs.getInt(4), 0, Room.roomType.KING));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return takenRooms;
    }
    
    public ArrayList<Reservation> findReservations(Calendar startStay, Calendar endStay){
        currentReservations.clear();
        ResultSet rs = null;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startQuery = format1.format(startStay.getTime());
        String endQuery = format1.format(endStay.getTime());
        String query = "SELECT * FROM RESERVATIONS WHERE (STARTDATE BETWEEN '" + startQuery + "' AND '" + endQuery + 
                       "') OR (ENDDATE BETWEEN '" + startQuery + "' AND '" + endQuery + "')";
        ArrayList<Room> takenRooms = null;
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(2).split(delims);
                    String[] end = rs.getString(3).split(delims);
                    int startYear = Integer.parseInt(start[0]);
                    int startMonth = Integer.parseInt(start[1]) - 1;
                    int startDay = Integer.parseInt(start[2]);
                    int endYear = Integer.parseInt(end[0]);
                    int endMonth = Integer.parseInt(end[1]) - 1;
                    int endDay = Integer.parseInt(end[2]);
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(startYear, startMonth, startDay);
                    Calendar endDate = Calendar.getInstance();
                    endDate.set(endYear, endMonth, endDay);
                    currentReservations.add(new Reservation(rs.getString(1), 
                                                            rs.getInt(4), 
                                                            rs.getDouble(5), 
                                                            rs.getDouble(6),
                                                            rs.getString(7), 
                                                            rs.getString(8),
                                                            startDate,
                                                            endDate,
                                                            Room.roomType.valueOf(rs.getString(9))));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return currentReservations;
    }
    
    public ArrayList<Room> queryDatabase(Calendar start, Calendar end, Room.roomType room){
        ResultSet rs = null;
        int temp;
        if(null == room){
            temp=3;
        }
        else switch (room) {
            case SUITE:
                temp=0;
                break;
            case KING:
                temp=1;
                break;
            case QUEEN:
                temp=2;
                break;
            default:
                temp=3;
                break;
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startQuery = format1.format(start.getTime());
        String endQuery = format1.format(end.getTime());
        String query = "SELECT * FROM RESERVATIONS WHERE ((STARTDATE BETWEEN '" + startQuery + "' AND '" + endQuery + 
                       "') OR (ENDDATE BETWEEN '" + startQuery + "' AND '" + endQuery + "')) AND (ROOMTYPE = "
                       + temp + ")";
        ArrayList<Room> takenRooms = null;
        if(con != null){
            try{
                Statement stmt= con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next())
                    takenRooms.add(new Room(rs.getInt(4), 0, Room.roomType.KING));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return takenRooms;
    }
    
    /**
     * Add java documentation
     * @param reservation
     * @return 
     */
    public Reservation queryDatabase(String reservation){
        Reservation result = null;
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE RESERVATION = '" + reservation + "'";
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(2).split(delims);
                    String[] end = rs.getString(3).split(delims);
                    int startYear = Integer.parseInt(start[0]);
                    int startMonth = Integer.parseInt(start[1]) - 1;
                    int startDay = Integer.parseInt(start[2]);
                    int endYear = Integer.parseInt(end[0]);
                    int endMonth = Integer.parseInt(end[1]) - 1;
                    int endDay = Integer.parseInt(end[2]);
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(startYear, startMonth, startDay);
                    Calendar endDate = Calendar.getInstance();
                    endDate.set(endYear, endMonth, endDay);
                    currentReservations.add(new Reservation(rs.getString(1), 
                                                            rs.getInt(4), 
                                                            rs.getDouble(5), 
                                                            rs.getDouble(6),
                                                            rs.getString(7), 
                                                            rs.getString(8),
                                                            startDate,
                                                            endDate,
                                                            Room.roomType.valueOf(rs.getString(9))));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return result;
    }
    
    /**
     * Add java documentation
     * @param room
     * @return 
     */
    public ArrayList<Room> queryDatabase(Room room){
        //currentReservations.clear();
        ArrayList<Room> takenRooms = null;
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE ROOMTYPE = " + room.getRoomTypeString();
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    takenRooms.add(new Room(rs.getInt(4), 0, Room.roomType.KING));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return takenRooms;
    }
    
    /**
     * Add java documentation
     * @param lastName
     * @return 
     */
    public ArrayList<Reservation> queryDatabase(String firstName, String lastName){
        currentReservations.clear();
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE FIRSTNAME = '" 
                + firstName + "' AND LASTNAME = '" + lastName + "'";
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(2).split(delims);
                    String[] end = rs.getString(3).split(delims);
                    int startYear = Integer.parseInt(start[0]);
                    int startMonth = Integer.parseInt(start[1]) - 1;
                    int startDay = Integer.parseInt(start[2]);
                    int endYear = Integer.parseInt(end[0]);
                    int endMonth = Integer.parseInt(end[1]) - 1;
                    int endDay = Integer.parseInt(end[2]);
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(startYear, startMonth, startDay);
                    Calendar endDate = Calendar.getInstance();
                    endDate.set(endYear, endMonth, endDay);
                    currentReservations.add(new Reservation(rs.getString(1), 
                                                            rs.getInt(4), 
                                                            rs.getDouble(5), 
                                                            rs.getDouble(6),
                                                            rs.getString(7), 
                                                            rs.getString(8),
                                                            startDate,
                                                            endDate,
                                                            Room.roomType.valueOf(rs.getString(9))));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return currentReservations;
    }
    
    /**
     * Add java documentation
     * @param res 
     */
    public void makeReservation(Reservation res){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = format1.format(res.getStartDate().getTime());
        String endDate = format1.format(res.getEndDate().getTime());
        String query = "INSERT INTO RESERVATIONS VALUES ( " 
                + res.getReservationNumber() 
                + ",'"  + startDate
                + "','" + endDate
                + "',"  + Integer.toString(res.getRoomNumber())
                + ","   + Double.toString(res.getRoomRate())
                + ","   + Double.toString(res.getRoomTotal())
                + ",'"  + res.getFirstName()
                + "','" + res.getLastName() + "')";
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeQuery(query);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Add java documentation
     * @param res 
     */
    public void changeReservation(Reservation res){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = format1.format(res.getStartDate().getTime());
        String endDate = format1.format(res.getEndDate().getTime());
        String query = "UPDATE RESERVATION SET STARTDATE = '" + startDate
                + "', ENDDATE = '"  + endDate
                + "', ROOMNUMBER = "+ Integer.toString(res.getRoomNumber())
                + ", RATE = "       + Double.toString(res.getRoomRate())
                + ", TOTAL = "      + Double.toString(res.getRoomTotal())
                + ", FIRSTNAME = '" + res.getFirstName()
                + "', LASTNAME = '"  + res.getLastName() 
                + "' WHERE RESERVATIONNUMBER = '" + res.getReservationNumber() + "'";
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeQuery(query);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void deleteReservation(String resNum){
        String query = "DELETE FROM RESERVATION WHERE RESERVATIONNUMBER = '" + resNum + "'";
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeQuery(query);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
