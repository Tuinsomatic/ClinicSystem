package classes;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rowse
 */
public class User {
    public String ID;
    public String password;
    public String name;
    public String surname;
    public String address;
    public String postcode;
    public Integer age;
    public String gender;
    public List<String> messages;
    
    private String LogIn(String loginID, String loginPassword){
        if (loginID.equals(ID) && loginPassword.equals(password)){
            return ID;
        }
        else{
            return null;
        }
    }
    
    private List<String> DisplayMessages(){
        return messages;
    }
    
    public void SendMessageDoctor(String message, Doctor recipient){
        recipient.messages.add(message);
    }
}
