/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author rowse
 */
public class Appointment {
    private String date;
    private Patient patient;
    private Doctor doctor;
    
    private void Appointment(String d, Patient p, Doctor doc){
        d = date;
        p = patient;
        doc = doctor;
    }
}
