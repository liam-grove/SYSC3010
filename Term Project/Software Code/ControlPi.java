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
     * This method inputs the optimal temperature into the database
     * @param optTemp 
     */
    public void inputOptimalCondidionTemp(Float optTemp){
        String query = "INSERT INTO optimal_conditions(Optimal_Temperature); VALUES("+optTemp+")";
        byte[] request = GetData.sendMessageToServer(query);
    }  
    
    /**
     * This method inputs the optimal humidity into the database
     * @param optHumidity 
     */
    public void inputOptimalCondidionHumidity(Float optHumidity){
        String query = "INSERT INTO optimal_conditions(Optimal_Humidity); VALUES("+optHumidity+")";
        byte[] request = GetData.sendMessageToServer(query);
    } 
    
    /**
     * This method inputs the optimal amount of time needed to water the plant into the database
     * @param waterTime 
     */
    public void inputOptimalCondidionWaterTime(Float waterTime){
        String query = "INSERT INTO optimal_conditions(Optimal_WaterTime); VALUES("+waterTime+")";
        byte[] request = GetData.sendMessageToServer(query);
    } 
    
    /**
     * This method inputs the optimal time interval before the next watering of the plant occurs into the database
     * @param timeStart
     * @param timeEnd 
     */
    public void inputOptimalConditionWaterInterval(Float timeStart, Float timeEnd){
        String query = "INSERT INTO optimal_conditions(Optimal_WaterStart,Optimal_WaterEnd); VALUES("+timeStart+","+timeEnd+")";
        byte[] request = GetData.sendMessageToServer(query); //This will be sent through the client to the server
    }
    
    /**
     * This method inputs the optimal light level into the database
     * @param lightLevel 
     */
    public void inputOptimalConditonLightLevel(int lightLevel){
        String query = "INSERT INTO optimal_conditions(Optimal_LightLevel); VALUES("+lightLevel+")";    
        byte[] request = GetData.sendMessageToServer(query);
    }
    
    public void Login(String username, String password){
        
    }
    
    /**
     * This method gets the last inputted entry that was put into the database
     * in the table collected_data
     * @return 
     */
    public String getCurrentStats(){
        Object[] data = new Object[6];
        data = GetData.getCurrentData();
        return Arrays.deepToString(data);
    }
}
