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
import Model.UserList;
import View.Interface_employee;
import View.Login_form_employee;
import View.Register_form_patient;
import View.Register_form_employee;
import Model.*;
import Controller.*;


public class Controler_Employee {
    private UserList UL;
    public Controler_Employee(UserList U) {
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
 
// create a function to check if the entered username already exists in the database
    public boolean checkUsername(String username){
        
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM employee WHERE email = ?";
        
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
    
    public boolean checkUsername_Login(String username){
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM employee WHERE email = ?";
        
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
    
public void Verify_Register(String fname, String email, String pass1, String pass2, String phone, String age, String gender){
     // check if the data are empty
        if(verifyFields(fname,email,phone,pass1,pass2))
        {
            // check if the username already exists
            if(!checkUsername(email))
             {
                 int idEmployee=0;
                 PreparedStatement ps;
                 String registerUserQuery = "INSERT INTO employee (idEmployee,full_name,email,password,phone,age,gender) VALUES (?,?,?,?,?,?,?)";
                 
                 try {
                     
                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
                     ResultSet result = ps.executeQuery("SELECT * FROM employee");
                     while(result.next()){
                     idEmployee++;
                     }
                     ps.setObject(1,(idEmployee));
                     ps.setString(2, fname);
                     ps.setString(3, email);
                     ps.setString(4, pass1);
                     ps.setString(5, phone);
                     ps.setString(6, age);
                     ps.setString(7, gender);
                     
                    if(ps.executeUpdate() != 0){
                        
                             Employee E= new Employee(fname,email,pass1,phone,age,gender,idEmployee);
                             UL.addEmpList(E);
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

public void Verify_Login(String email, String password){
        if(checkUsername_Login(email)){
            PreparedStatement st;
            ResultSet rs;
            String query = "SELECT * FROM employee WHERE email = ? AND password =? ";
            try {
                
                st = My_CNX.getConnection().prepareStatement(query);
                st.setString(1, email);
                st.setString(2, password);
                rs = st.executeQuery();
                if(rs.next())
                {
                    new Interface_employee(UL).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "password Doesn't Match, Try new password","Try new password",2);
                    new Login_form_employee(UL).setVisible(true);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        if(!checkUsername_Login(email)){
            JOptionPane.showMessageDialog(null, "Email Doesn't Match, Try new email or register","Try new email or register",2);
            new Login_form_employee(UL).setVisible(true);
        }
    }

    public void SetAppointement(String Mfull_name,String Date,String hb,String he,String clinic){
        java.sql.Date Day;
        java.sql.Time hBegin;
        java.sql.Time hEnd;
        
        String Cut ="/";
        int a,b,c;
        String Mots[] = Date.split(Cut);
        a= Integer.parseInt(Mots[0]);
        b= Integer.parseInt(Mots[1]);
        c= Integer.parseInt(Mots[2]);
        Day= new java.sql.Date(a-1900,b,c);
        
        Cut=":";
        String hBeg[]= hb.split(Cut);
        a= Integer.parseInt(hBeg[0]);
        b= Integer.parseInt(hBeg[1]);
        c= Integer.parseInt(hBeg[2]);
        hBegin= new java.sql.Time(a,b,c);
        
        String hE[]= he.split(Cut);
        a= Integer.parseInt(hE[0]);
        b= Integer.parseInt(hE[1]);
        c= Integer.parseInt(hE[2]);
        hEnd= new java.sql.Time(a,b,c);
        
        Controler_Medecin ConMed= new Controler_Medecin(UL);
        int idM= ConMed.SearchIdMed(Mfull_name);
        Appointement B= new Appointement(Day, hBegin, hEnd, idM, clinic);
        UL.addAppList(B);
        
        int idRendezVous=0;
        String requete = "INSERT INTO rendezvous (idRendezVous,jour,heureDebut,HeureFin,disponible,idDocteur)";
        requete+="VALUES  (?,?,?,?,?,?)";
        try {
            PreparedStatement st =My_CNX.getConnection().prepareStatement(requete);
            ResultSet result = st.executeQuery("SELECT * FROM rendezvous");
            while(result.next()){
                idRendezVous++;
            }
            st.setObject(1,idRendezVous);
            st.setObject(2,B.getDay());
            st.setObject(3,B.getBegin());
            st.setObject(4,B.getEnd());
            st.setObject(5,0);
            st.setObject(6,B.getIdMed());
            st.executeUpdate();
        } 
        catch (SQLException ex) {
                     Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}