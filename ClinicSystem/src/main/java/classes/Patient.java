/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.*;

/**
 *
 * @author rowse
 */
public class Patient extends User {
    public List<Appointment> history;
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;
    private List<Medicine> inventory;
    
    private void RequestAccount(String fore, String sur, String pass, String addr, String post, Integer agee, String sex){
        
    }
    
    private void RateDoctor(Doctor docName, String comment){
        
    }
    
    private void ViewDoctors(){
        
    }
    
    private void RequestAppointment(Doctor docName, String date){
        
    }
    
    private List<Appointment> ViewAppointmentHistory(){
        return history;
    }
    
    private List<Appointment> ViewAppointments(){
        return appointments;
    }
    
    private List<Prescription> ViewPrescriptions(){
        return prescriptions;
    }
    
    private List<Medicine> DisplayInventory(){
        return inventory;
    }
    
    private void RequestRemoval(){
        
    }
}
