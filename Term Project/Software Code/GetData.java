/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

import java.sql.*;
import java.util.Arrays;

/**
 *
 * @author Natalie
 */
public class GetData {

    public static String usr = Login.getUsername();
    
    /**
     * Gets the current data of the user and displays it.
     *  
     * @param table
     * @return 
     */
    public static Object[] getCurrentData(String table){
        Object data[] = new Object[6];
        try{
            String query = "SELECT DateTime, Temperature, Humidity, LightLevel FROM "+ table +" WHERE Username = '"+ usr +"'"; 
            ResultSet rs = LinkJavaMySQL.selectQuery(query);
            
            while(rs.next()){
                String usern = rs.getString("Username");
                Date date = rs.getDate("Date");
                Time time = rs.getTime("Time");
                Float temp = rs.getFloat("Temperature");
                Float hum = rs.getFloat("Humidity");
                int light = rs.getInt("LightLevel");
                data[0] = usern;
                data[1] = date;
                data[2] = time;
                data[3] = temp;
                data[4] = hum;
                data[5] = light;    
            }
            rs.close();  
        } 
        catch (Exception e){
            System.out.println("There's an exception here!");
            System.out.println(e);
        } 
        return data;    
    }
    
    /**
     * Returns the user login information
     * @return string[]
     */
    public static String[] getLoginInfo(){
        String[] data = new String[2];
        try{
            String query = "SELECT Username,Password from login_information WHERE Username = '" + usr +"' AND Password = '" + pass +"'";
            ResultSet rs = LinkJavaMySQL.selectQuery(query);
            
            while(rs.next()){
                String user = rs.getString("Username");
                String passw = rs.getString("Password");
                data[0] = user;
                data[1] = passw;
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
}
