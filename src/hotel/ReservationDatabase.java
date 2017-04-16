/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;
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
public class ReservationDatabase {
    public ReservationDatabase(){


        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Reservations");
           
        }catch(Exception e){
            System.out.println("Error opening connections: " + e);
        }
    }
    
    public ArrayList<Room> queryDatabase(Calendar start, Calendar end){
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
                    takenRooms.add(new Room(rs.getInt(4), 0, 0, 0));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return takenRooms;
    }
    
    public Reservation queryDatabase(int reservation){
        Reservation result = null;
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE RESERVATION == " + Integer.toString(reservation);
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(7).split(delims);
                    String[] end = rs.getString(8).split(delims);
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
                    result = new Reservation(rs.getInt(1), 
                                             rs.getInt(4), 
                                             rs.getDouble(5),
                                             rs.getDouble(6),
                                             new Guest(rs.getString(7), rs.getString(8)), 
                                             startDate,
                                             endDate);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        return result;
    }
    
    public ArrayList<Reservation> queryDatabase(Room room){
        currentReservations.clear();
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE ROOMTYPE == " + Integer.toString(room.roomType);
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(7).split(delims);
                    String[] end = rs.getString(8).split(delims);
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
                    currentReservations.add(new Reservation(rs.getInt(1), 
                                                            rs.getInt(4), 
                                                            rs.getDouble(5), 
                                                            rs.getDouble(6),
                                                            new Guest(rs.getString(7), rs.getString(8)),
                                                            startDate,
                                                            endDate));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return currentReservations;
    }
    
    public ArrayList<Reservation> queryDatabase(String lastName){
        currentReservations.clear();
        ResultSet rs = null;
        String query = "SELECT * FROM RESERVATIONS WHERE LASTNAME == '" + lastName + "'";
        
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    String delims = "-";
                    String[] start = rs.getString(7).split(delims);
                    String[] end = rs.getString(8).split(delims);
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
                    currentReservations.add(new Reservation(rs.getInt(1), 
                                                            rs.getInt(4), 
                                                            rs.getDouble(5), 
                                                            rs.getDouble(6),
                                                            new Guest(rs.getString(7), rs.getString(8)),
                                                            startDate,
                                                            endDate));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return currentReservations;
    }
    
    public void makeReservation(Reservation res){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = format1.format(res.getStartDate().getTime());
        String endDate = format1.format(res.getEndDate().getTime());
        String query = "INSERT INTO RESERVATIONS VALUES ( " 
                + Integer.toString(res.getReservationNumber()) 
                + ",'"  + startDate
                + "','" + endDate
                + "',"  + Integer.toString(res.getRoomNumber())
                + ","   + Double.toString(res.getRoomRate())
                + ","   + Double.toString(res.getRoomTotal())
                + ",'"  + res.getRoomGuest().getFirstName()
                + "','" + res.getRoomGuest().getLastName() + "')";
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeQuery(query);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void changeReservation(Reservation res){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = format1.format(res.getStartDate().getTime());
        String endDate = format1.format(res.getEndDate().getTime());
        String query = "UPDATE RESERVATION SET STARTDATE = '" + startDate
                + "', ENDDATE = '"  + endDate
                + "', ROOMNUMBER = "+ Integer.toString(res.getRoomNumber())
                + ", RATE = "       + Double.toString(res.getRoomRate())
                + ", TOTAL = "      + Double.toString(res.getRoomTotal())
                + ", FIRSTNAME = '" + res.getRoomGuest().getFirstName()
                + "', LASTNAME = '"  + res.getRoomGuest().getLastName() + "'";
        if(con != null){
            try{
                Statement stmt = con.createStatement();
                stmt.executeQuery(query);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    private ArrayList<Reservation> currentReservations;
    Connection con = null;
}
