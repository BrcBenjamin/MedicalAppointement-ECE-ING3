/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Paul
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAO.My_CNX;
import View.*;
import Model.*;

//import Controler_Medecin;
public class Controler_Patient {
    private UserList UL;
    public Controler_Patient(UserList U) {
        UL=U;
    }
    
// create a function to verify the empty fields  
    public boolean verifyFields(String fname, String uname, String phone, String pass1, String pass2)
    {
        // check empty fields
        if(fname.trim().equals("") || uname.trim().equals("") || phone.trim().equals("")
           || pass1.trim().equals("") || pass2.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
            return false;
        }
        
        // check if the two password are equals or not
        else if(!pass1.equals(pass2))
        {
           JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2); 
           return false;
        }
        
        // if everything is ok
        else{
            return true;
        }
    }
 
    public boolean checkUsername(String username){
        
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM patient WHERE email = ?";
        
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
    
 public void Verify_Login(String email, String password){
    if(checkUsername_Login(email)){
            PreparedStatement st;
            ResultSet rs;
            String query = "SELECT * FROM patient WHERE email = ? AND password =? ";
            try {
                
                st = My_CNX.getConnection().prepareStatement(query);
                st.setString(1, email);
                st.setString(2, password);
                rs = st.executeQuery();
                if(rs.next())
                {
                    int id= rs.getInt("idPatient");
                    new Interface_patient(UL, id).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "password Doesn't Match, Try new password","Try new password",2);
                    new Login_form_patient(UL).setVisible(true);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    if(!checkUsername_Login(email)){
            JOptionPane.showMessageDialog(null, "Email Doesn't Match, Try new email or register","Try new email or register ",2);
            new Login_form_patient(UL).setVisible(true);
        }
 }
 
    public boolean checkUsername_Login(String username){
        
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM patient WHERE email = ?";
        
        try {
            
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
        
            if(rs.next())
            {
                username_exist = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return username_exist;
    }

public void Verify_Register(String fname,String email,String pass1,String pass2,String phone,String age, String gender){
        // check if the data are empty
         if(verifyFields(fname, email,phone, pass1, pass2))
         {
        // check if the username already exists
             if(!checkUsername(email))
             {
                 int idPatient=0;
                 PreparedStatement ps;
                 String registerUserQuery = "INSERT INTO patient (idPatient,full_name,email,password,phone,age,gender) VALUES (?,?,?,?,?,?,?)";
                 
                 try {
                     
                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
                     ResultSet result = ps.executeQuery("SELECT * FROM patient");
                     while(result.next()){
                     idPatient++;
                     }
                     ps.setObject(1,(idPatient));
                     ps.setString(2, fname);
                     ps.setString(3, email);
                     ps.setString(4, pass1);
                     ps.setString(5, phone);
                     ps.setString(6, age);
                     ps.setString(7, gender);
                     
                    if(ps.executeUpdate() != 0){
                        

                             Patient P= new Patient(fname,email,pass1,age,phone,gender,idPatient);
                             UL.addPatList(P);
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
}