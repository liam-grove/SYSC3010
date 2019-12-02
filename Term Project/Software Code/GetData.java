/*
 * Copyright (C) 2019 Natalie
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package controlpi;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Natalie
 */
public class GetData {

    public static String usr = "natalie";
    public static String pass = "password";
    
    /**
     * Gets the current data of the user and displays it.
     *  
     * @param table
     * @return 
     */
    public static Object[] getCurrentData(String table){
        Object data[] = new Object[6];
        try{
            String query = "SELECT Username, Date, Time, Temperature, Humidity, LightLevel FROM "+ table +" WHERE Username = '"+ usr +"'"; 
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            
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
     * 
     * @return string[]
     */
    public static String[] getLoginInfo(){
        String[] data = new String[2];
        try{
            String query = "SELECT Username,Password from login_information WHERE Username = '" + usr +"' AND Password = '" + pass +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            
            while(rs.next()){
                String user = rs.getString("Username");
                String passw = rs.getString("Password");
                data[0] = user;
                data[1] = passw;
            }
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
   /**
    * 
    * @param args
    * @throws Exception 
    */
    public static void main(String[] args) throws Exception{
        //Scanner scanner = new Scanner(System.in);
        //Scanner user = new Scanner(System.in);
        //System.out.println("Enter username");
        String username = "natalie";
            
        //Scanner pass_word = new Scanner(System.in);
        //System.out.println("Enter password");
        String password = "password";
        
        usr = username;
        pass = password;
        //Currently suing this to simulate how the method works
        //To be connected with other classes
        getCurrentData("collected_data");
        getLoginInfo();
    }
  
    /**
     * This method is used to send the queries for the database to the server 
     * @param query
     * @return 
     */
    public static byte[] sendMessageToServer(String query){
        String source = "cpi"; //The source is the control pi
        String destination = "dtb"; //The destination is the database 
        String q = query; //The query the database needs to process
        String message = source + destination + q;
        byte[] b = message.getBytes();
        return b;
    }
    
    /**
     * 
     * @param message
     * @return 
     */
    public static String receiveMessageFromServer(byte[] message){
        //convert the message to string first
        String str = new String(message, StandardCharsets.UTF_8);
        return str;
    }
}
