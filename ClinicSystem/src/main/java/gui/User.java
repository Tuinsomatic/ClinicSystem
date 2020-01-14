/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rowse
 */
public class User extends javax.swing.JFrame {
    
    public String ID;
    public String password;
    public String forename;
    public String surname;
    public String address;
    public String postcode;
    public Integer age;
    public String gender;
    
    public Object[] tableRows;

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void Logout(){
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
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
    
    public void writeFile(String fileName, String text){
        File file = new File(fileName);
        
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine();
            writer.write(text);
            writer.close();
        }
        catch (IOException exception){
            System.out.println("Error writing to file");
        }
    }
    
    public void deleteFile(String fileName, String row){
        File oldFile = new File(fileName);
        File newFile = new File("1" + fileName);
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            
            String current;
            while((current = reader.readLine()) != null){
                String trimmed = current.trim();
                if (trimmed.equals(row)){
                    continue;
                }
                writer.write(current + System.getProperty("line.separator"));
            }
            
            writer.close();
            reader.close();
            
            BufferedReader reader2 = new BufferedReader(new FileReader(newFile));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName));
            
            String current2;
            while((current2 = reader2.readLine()) != null){
                String trimmed = current2.trim();
                writer2.write(current2 + System.getProperty("line.separator"));
            }
            
            writer2.close();
            reader2.close();
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        newFile.delete();
    }
    
    public String findUser(String id){
        readFile("Accounts.txt");
        
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(id)){
                    return (collectedRow[3] + " " + collectedRow[4]);
                }
            }
        } 
        return ("not found");
    }
    
    public String findMedicine(String id){
        readFile("Medicine.txt");
        
        for(int i=1; i<tableRows.length; i++){
            String row = tableRows[i].toString().trim();
            String[] collectedRow = row.split("/");
            for(int j=0; j<collectedRow.length; j++){
                if (collectedRow[j].equals(id.toString())){
                    return (collectedRow[0]);
                }
            }
        } 
        return ("not found");
    }       
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
