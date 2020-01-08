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
public class Administrator extends User{
    private System system;
    
    private void AddAdministrator(String n, String sn, String pw, String adr, String pc, Integer a, String g){
        n = name;
        sn = surname;
        pw = password;
        adr = address;
        pc = postcode;
        a = age;
        g = gender;
    }
    
    private void AddDoctor(String n, String sn, String pw, String adr, String pc, Integer a, String g){

    }
    
    private void AddSecretary(String n, String sn, String pw, String adr, String pc, Integer a, String g){
        
    }
    
    private void RemoveDoctor(){
        
    }
    
    private void RemoveSecretary(){
        
    }
    
    private List<Doctor> ViewDoctors(){
        return system.doctors;
    }
    
    private void FeedbackDoctor(String message, Doctor d){
        SendMessageDoctor(name + " " + surname + " (Admin) says: " + message, d);
    }
}

