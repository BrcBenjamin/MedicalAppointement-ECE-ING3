/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAO.My_CNX;
import View.*;
import Model.*;

/**
 *
 * @author Paul
 */
public class Controler_Medecin {
    private UserList UL;
    public Controler_Medecin(UserList U) {
        UL=U;
    }
    public boolean verify_Emptyfields(String fname,String email,String specialization,String phone,String age,String gender)
    {
        
        // check empty fields
        if(fname.trim().equals("") || email.trim().equals("")|| specialization.trim().equals("") || phone.trim().equals("")|| age.trim().equals("")|| gender.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
            return false;
        }
        
        // if everything is ok
        else{
            return true;
        }
    }
    
    // create a function to check if the entered username already exists in the database
    public boolean checkUsername(String username){
        
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM medecin WHERE email = ?";
        
        try {
            
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
        
            if(rs.next())
            {
                username_exist = true;
                JOptionPane.showMessageDialog(null, "This email is Already Taken, Choose Another One", "email Failed", 2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return username_exist;
    }
    
    public void Verify_Register(String fname,String email,String specialization,String phone,String age,String gender){
            // check if the data are empty
        if(verify_Emptyfields(fname,email,specialization,phone,age,gender))
        {
            // check if the username already exists
            if(!checkUsername(email))
             {
                 int idMedecin=0;
                 PreparedStatement ps;
                 String registerUserQuery = "INSERT INTO medecin (idMedecin,full_name,email,specialization,phone,age,gender) VALUES (?,?,?,?,?,?,?)";
                 
                 try {
                     
                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
                     ResultSet result = ps.executeQuery("SELECT * FROM medecin");
                     while(result.next()){
                     idMedecin++;
                     }
                     ps.setObject(1,(idMedecin));
                     ps.setString(2, fname);
                     ps.setString(3, email);
                     ps.setString(4, specialization);
                     ps.setString(5, phone);
                     ps.setString(6, age);
                     ps.setString(7, gender);
                     
                    if(ps.executeUpdate() != 0){
                        
                             Medecin M= new Medecin(fname,email,specialization,phone,age,gender,idMedecin);
                             UL.addMedList(M);
                             JOptionPane.showMessageDialog(null, "Your Account Has Been Created");
                    }
                    else{
                             JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                    }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
        }
    }
    public int SearchIdMed(String full_name){
        String query = "SELECT * FROM medecin WHERE full_name = ?";
        int idM=-1;
        try {
            PreparedStatement st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, full_name);
            ResultSet rs = st.executeQuery();
               
            if(rs.next())
               {
                idM= rs.getInt("idMedecin");
                
               }                
        }
        catch (SQLException ex) {
                    Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idM;
    }
}