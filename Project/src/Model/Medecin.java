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
public class Medecin extends Personne{
    private int idMedecin;
    private String Specialization;
    
    public Medecin(String n,String e,String s,String ph,String a,String g,int id){
        super(n,e,a,ph,g);
        idMedecin=id;
        Specialization=s;
    }
}