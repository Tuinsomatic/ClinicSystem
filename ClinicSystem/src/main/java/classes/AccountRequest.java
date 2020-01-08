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
public class AccountRequest {
    private String password;
    private String name;
    private String surname;
    private String address;
    private String postcode;
    private Integer age;
    private String gender;
    
    private void AccountRequest(String p, String n, String s, String ad, String pc, Integer a, String g){
        p = password;
        n = name;
        s = surname;
        ad = address;
        pc = postcode;
        a = age;
        g = gender;
    }
}
