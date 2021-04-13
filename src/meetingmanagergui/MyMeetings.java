/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetingmanagergui;

import BloggManager.BloggService;
import DB.EmployeeDB;
import DB.MeetingDB;
import Models.Employee;
import Models.IEmployee;
import Models.IMeeting;
import Models.Meeting;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nene5
 */
public class MyMeetings extends javax.swing.JFrame {
    
    private IMeeting _meetingService = new BloggService(new MeetingDB());
    private IEmployee _employeService = new BloggService(new EmployeeDB());
    private Employee employee;
    private ArrayList<Meeting> meetings = new ArrayList<>();
    private int i = 0;

    
    public MyMeetings() {
        initComponents();
    }  
    
    public MyMeetings(Employee e) {
        initComponents();
        this.employee = e;
        fillMyMeetings();
        
        if(i == 0 )
        {
            btnPrev.setVisible(false);
        }
    }
    
    public void fillMyMeetings()
    {
    

         meetings = _meetingService.getMyMeetings(employee.getID());
         if(meetings == null)
         {
             lblMyMeetings.setText("Du har inga mötesförfrågningar för tillfället");
             cbxConfirm.setVisible(false);
             cbxDenied.setVisible(false);
             btnNext.setVisible(false);
             btnSend.setVisible(false);
             jLabel1.setVisible(false);
             jLabel2.setVisible(false);
             jLabel3.setVisible(false);
             jLabel4.setVisible(false);
             jLabel5.setVisible(false);
             lblTid.setVisible(false);
             lblPlats.setVisible(false);
             lblDatum.setVisible(false);
             lblInvitor.setVisible(false);
       
            
             return;
         }
         var invitor = _employeService.getEmployeeByID(meetings.get(i).getSenderID());
         var invitorname = invitor.getFirstname();
         
         if(meetings.size() == 1)
         {
            btnNext.setVisible(false);
            lblPlats.setText(meetings.get(i).getPlats());
            lblTid.setText(meetings.get(i).getTid());
            lblDatum.setText(meetings.get(i).getDatum());
            lblInvitor.setText(invitorname);
         }
         
         else if(meetings.size() > 1)
         {
            lblPlats.setText(meetings.get(i).getPlats());
            lblTid.setText(meetings.get(i).getTid());
            lblDatum.setText(meetings.get(i).getDatum());
            lblInvitor.setText(invitorname);
         }
          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblInbjuden = new javax.swing.JPanel();
        lblMyMeetings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblTid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblInvitor = new javax.swing.JLabel();
        cbxConfirm = new javax.swing.JCheckBox();
        cbxDenied = new javax.swing.JCheckBox();
        btnSend = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblInbjuden.setBorder(new javax.swing.border.MatteBorder(null));

        lblMyMeetings.setText("My Meetings");

        jLabel1.setText("Plats");

        jLabel2.setText("Datum");

        jLabel4.setText("Tid");

        lblPlats.setText("...");

        lblDatum.setText("...");

        lblTid.setText("...");

        jLabel5.setText("Inbjuden av");

        lblInvitor.setText("...");

        buttonGroup1.add(cbxConfirm);
        cbxConfirm.setText("Bekräfta");

        buttonGroup1.add(cbxDenied);
        cbxDenied.setText("Neka");

        btnSend.setText("Skicka");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblInbjudenLayout = new javax.swing.GroupLayout(lblInbjuden);
        lblInbjuden.setLayout(lblInbjudenLayout);
        lblInbjudenLayout.setHorizontalGroup(
            lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblInbjudenLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblInbjudenLayout.createSequentialGroup()
                        .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblInbjudenLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDatum))
                            .addGroup(lblInbjudenLayout.createSequentialGroup()
                                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlats, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTid, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblInvitor, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(48, 48, 48))
                    .addGroup(lblInbjudenLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(cbxConfirm)
                        .addGap(18, 18, 18)
                        .addComponent(cbxDenied)
                        .addGap(0, 39, Short.MAX_VALUE))))
            .addGroup(lblInbjudenLayout.createSequentialGroup()
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblInbjudenLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblMyMeetings))
                    .addGroup(lblInbjudenLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnSend)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblInbjudenLayout.setVerticalGroup(
            lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblInbjudenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMyMeetings)
                .addGap(33, 33, 33)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPlats))
                .addGap(18, 18, 18)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblDatum))
                .addGap(18, 18, 18)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblInvitor))
                .addGap(39, 39, 39)
                .addGroup(lblInbjudenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxConfirm)
                    .addComponent(cbxDenied))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addGap(51, 51, 51))
        );

        btnPrev.setText("Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInbjuden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInbjuden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 324, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrev, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        
        i++;
        btnPrev.setVisible(true);
        if( i >= meetings.size()-1)
        {
            btnNext.setVisible(false);
        }
        var invitor = _employeService.getEmployeeByID(meetings.get(i).getSenderID());
        var invitorname = invitor.getFirstname();
 
        lblPlats.setText(meetings.get(i).getPlats());
        lblTid.setText(meetings.get(i).getTid());
        lblDatum.setText(meetings.get(i).getDatum());
        lblInvitor.setText(invitorname);        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        
        i--; 
        btnNext.setVisible(true);
        if( i == 0)
        {
            btnPrev.setVisible(false);
        }
        var invitor = _employeService.getEmployeeByID(meetings.get(i).getSenderID());
        var invitorname = invitor.getFirstname();
        
        lblPlats.setText(meetings.get(i).getPlats());
        lblTid.setText(meetings.get(i).getTid());
        lblDatum.setText(meetings.get(i).getDatum());
        lblInvitor.setText(invitorname);
        
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
       
       var id = meetings.get(i).getID();
        
       if(cbxConfirm.isSelected())
       {
           var j = "J";
           _meetingService.UpdateMeeting(id, j);
           meetings.remove(meetings.get(i));
       }
       else if(cbxDenied.isSelected())
       {
           var n = "N";
           _meetingService.UpdateMeeting(id, n);
           meetings.remove(meetings.get(i));
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Du måste bekräfta eller neka mötesförfrågan");
           return;  
       }
       JOptionPane.showMessageDialog(null, "Ditt svar är skickat!");
       this.dispose();
      
    

    }//GEN-LAST:event_btnSendActionPerformed

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
            java.util.logging.Logger.getLogger(MyMeetings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyMeetings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyMeetings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyMeetings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyMeetings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSend;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxConfirm;
    private javax.swing.JCheckBox cbxDenied;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JPanel lblInbjuden;
    private javax.swing.JLabel lblInvitor;
    private javax.swing.JLabel lblMyMeetings;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblTid;
    // End of variables declaration//GEN-END:variables
}
