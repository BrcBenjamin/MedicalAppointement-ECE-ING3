/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
import java.sql.*;
/**
 *
 * @author brice
 */
public class Appointement {
    
    private java.sql.Date Day;
    private java.sql.Time hBegin;
    private java.sql.Time hEnd;
    private int idMedecin=-1;
    private int idPatient=-1;
    private int disponible=0;
    private String Clinics;
    
    public Appointement(int y,int m,int d,int hb,int mb,int he,int me,String c){
        Day= new java.sql.Date(y-1900,m,d);
        hBegin= new java.sql.Time(hb, mb,0);
        hEnd= new java.sql.Time(he, me,0);
        idMedecin=me;
        Clinics=c;
        disponible=1;
    }
    public Appointement(java.sql.Date date,java.sql.Time beg,java.sql.Time end,int idm,int idP,String c,int dispo){
        Day=date;
        hBegin=beg;
        hEnd=end;
        idMedecin=idm;
        idPatient=idP;
        Clinics=c;
        disponible=dispo;
    }
    public Appointement(java.sql.Date date,java.sql.Time beg,java.sql.Time end,int idm,String c){
        Day=date;
        hBegin=beg;
        hEnd=end;
        idMedecin=idm;
        Clinics=c;
        disponible=1;
    }
    
    public java.sql.Date getDay(){
        return Day;
    }
    public java.sql.Time getBegin(){
        return hBegin;
    }
    public java.sql.Time getEnd(){
        return hEnd;
    }
    public String toString(){
        String s= getBegin().toString()+" to "+getEnd().toString();
        return s;
    }
    public String toFullString(){
        String s= getDay() +" "+ getBegin().toString()+" to "+getEnd().toString();
        return s;
    }
    public int getIdMed(){
        return idMedecin;
    }
    public void setIdMed(int i){
        idMedecin=i;
    }
    public int getIdPat(){
        return idPatient;
    }
    public void setIdPat(int i){
        idPatient=i;
    }
    public int getDisponible(){
        return disponible;
    }
    public void setIndiponible(){
        disponible=1;
    }
    public String getClinic(){
        return Clinics;
    }
}
