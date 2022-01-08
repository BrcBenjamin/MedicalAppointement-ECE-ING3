package Controller;

import Model.*;
import java.util.*;
import java.sql.*;
import View.*;
import DAO.*;

/**
 *
 * @author brice
 */
public class InitialisationUserList {
    
    private UserList UL;
    
    public InitialisationUserList(){
        UL=new UserList();
            try {
                Statement st = My_CNX.getConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM employee ");
                while(rs.next()){
                    String name= rs.getString("full_name");
                    String email= rs.getString("email");
                    String password= rs.getString("password");
                    String age= rs.getString("age");
                    String phone= rs.getString("phone");
                    String gender= rs.getString("gender");
                    int id= rs.getInt("idEmployee");
                    Employee E= new Employee(name,email,password,phone,age,gender,id);
                    UL.addEmpList(E);
                }
            }
            catch (SQLException ex) {
            }
            try {
                Statement st = My_CNX.getConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM patient ");
                while(rs.next()){
                    String name= rs.getString("full_name");
                    String email= rs.getString("email");
                    String password= rs.getString("password");
                    String age= rs.getString("age");
                    String phone= rs.getString("phone");
                    String gender= rs.getString("gender");
                    int id= rs.getInt("idPatient");
                    Patient P= new Patient(name,email,password,phone,age,gender,id);
                    UL.addPatList(P);
                }
            }
            catch (SQLException ex) {
            }
            try {
                Statement st = My_CNX.getConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM medecin ");
                while(rs.next()){
                    String name= rs.getString("full_name");
                    String email= rs.getString("email");
                    String specialization= rs.getString("specialization");
                    String age= rs.getString("age");
                    String phone= rs.getString("phone");
                    String gender= rs.getString("gender");
                    int id= rs.getInt("idMedecin");
                    Medecin M= new Medecin(name,email,specialization,phone,age,gender,id);
                    UL.addMedList(M);
                }
            }
            catch (SQLException ex) {
            }
            try {
                Statement st = My_CNX.getConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM appointement ");
                while(rs.next()){
                    int idA= rs.getInt("idAppointement");
                    java.sql.Date Day= rs.getDate("jour");
                    java.sql.Time begin= rs.getTime("heureDebut");
                    java.sql.Time end= rs.getTime("heureFin");
                    int idM= rs.getInt("idMedecin");
                    int idP= rs.getInt("idPatient");
                    int disponible= rs.getInt("disponible");
                    String clinics=rs.getString("clinics");
                    Appointement A= new Appointement(Day, begin, end, idM, idP,clinics,disponible);
                    UL.addAppList(A);
                }
            }
            catch (SQLException ex) {
            }
    }
    public UserList getUL(){
        return UL;
    }
}
