/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
/**
 *
 * @author brice
 */
public class Patient extends Personne{
    
    //Liste des IdRendezVous
    private ArrayList<Integer> AppoList;
    private final int idPatient;
    private final String Password;
    
    public Patient(String n,String e,String p,String a,String ph,String g,int id){
        super(n,e,a,ph,g);
        AppoList = new ArrayList<>();
        idPatient=id;
        Password=p;
    }
    public int getId(){
       return idPatient;
    }
    public void takeAppointement(Integer id){
       AppoList.add(id);        
    }
    public ArrayList<Integer> getAppointement(){
        return AppoList;
    }
    
}
