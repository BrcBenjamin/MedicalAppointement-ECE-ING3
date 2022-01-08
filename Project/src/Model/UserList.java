package Model;
import java.util.*;
import java.sql.*;
import View.*;
/**
 *
 * @author brice
 */
public class UserList {
    private ArrayList<Employee> EmpList;
    private ArrayList<Patient> PatList;
    private ArrayList<Medecin> MedList;
    private ArrayList<Appointement> AppList;
    
    public UserList(){
        EmpList= new ArrayList<>();
        MedList= new ArrayList<>();
        PatList= new ArrayList<>();
        AppList= new ArrayList<>();
    }
    public ArrayList<Employee> getEmpList(){
        return EmpList;
    }
    public void addEmpList(Employee E){
        EmpList.add(E);
    }
    public ArrayList<Patient> getPatList(){
        return PatList;
    }
    public void addPatList(Patient P){
        PatList.add(P);
    }
    public ArrayList<Medecin> getMedList(){
        return MedList;
    }
    public void addMedList(Medecin M){
        MedList.add(M);
    }
    public ArrayList<Appointement> getAppList(){
        return AppList;
    }
    public void addAppList(Appointement A){
        AppList.add(A);
    }
}
