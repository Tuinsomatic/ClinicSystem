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
public class Prescription {
    private Medicine medicine;
    private Integer amount;
    private String dosage;
    private Patient patient;
    
    private void Prescription(Medicine m, Integer a, String d, Patient p){
        m = medicine;
        a = amount;
        d = dosage;
        p = patient;
    }
}
