/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import gui.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import static jdk.nashorn.internal.objects.NativeMath.round;
//
/**
 *
 * @author rowse
 */
public class PatientInterface extends User {

    /**
     * Creates new form PatientInterface
     */
    public PatientInterface() {
        initComponents();
        
        readFile("Accounts.txt");
            
        for(int i=0; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(ID)){
                    collectedRow[3] = forename;
                    collectedRow[4] = surname;
                    collectedRow[5] = address;
                    collectedRow[6] = postcode;
                    setAge(parseInt(collectedRow[7]));
                    collectedRow[8] = gender;
                }
                else{
                }
            }
        }
    }  
    
    public void getAppointments(){
        System.out.println(ID);
        
        readFile("Appointments.txt");
            
        for(int i=0; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(ID)){
                    String docID = collectedRow[1];
                    String date = collectedRow[2];
                    appointments.append(docID + ", " + date + "\n");
                }
            }
        }
    }
    
    public void getDoctorRatings(){
        readFile("Accounts.txt");
            
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals("Doctor")){
                        
                    String docID = collectedRow[1];                        
                    String docFN = collectedRow[3];
                    String docSN = collectedRow[4];
                        
                    doctorRatings.append(docID + ", Dr. " + docFN + " " + docSN + ", " + getAvgRating(docID) +" / 5\n");
                }
            }
        }
    }
    
    public float getAvgRating(String id){
        
        readFile("DoctorRatings.txt");
        
        List<Integer> sample = new ArrayList<Integer>();
        float value = 0.0f;
            
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(id)){
                    sample.add(parseInt(collectedRow[j+1]));
                }
            }
        }            
        for (int i = 0; i<sample.size(); i++){
            value += sample.get(i);
        }
        value = value/sample.size();
        return value;
    }
    
    public void getMessages(){
        readFile("Messages.txt");
        
         for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(ID)){
                    messages.append("From " + findUser(collectedRow[0]) + ": " + collectedRow[2] + " | " + collectedRow[3] + "\n");
                    readFile("Messages.txt");
                }
            }
        }        
    }
    
    public void getPrescriptions(){
        readFile("Prescriptions.txt");
        
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(ID)){
                    prescriptions.append(collectedRow[2] + " x " + findMedicine(collectedRow[1]) + ", " + collectedRow[3]);
                    readFile("Prescriptions.txt");
                }
            }
        }  
    }
    
    public void getHistory(){
        readFile("Patient History.txt");
        
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(ID)){
                    patientHistory.append((String) tableRows[i] + "\n");
                }
            }
        }  
    }
    
    public void RequestAppointment(){
        String docID = doctorID.getText();
        String apptDate = appointmentDate.getText();
        String request = ID + "/" + docID + "/" + apptDate;
        writeFile("Appointment Requests.txt", request);
    }
    
    public void RequestRemoval(){
        writeFile("Removal Requests.txt", ID);
    }
    
    public void sendDoctorRating(){
        String docID = docIDField.getText();
        Integer rating = parseInt((String) ratingField.getSelectedItem());
        String data = docID + "/" + rating;
        writeFile("DoctorRatings.txt", data);
        doctorRatings.setText("");
        getDoctorRatings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messages = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        appointments = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        doctorRatings = new javax.swing.JTextArea();
        doctorID = new javax.swing.JTextField();
        appointmentDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        requestRemovalButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        prescriptions = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        patientHistory = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        sendRatingButton = new javax.swing.JButton();
        docIDField = new javax.swing.JTextField();
        ratingField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messages.setColumns(20);
        messages.setRows(5);
        jScrollPane1.setViewportView(messages);

        appointments.setColumns(20);
        appointments.setRows(5);
        jScrollPane2.setViewportView(appointments);

        doctorRatings.setColumns(20);
        doctorRatings.setRows(5);
        jScrollPane3.setViewportView(doctorRatings);

        doctorID.setToolTipText("");

        jButton1.setText("Request Appointment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Doctor's ID");

        jLabel2.setText("Date");

        requestRemovalButton.setText("Request Account Termination");
        requestRemovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestRemovalButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Log Out");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Doctors and ratings");

        jLabel4.setText("Your appointments");

        jLabel5.setText("Your messages");

        prescriptions.setColumns(20);
        prescriptions.setRows(5);
        jScrollPane4.setViewportView(prescriptions);

        jLabel6.setText("Your prescriptions");

        patientHistory.setColumns(20);
        patientHistory.setRows(5);
        jScrollPane5.setViewportView(patientHistory);

        jLabel7.setText("Your history");

        sendRatingButton.setText("Send Rating");
        sendRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendRatingButtonActionPerformed(evt);
            }
        });

        ratingField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel8.setText("Doctor's ID");

        jLabel9.setText("Your rating out of 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(183, 183, 183))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(doctorID)
                                            .addComponent(appointmentDate, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jButton1))
                                    .addComponent(requestRemovalButton)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LogoutButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ratingField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(docIDField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sendRatingButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(doctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(appointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(docIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ratingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendRatingButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(requestRemovalButton)
                                    .addComponent(LogoutButton)))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        Logout();
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RequestAppointment();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void requestRemovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestRemovalButtonActionPerformed
        RequestRemoval();
    }//GEN-LAST:event_requestRemovalButtonActionPerformed

    private void sendRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendRatingButtonActionPerformed
        sendDoctorRating();
    }//GEN-LAST:event_sendRatingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PatientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogoutButton;
    private javax.swing.JTextField appointmentDate;
    private javax.swing.JTextArea appointments;
    private javax.swing.JTextField docIDField;
    private javax.swing.JTextField doctorID;
    private javax.swing.JTextArea doctorRatings;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea messages;
    private javax.swing.JTextArea patientHistory;
    private javax.swing.JTextArea prescriptions;
    private javax.swing.JComboBox<String> ratingField;
    private javax.swing.JButton requestRemovalButton;
    private javax.swing.JButton sendRatingButton;
    // End of variables declaration//GEN-END:variables
}
