/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.*;
import View.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author brice
 */
public class Controler_Appointement {
    private UserList UL;
    public Controler_Appointement(UserList U) {
        UL=U;
    }
    public void takeAppointement(int i,int ip){
        int id=i;
        int idp=ip;
        System.out.println(i);
        try {
            String Update = "Update appointement SET disponible=?, idPatient=? WHERE idAppointement=?";
            PreparedStatement st = My_CNX.getConnection().prepareStatement(Update);
            UL.getAppList().get(id).setIdPat(idp);
            UL.getAppList().get(id).setIndiponible();
            st.setInt(1,0);
            st.setInt(2,idp);
            st.setInt(3,id);
            st.executeUpdate();
            st.close();            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
