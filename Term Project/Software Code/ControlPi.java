/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * This class is used to create the user interface that allows the user to
 * to request for data and access the database
 * 
 */
package controlpi;

import static controlpi.GetData.usr;
import java.sql.*;
import java.util.Arrays;
/**
 *
 * @author Natalie
 */
public class ControlPi {
    /**
     * This method returns the last watering time(the time in which the water was turned off) 
     * @return waterTime
     */
    public static Time getLastWaterTime(){
        Time waterTime = null;
        try{
            String query = "SELECT Time_off FROM water_system WHERE Username = '"+ GetData.usr +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            while(rs.next()){
                waterTime = rs.getTime("Time_off");
            }
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return waterTime;
    }
    
    /**
     * This method returns the current temperature of the greenhouse
     * @return temp
     */
    public static float getCurrentTemp(){
        float temp = 0;
        try{
            String query = "SELECT Temperature FROM collected_data WHERE Username = '"+ GetData.usr +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            while(rs.next()){
                temp = rs.getFloat("Temperature");
            }
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }
    
    /**
     * This method returns the current humidity in the greenhouse
     * @return 
     */
    public static float getCurrentHum(){
        float hum = 0;
        try{
            String query = "SELECT Humidity FROM collected_data WHERE Username = '"+ GetData.usr +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            while(rs.next()){
                hum = rs.getFloat("Humidity");
            }
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return hum;
    }
    
    /**
     * This returns how long the UVlight has been turned on 
     * @return 
     */
    public static int getCurrentLightLevel(){
        int light = 0;
        try{
            String query = "SELECT Hours_ON FROM lighting_system WHERE Username = '"+ usr +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);
            while(rs.next()){
                light = rs.getInt("Hours_ON");
            }
            rs.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return light;
    }
    
    /**
     * This method gets the last 10 data inputs into the system
     * @return 
     */
    public static Object[][] getData(){
        Object[][] data = new Object[10][4];
        try{
            //SELECT * FROM collected_data Where Username = 'natalie' ORDER BY id DESC LIMIT 10 ;
            String query = "SELECT DateTime, Temperature, Humidity, LightLevel FROM collected_data WHERE Username = '"+ GetData.usr +"' ORDER BY id DESC LIMIT 10";
            ResultSet rs = LinkJavaMySql.selectQuery(query);

            int row = 0;
            while(rs.next()){
                Date date = rs.getTimestamp("DateTime");
                Float temp = rs.getFloat("Temperature");
                Float hum = rs.getFloat("Humidity");
                int light = rs.getInt("LightLevel");
                data[row][0] = date;
                data[row][1] = temp;
                data[row][2] = hum;
                data[row][3] = light; 
                row++;
            }
            rs.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
    /**
     * Gets the current data of the user and displays it.
     *  
     * @param table
     * @return 
     */
    public static Object[] getCurrentData(String table){
        Object data[] = GetData.getCurrentData(table);
        return data;
    }
    
    /**
     * Gets the information required for the user's Login
     * @return string[]
     */
    public static String[] getLoginInfo(){
        String[] login = GetData.getLoginInfo();
        return login;
    }
    
    /**
     * 
     * @param user
     * @throws Exception 
     */
    public void insertUsername(String user) throws Exception{
        user = GetData.usr;
        String query = "INSERT INTO optimal_conditions (Username) VALUES ('"+ GetData.usr +"');";
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully inserted into the database";
            System.out.println(message);
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    }
    
    /**
     * This method inputs the optimal temperature into the database
     * @param optTemp 
     * @throws java.lang.Exception 
     */
    public void inputOptimalConditionTemp(Float optTemp) throws Exception{
        String query = "UPDATE optimal_conditions SET Optimal_Temperature = "+ optTemp +" WHERE Username = '"+ GetData.usr +"'";
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully intserted into the database";
            System.out.println(message);
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    }  
    
    /**
     * This method inputs the optimal humidity into the database
     * @param optHumidity 
     * @throws java.lang.Exception 
     */
    public void inputOptimalConditionHumidity(Float optHumidity) throws Exception{
        String query = "UPDATE optimal_conditions SET Optimal_Humidity = "+optHumidity+" WHERE Username = '"+ GetData.usr +"'";
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully inserted into the database";
            System.out.println(message);
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    } 
    
    /**
     * This method inputs the optimal amount of time needed to water the plant into the database
     * @param waterTime 
     * @throws java.lang.Exception 
     */
    public void inputOptimalConditionWaterTime(int waterTime) throws Exception{
        String query = "UPDATE optimal_conditions SET Optimal_WaterTime ="+waterTime+" WHERE Username = '"+ GetData.usr +"'";
        byte[] request = GetData.sendMessageToServer(query);
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully intserted into the database";
            System.out.println(message);
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    } 
    
    /**
     * This method inputs the optimal time interval before the next watering of the plant occurs into the database
     * @param timeInterval
     * @throws java.lang.Exception 
     */
    public void inputOptimalConditionWaterInterval(int timeInterval) throws Exception{
        String query = "UPDATE optimal_conditions SET Optimal_WaterTimeInterval = "+timeInterval+" WHERE Username = '"+ GetData.usr +"'";
        byte[] request = GetData.sendMessageToServer(query); //This will be sent through the client to the server
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully inserted into the database";
            System.out.println(message);
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    }
    
    /**
     * This method inputs the optimal light level into the database
     * @param lightLevel 
     * @throws java.lang.Exception 
     */
    public void inputOptimalConditonLightLevel(int lightLevel) throws Exception{
        String query = "UPDATE optimal_conditions SET Optimal_LightLevel = "+lightLevel+" WHERE Username = '"+GetData.usr+"'";    
        boolean verified = LinkJavaMySql.insertQuery(query);
        if (verified == true){
            String message = "Sucessfully inserted into the database";
            System.out.println(message);//to be changed into a notification 
        }
        else {
            throw new Exception("Failed to insert into database. Try again");
        }
    }

    /**
     * This method gets the last inputted entry that was put into the database
     * in the table collected_data
     * @return 
     */
    public String getCurrentStats(){
        Object[] data = new Object[6];
        data = GetData.getCurrentData("collected_data");
        return Arrays.deepToString(data);
    }
    
}
