package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.PatientInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rowse
 */
public class Login extends javax.swing.JFrame {
    
    Object[] tableRows = null;
    public String userType = null; 
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public void readFile(String fileName){
    String userFile = fileName;
    File users = new File(userFile);
        
    try{
        BufferedReader reader = new BufferedReader(new FileReader(users));
        tableRows = reader.lines().toArray(); //put all rows into an array
        }
    catch (Exception exception){
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, exception);
    }
    }
        
    public Boolean CheckCredentials(String id, String pw){ //id = usernameTextField.getText(), pw = passwordTextField.getText()
        
        readFile("Accounts.txt");
        for(int i=0; i<tableRows.length; i++){ //for each row...
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/"); //... split each datum into another array, splitting them at "/"
            for(int j=0; j<collectedRow.length; j++){ //for each string in row i...
                if (collectedRow[j].equals(id) && collectedRow[j+1].equals(pw)){ //if one string = id AND the one after it = pw...
                    //System.out.println("Success");
                    userType = collectedRow[0]; //...select the current row and save it for later
                    return true;
                }
                else{
                }
            }
        }
        return false;
    }
    
    public void SwitchToPatient(String id){ //do this for all user types
        PatientInterface p = new PatientInterface();
        p.setID(usernameField.getText());
        p.getAppointments();
        p.getDoctorRatings(); //put all the "read" functions for the corresponding user type here
        p.getMessages();
        p.getPrescriptions();
        p.getHistory();
        p.setVisible(true);
        this.dispose();
    }
    
    public void SwitchToSecretary(String id){
        SecretaryInterface s = new SecretaryInterface();
        s.ID = usernameField.getText();
        s.GetAccRequests();
        s.GetApptRequests();
        s.GetRemovalRequests();
        s.getMedicines();
        s.setVisible(true);
        this.dispose();
    }
    
    public void SwitchToDoctor(String id){
        DoctorInterface d = new DoctorInterface();
        d.ID = usernameField.getText();
        d.setVisible(true);
        d.getAppointments();
        d.getMedicines();
        this.dispose();
    }
    
    public void SwitchToAdministrator(String id){
        AdminInterface a = new AdminInterface();
        a.ID = usernameField.getText();
        a.getAccounts();
        a.setVisible(true);
        this.dispose();
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
        jTable1 = new javax.swing.JTable();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        accountsTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(accountsTable);
        accountsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("User ID");

        jLabel2.setText("Password");

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(registerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        CheckCredentials(usernameField.getText(), passwordField.getText());

            System.out.println(userType);
            
            if ("Patient".equals(userType)){
                System.out.println("Patient");
                SwitchToPatient(usernameField.getText());
            }
            else if ("Administrator".equals(userType)){
                System.out.println("Admin");
                SwitchToAdministrator(usernameField.getText());
            }
            else if ("Secretary".equals(userType)){
                System.out.println("Secretary");
                SwitchToSecretary(usernameField.getText());
            }
            else if ("Doctor".equals(userType)){
                System.out.println("Doctor");
                SwitchToDoctor(usernameField.getText());
            }
            else{
                usernameField.setText("");
                passwordField.setText("");
            }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        Register r = new Register();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton registerButton;
    public javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

}
