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
//
/**
 *
 * @author rowse
 */
public class PatientInterface extends javax.swing.JFrame {
    
    public String patientID;
    public String firstName;
    public String secondName;
    public String address;
    public String postcode;
    public String age;
    public String gender;

    /**
     * Creates new form PatientInterface
     */
    public PatientInterface() {
        initComponents();
        getAppointments();
        
        
        String userFile = "Accounts.txt";
        File users = new File(userFile);
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(users));
            Object[] userTableRows = reader.lines().toArray();
            
            for(int i=0; i<userTableRows.length; i++){
                String row = userTableRows[i].toString().trim();
                String[] collectedRow = row.split("/");
                for(int j=0; j<collectedRow.length; j++){
                    if (collectedRow[j].equals(patientID)){
                        collectedRow[3] = firstName;
                        collectedRow[4] = secondName;
                        collectedRow[5] = address;
                        collectedRow[6] = postcode;
                        collectedRow[7] = age;
                        collectedRow[8] = gender;
                        System.out.println(collectedRow);
                    }
                    else{
                        //System.out.println("Fail");
                    }
                }
            }
        }
        catch (Exception exception){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    
    
    public void getAppointments(){
        System.out.println(patientID);
        String appFile = "Appointments.txt";
        File appts = new File(appFile);
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(appts));
            Object[] apptTableRows = reader.lines().toArray();
            
            for(int i=0; i<apptTableRows.length; i++){
                String row = apptTableRows[i].toString().trim();
                String[] collectedRow = row.split("/");
                for(int j=0; j<collectedRow.length; j++){
                    System.out.println(collectedRow[j]);
                    if (collectedRow[j].equals(patientID)){
                        String docID = collectedRow[1];
                        System.out.println(docID);
                        String date = collectedRow[2];
                        System.out.println(date);
                        appointments.append(docID + ", " + date + "\n");
                    }
                    else{
                        //System.out.println("Fail");
                    }
                }
            }
        }
        catch (Exception exception){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    
    public void getDoctorRatings(){
        System.out.println(patientID);
        String appFile = "Accounts.txt";
        File appts = new File(appFile);
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(appts));
            Object[] apptTableRows = reader.lines().toArray();
            
            for(int i=1; i<apptTableRows.length; i++){
                String row = apptTableRows[i].toString().trim();
                String[] collectedRow = row.split("/");
                for(int j=0; j<collectedRow.length; j++){
                    System.out.println(collectedRow[j]);
                    if (collectedRow[j].equals("Doctor")){
                        
                        String docID = collectedRow[1];                        
                        String docFN = collectedRow[3];
                        String docSN = collectedRow[4];
                        System.out.println("xxxxxx " +docID);
                        
                        doctorRatings.append(docID + ", Dr. " + docFN + " " + docSN + ", " + getAvgRating(docID) +"\n");
                    }
                    else{
                        //System.out.println("Fail");
                    }
                }
            }
        }
        catch (Exception exception){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    
    public float getAvgRating(String id){
        String rateFile = "DoctorRatings.txt";
        File rates = new File(rateFile);
        List<Integer> sample = new ArrayList<Integer>();
        float value = 0.0f;
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(rates));
            Object[] ratesTableRows = reader.lines().toArray();
            
            for(int i=1; i<ratesTableRows.length; i++){
                String row = ratesTableRows[i].toString().trim();
                String[] collectedRow = row.split("/");
                for(int j=0; j<collectedRow.length; j++){
                    System.out.println(collectedRow[j]);
                    if (collectedRow[j].equals(id)){
                        sample.add(parseInt(collectedRow[j+1]));
                        System.out.println("xxxxxx " +sample);
                    }
                    else{
                        //System.out.println("Fail");
                    }
                }
            }            
            for (int i = 0; i<sample.size(); i++){
                value += sample.get(i);
            }
            value = value/sample.size();
            return value;
        }
        catch (Exception exception){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, exception);
        }
        return value;
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

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

        jLabel1.setText("Doctor's ID");

        jLabel2.setText("Date");

        jButton2.setText("Request Account Termination");

        jButton3.setText("Log Out");

        jLabel3.setText("Doctors and ratings");

        jLabel4.setText("Your appointments");

        jLabel5.setText("Your messages");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel6.setText("Your prescriptions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                                .addComponent(jButton1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(183, 183, 183)))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(appointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTextField appointmentDate;
    private javax.swing.JTextArea appointments;
    private javax.swing.JTextField doctorID;
    private javax.swing.JTextArea doctorRatings;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea messages;
    // End of variables declaration//GEN-END:variables
}