/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUIFrames;

import hotel.HotelSystem;
import hotel.Reservation;
import hotel.Room;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;


/**
 *
 * @author Chandler
 */
public class CreateReservation extends javax.swing.JFrame {
    HotelSystem hs;
    /**
     * Creates new form GuestReservationScreen1
     */
    
    public CreateReservation(HotelSystem hotelsystem) {
        initComponents();
        initCalendars();        
        String[] roomTypes = { "Suite", "King", "Queen", "Single", "No Preference" };
        roomType_Chooser.setListData(roomTypes);
        roomType_Chooser.setSelectedIndex(0);
        hs=hotelsystem;
    }

    public CreateReservation(HotelSystem hs, Reservation temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void initCalendars()
    {
        Calendar tempCal = Calendar.getInstance();
        
        startDate_Chooser.setCalendar(tempCal);
        tempCal.add(Calendar.DATE, 1); // Set to tomorrow's date
        endDate_Chooser.setCalendar(tempCal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        findRooms_Button = new javax.swing.JButton();
        home_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomType_Chooser = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        startDate_Chooser = new com.toedter.calendar.JDateChooser();
        endDate_Chooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Book a Reservation");

        jLabel3.setText("Start Date");

        jLabel4.setText("End Date");

        jLabel5.setText("Room Type");

        findRooms_Button.setText("Find Rooms");
        findRooms_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findRooms_ButtonActionPerformed(evt);
            }
        });

        home_Button.setText("Home");
        home_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_ButtonActionPerformed(evt);
            }
        });

        roomType_Chooser.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        roomType_Chooser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomType_Chooser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                roomType_ChooserAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(roomType_Chooser);

        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        jLabel1.setText("el Hotel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(findRooms_Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(home_Button))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(119, 119, 119)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(endDate_Chooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(startDate_Chooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDate_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(home_Button)
                            .addComponent(findRooms_Button))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void home_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_ButtonActionPerformed
        Welcome frame = new Welcome(hs);
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_home_ButtonActionPerformed
    
    
    private void findRooms_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findRooms_ButtonActionPerformed
        if (startDate_Chooser.getCalendar().compareTo(endDate_Chooser.getCalendar()) > 0)   // Check if startDate is before endDate
        {
            JOptionPane.showMessageDialog(null, "Start Date must be before End Date");
        }
        else 
        {  
            ArrayList<Room> rooms = new ArrayList<Room>();
            rooms = null;
            Room tempRoom = hs.allRooms().get(0);
            Calendar tempStart = Calendar.getInstance();
            tempStart = startDate_Chooser.getCalendar();
            System.out.println(Integer.toString(roomType_Chooser.getSelectedIndex()));
            rooms = hs.findAvailableRoom(startDate_Chooser.getCalendar(), endDate_Chooser.getCalendar(), tempRoom.translateType(roomType_Chooser.getSelectedIndex()));
            System.out.print(tempRoom.translateType(roomType_Chooser.getAnchorSelectionIndex()));
            Calendar tempEnd = Calendar.getInstance();
            System.out.println(Integer.toString(rooms.size()));
            tempEnd = endDate_Chooser.getCalendar();
            if (rooms != null)
            {
                Reservation tempRes = new Reservation(hs, "0000000000", rooms.get(0).getRoomNumber(), rooms.get(0).getCost(), 0.00, "First", "Last", tempStart, tempEnd, rooms.get(0).getRoomType());
                if(tempRes.getStartDate() != null)
                {
                    
                    System.out.println("about to enter RoomResults");
                    RoomResults frame = new RoomResults(hs, tempRes);
                    //frame.setReservation(tempRes);
                    frame.setLocationRelativeTo(this);
                    this.setVisible(false);
                    frame.setVisible(true);
                }
                else
                {
                    System.out.println("getStartDate = null");
                }
            }
            else{
                System.out.println("No available rooms");
            }
        }
    }//GEN-LAST:event_findRooms_ButtonActionPerformed

    private void roomType_ChooserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_roomType_ChooserAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_roomType_ChooserAncestorAdded

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateReservation(hs).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDate_Chooser;
    private javax.swing.JButton findRooms_Button;
    private javax.swing.JButton home_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> roomType_Chooser;
    private com.toedter.calendar.JDateChooser startDate_Chooser;
    // End of variables declaration//GEN-END:variables

}
