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
    
    public void inputOptimalCondidionTemp(Float optTemp){
        String query = "INSERT INTO optimal_conditions(Optimal_Temperature); VALUES("+optTemp+")";
    }  
    
    public void inputOptimalCondidionHumidity(Float optHumidity){
        String query = "INSERT INTO optimal_conditions(Optimal_Humidity); VALUES("+optHumidity+")";
    } 
    
    public void inputOptimalCondidionWaterTime(Float waterTime){
        String query = "INSERT INTO optimal_conditions(Optimal_WaterTime); VALUES("+waterTime+")";
    } 
    
    public void inputOptimalConditionWaterInterval(Float timeStart, Float timeEnd){
        String query = "INSERT INTO optimal_conditions(Optimal_WaterStart,Optimal_WaterEnd); VALUES("+timeStart+","+timeEnd+")";
    }
    
    public void inputOptimalConditonLightLevel(int lightLevel){
        String query = "INSERT INTO optimal_conditions(Optimal_LightLevel); VALUES("+lightLevel+")";    
    }
    public void Login(String username, String password){
        
    }
    
    public Object[] getCurrentStats(){
        Object[] data = new Object[6];
        data = GetData.getCurrentData();
        return data;
    }
}
