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

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Natalie
 */
public class GetData {
    
    private static Connection con;
    private static Statement stat;
    private static String usr;
    private static String pass;
    
    /**
     * 
     * @return 
     */
    public static String getName(){
        return usr;
    }
    
    public static String getPassword(){
        return pass;
    }
    
    /**
     * Gets the current data of the user and displays it.
     *  
     * @return 
     */
    public static Object[] getCurrentData(){
        Object data[] = new Object[6];
        try{
            getConnection();
            
            stat = con.createStatement();
            
            String query = "SELECT Username, Date, Time, Temperature, Humidity, LightLevel FROM collected_data WHERE Username = 'natalie'"; 
            ResultSet rs = stat.executeQuery(query);
            
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
            System.out.println(Arrays.deepToString(data));
            rs.close();  
        } 
        catch (Exception e){
            System.out.println("Exception Caught: " + e);
        } 
        return data;    
    }
    /*
    public static void main(String[] args) throws Exception{
        //Scanner scanner = new Scanner(System.in);
        Scanner user = new Scanner(System.in);
        System.out.println("Enter username");
        String username = user.nextLine();
            
        Scanner pass_word = new Scanner(System.in);
        System.out.println("Enter password");
        String password = pass_word.nextLine();
        
        usr = username;
        pass = password;
        //Currently suing this to simulate how the method works
        //To be connected with other classes
        getCurrentData();
    }
  
    /**
     * This method establishes a connection to the database
     * @return
     * @throws Exception 
     */
    public static Connection getConnection() throws Exception{
        try{
            //Get the users credentials
            //Using these to verify the connection for now 

            String username = "natalie";
            String password = "password";

            String driver = "com.mysql.jdbc.Driver"; //Get the driver name and the database URL
            String DB_URL = "jdbc:mysql://localhost:3306/greenhouse";

            Class.forName(driver); //Register JDBC driver
            
            //Open a connection
            con = DriverManager.getConnection(DB_URL, username, password);
            
            //verify connection
            System.out.println("Connected Database Successfully");
            return con;
        }   
        catch (SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
    /**
     * This method is used to send the queries for the database to the server 
     * @param query
     * @return 
     */
    public static byte[] sendMessageToServer(String query){
        String source = "cpi";
        String destination = "dtb";
        String q = query;
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
        
        return null;
    }
}
