/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author brice
 */
public class Personne {
    
    private final String Name;
    private final String Email;
    private final String Age;
    private final String Phone;
    private final String Gender;
    
    public Personne(String n,String e,String ph,String a,String g){
        Name=n;
        Email=e;
        Age=a;
        Phone=ph;
        Gender=g;
    }
    public String getName(){
        return Name;
    }
    public String getEmail(){
        return Email;
    }
    public String getAge(){
        return Age;
    }
    public String getPhone(){
        return Phone;
    }
    public String getGender(){
        return Gender;
    }
}

