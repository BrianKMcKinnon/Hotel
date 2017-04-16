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
public class Connection {
    public Connection(){
        
    }
    
    private int state;
    private HotelSystem system;
    private static final int MAIN_MENU = 0;             //from here, continue as guest or choose employee/manager menu          
    private static final int EMPLOYEE_MENU = 1;     
    private static final int MANAGER_MENU = 2;
    private static final int MAKE_RESERVATION = 3;
    private static final int CHANGE_RESERVATION = 4;
    private static final int CANCEL_RESERVATION = 5;
    
    
}
