/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUIFrames.Guest;
import hotel.Reservation;
import hotel.GUIFrames.CreateReservation;
import hotel.GUIFrames.SingleReservationResults;
import hotel.GUIFrames.Welcome;
import hotel.HotelSystem;
import hotel.ReservationDatabase;
import javax.swing.JOptionPane;

/**
 *
 * @author Chandler
 */
public class GuestEnterReservation extends javax.swing.JFrame {
    /**
     * Creates new form GuestCancelReservation
     */
    public GuestEnterReservation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        modifyReservation_Button = new javax.swing.JButton();
        home_Button = new javax.swing.JButton();
        cancelReservation_Button = new javax.swing.JButton();
        viewReservaion_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        jLabel1.setText("el Hotel");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Welcome Guest");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Reservation Code");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        modifyReservation_Button.setText("Modify Reservation");
        modifyReservation_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyReservation_ButtonActionPerformed(evt);
            }
        });

        home_Button.setText("Home");
        home_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_ButtonActionPerformed(evt);
            }
        });

        cancelReservation_Button.setText("Cancel Reservation");
        cancelReservation_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservation_ButtonActionPerformed(evt);
            }
        });

        viewReservaion_Button.setText("View");
        viewReservaion_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReservaion_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(home_Button)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyReservation_Button)
                    .addComponent(cancelReservation_Button)
                    .addComponent(viewReservaion_Button))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(viewReservaion_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifyReservation_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_Button)
                    .addComponent(cancelReservation_Button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyReservation_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyReservation_ButtonActionPerformed
        Reservation reservation = HotelSystem.getInstance(0).lookUpReservation(jTextField1.getText());
        if (reservation != null)
        {
            GuestModifyReservation frame = new GuestModifyReservation(reservation);
            frame.setLocationRelativeTo(this);
            this.setVisible(false);
            frame.setVisible(true);
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "The provided reservation code does not exist.");            
        }
    }//GEN-LAST:event_modifyReservation_ButtonActionPerformed

    private void home_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_ButtonActionPerformed
        Welcome frame = new Welcome();
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_home_ButtonActionPerformed

    private void cancelReservation_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservation_ButtonActionPerformed
        Reservation reservation = HotelSystem.getInstance(0).lookUpReservation(jTextField1.getText());
        if (reservation != null)
        {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION)
            {
                    HotelSystem.getInstance(0).removeReservation(reservation);
                    home_ButtonActionPerformed(null);
            }
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "The provided reservation code does not exist.");            
        }
    }//GEN-LAST:event_cancelReservation_ButtonActionPerformed

    private void viewReservaion_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReservaion_ButtonActionPerformed
        Reservation reservation = HotelSystem.getInstance(0).lookUpReservation(jTextField1.getText());
        if (reservation != null)
        {
            SingleReservationResults frame = new SingleReservationResults(reservation);
            frame.setLocationRelativeTo(this);
            this.setVisible(false);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_viewReservaion_ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelReservation_Button;
    private javax.swing.JButton home_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modifyReservation_Button;
    private javax.swing.JButton viewReservaion_Button;
    // End of variables declaration//GEN-END:variables
}
