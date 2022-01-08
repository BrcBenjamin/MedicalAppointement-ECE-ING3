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
public class Employee extends Personne {
    private final int idEmployee;
    private final String Password;
    
    public Employee(String n,String e,String p,String a,String ph,String g,int id){
        super(n,e,a,ph,g);
        idEmployee=id;
        Password=p;
    }
    public int getId(){
        return idEmployee;
    }
}
