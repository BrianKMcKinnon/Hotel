/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.GUIFrames.Guest;

import hotel.GUIFrames.CreateReservation;
import hotel.GUIFrames.Welcome;
import hotel.HotelSystem;


/**
 *
 * @author Chandler
 */
public class GuestHome extends javax.swing.JFrame {
    /**
     * Creates new form GuestHomeScreen1
     */
    public GuestHome() {
        initComponents();
    }

    public GuestHome(HotelSystem hotelsystem) {
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
        makeReservation_Button = new javax.swing.JButton();
        cancelReservation_Button = new javax.swing.JButton();
        logout_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        jLabel1.setText("el Hotel");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Welcome Guest");

        makeReservation_Button.setText("New Reservation");
        makeReservation_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReservation_ButtonActionPerformed(evt);
            }
        });

        cancelReservation_Button.setText("Existing Reservation");
        cancelReservation_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservation_ButtonActionPerformed(evt);
            }
        });

        logout_Button.setText("Logout");
        logout_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(makeReservation_Button)
                            .addComponent(cancelReservation_Button)
                            .addComponent(logout_Button)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(72, 72, 72)
                .addComponent(makeReservation_Button)
                .addGap(18, 18, 18)
                .addComponent(cancelReservation_Button)
                .addGap(18, 18, 18)
                .addComponent(logout_Button)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeReservation_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReservation_ButtonActionPerformed
        CreateReservation frame = new CreateReservation();
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_makeReservation_ButtonActionPerformed

    private void cancelReservation_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservation_ButtonActionPerformed
        GuestEnterReservation frame = new GuestEnterReservation();
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_cancelReservation_ButtonActionPerformed

    private void logout_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_ButtonActionPerformed
        Welcome frame = new Welcome();
        frame.setLocationRelativeTo(this);
        this.setVisible(false);
        frame.setVisible(true);
    }//GEN-LAST:event_logout_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuestHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuestHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelReservation_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logout_Button;
    private javax.swing.JButton makeReservation_Button;
    // End of variables declaration//GEN-END:variables
}
