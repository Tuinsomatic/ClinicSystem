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
public class Doctor extends User{
    private List<Integer> ratings;
    private List<String> comments;
    private List<Appointment> appointments;
    private List<Note> notes;
    
    private void MakeAppointment(Patient p, String d){
        
    }
    
    private void MakeNotes(Patient p, String n){
        
    }
    
    private List<Appointment> InspectHistory(Patient p){
        return p.history;
    }
    
    private void CreateMedicine(String n){
        
    }
    
    private void PrescribeMedicine(Patient p, Integer a, String d){
        
    }
    
    private List<String> DisplayMessages(){
        return messages;
    }
}
