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
/**
 *
 * @author Natalie
 */
public class ControlPi {
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
    
    public static Object[][] getData(){
        Object[][] data = new Object[9][6];
        try{
            String query = "SELECT Username, Date, Time, Temperature, Humidity, LightLevel FROM collected_data WHERE Username = '"+ usr +"'";
            ResultSet rs = LinkJavaMySql.selectQuery(query);

            int row = 0;
            while(rs.next()){
                String usern = rs.getString("Username");
                Date date = rs.getDate("Date");
                Time time = rs.getTime("Time");
                Float temp = rs.getFloat("Temperature");
                Float hum = rs.getFloat("Humidity");
                int light = rs.getInt("LightLevel");
                data[row][0] = usern;
                data[row][1] = date;
                data[row][2] = time;
                data[row][3] = temp;
                data[row][4] = hum;
                data[row][5] = light; 
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
     * 
     * @param user
     * @throws Exception 
     */
    public void insertUsername(String user) throws Exception{
        user = GetData.usr;
        String query = "INSERT INTO optimal_conditions (Username) VALUES ('"+ GetData.usr +"');";
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
     * This method inputs the optimal temperature into the database
     * @param optTemp 
     */
    public void inputOptimalCondidionTemp(Float optTemp){
        String query = "UPDATE optimal_conditions SET Optimal_Temperature = "+optTemp+" WHERE Username = '"+ GetData.usr +"'";
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
     */
    public void inputOptimalCondidionHumidity(Float optHumidity){
        String query = "UPDATE optimal_conditions SET Optimal_Humidity = "+optHumidity+" WHERE Username = '"+ GetData.usr +"'";
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
     * This method inputs the optimal amount of time needed to water the plant into the database
     * @param waterTime 
     */
    public void inputOptimalCondidionWaterTime(int waterTime){
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
     */
    public void inputOptimalConditionWaterInterval(int timeInterval){
        String query = "UPDATE optimal_conditions SET Optimal_WaterTimeInterval = "+timeInterval+" WHERE Username = '"+ GetData.usr +"'";
        byte[] request = GetData.sendMessageToServer(query); //This will be sent through the client to the server
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
     * This method inputs the optimal light level into the database
     * @param lightLevel 
     */
    public void inputOptimalConditonLightLevel(int lightLevel){
        String query = "UPDATE optimal_conditions SET Optimal_LightLevel = "+lightLevel+" WHERE Username = '"+GetData.usr+"'";    
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
