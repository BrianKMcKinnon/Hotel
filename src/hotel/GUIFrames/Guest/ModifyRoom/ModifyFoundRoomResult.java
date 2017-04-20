/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUIFrames.Guest.ModifyRoom;

import hotel.GUIFrames.Welcome;
import hotel.Reservation;
import java.text.SimpleDateFormat;

/**
 *
 * @author Chandler
 */
public class ModifyFoundRoomResult extends javax.swing.JFrame {
    Reservation currentReservation;
    Reservation newReservation;
    
    /**
     * Creates new form ModifyRoomResult
     */
    public ModifyFoundRoomResult(Reservation currentReservation, Reservation newReservation) {
        initComponents();
        this.currentReservation = currentReservation;
        this.newReservation = newReservation;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        startDate_label.setText(dateFormat.format(currentReservation.getStartDate().getTime()));
        endDate_label.setText(dateFormat.format(currentReservation.getEndDate().getTime()));
        rate_label.setText(Double.toString(currentReservation.getRoom().getCost()));
        roomType_label.setText(currentReservation.getRoom().getRoomTypeString());
        
        double totalCost = currentReservation.getReservationTotal();
        double newTotal = newReservation.getReservationTotal();
        
        totalCost_label.setText(Double.toString(totalCost));
        newTotal_label.setText(Double.toString(newTotal));
        difference_label.setText(Double.toString(totalCost - newTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rate_label = new javax.swing.JLabel();
        confirmBooking_Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startDate_label = new javax.swing.JLabel();
        endDate_label = new javax.swing.JLabel();
        roomType_label = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalCost_label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newTotal_label = new javax.swing.JLabel();
        difference_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        home_Button.setText("Home");
        home_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_ButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        jLabel1.setText("el Hotel");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Welcome Guest");

        rate_label.setText("$100");

        confirmBooking_Button.setText("Confirm Booking");
        confirmBooking_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBooking_ButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Check In Date:");

        jLabel4.setText("Check Out Date:");

        jLabel5.setText("Room Type:");

        startDate_label.setText("October 15, 2017");

        endDate_label.setText("October 19, 2017");

        roomType_label.setText("King Size");

        jLabel9.setText("Cost Per Night:");

        jLabel10.setText("Previous Total:");

        totalCost_label.setText("$400");

        jLabel6.setText("New Total:");

        jLabel7.setText("Difference:");

        newTotal_label.setText("$600");

        difference_label.setText("$200");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(startDate_label))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(roomType_label)
                                                    .addComponent(endDate_label)
                                                    .addComponent(totalCost_label)
                                                    .addComponent(rate_label)
                                                    .addComponent(newTotal_label)
                                                    .addComponent(difference_label))))))))
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmBooking_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_Button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(startDate_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(endDate_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roomType_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rate_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalCost_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(newTotal_label))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(home_Button)
                            .addComponent(confirmBooking_Button))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(difference_label))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void home_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_ButtonActionPerformed
        Welcome frame = new Welcome();
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_home_ButtonActionPerformed

    private void confirmBooking_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBooking_ButtonActionPerformed
        ModifyPaymentScreen frame = new ModifyPaymentScreen(currentReservation, newReservation);
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_confirmBooking_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBooking_Button;
    private javax.swing.JLabel difference_label;
    private javax.swing.JLabel endDate_label;
    private javax.swing.JButton home_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel newTotal_label;
    private javax.swing.JLabel rate_label;
    private javax.swing.JLabel roomType_label;
    private javax.swing.JLabel startDate_label;
    private javax.swing.JLabel totalCost_label;
    // End of variables declaration//GEN-END:variables
}
