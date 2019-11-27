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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalie
 */
public class ControlPiTest {
    
    public ControlPiTest() {
    }

    @Test
    public void testGetData() {
        ControlPi instance = new ControlPi();
        Object[][] data;
        data = instance.getData();
        System.out.println(Arrays.deepToString(data));
        if(data.length != 10){
            fail();
        }
    }
    
    /**
     * Test of getCurrentStats method, of class ControlPi.
     */
    @Test
    public void testGetCurrentStats() {
       ControlPi instance = new ControlPi();
        Object[] data = new Object[6]; //[natalie, 2019-07-09, 21:09:00, 38.0, 43.0, 680]

        String result = instance.getCurrentStats();
        //Expected last entry into the database 
        String name = "natalie";
        data[0] = name;
        
        String date = "2019-11-10";
        data[1] = date;

        String time = "18:05:00";
        data[2] = time;
        
        Float temp = (float)36;
        data[3] = temp;

        Float humid = (float)54;
        data[4] = humid;

        int light = 800;
        data[5] = light;

        assertEquals(Arrays.deepToString(data), result);
    }
    
    @Test
    public void testGetCurrentStatsBad() {
    
    }
    
    /**
     * Test of inputOptimalConditionTemp method, of class ControlPi.
     * @throws java.lang.Exception
     */
    @Test
    public void testInputOptimalConditionsOnTemp() {
        Float expTemp = (float)36;
        ControlPi instance = new ControlPi();
        instance.inputOptimalConditionTemp(expTemp);
        String query = "SELECT Optimal_Temperature FROM optimal_conditions WHERE Username = '"+ GetData.usr +"'";
        ResultSet rs = LinkJavaMySql.selectQuery(query);
        Float actTemp = (float) 0;
        while(rs.next()){
            Float temp = rs.getFloat("Optimal_Temperature");
            actTemp = temp;
        }
        rs.close();
        
        if(!Objects.equals(actTemp, expTemp)){
            fail("The temp test has failed");
        }
    }
    
    /**
     * Test of inputOptimalConditionHumidity method, of class ControlPi.
     * @throws java.lang.Exception
     */
    @Test
    public void testInputOptimalConditionsOnHumidity() {
        Float expHumidity = (float)30;
        ControlPi instance = new ControlPi();
        instance.inputOptimalConditionHumidity(expHumidity);
        
        String query = "SELECT * FROM optimal_conditions WHERE Username = '"+ GetData.usr +"'";
        ResultSet rs = LinkJavaMySql.selectQuery(query);
        Float actHum = (float) 0;
        while(rs.next()){
            Float hum = rs.getFloat("Optimal_Humidity");
            actHum = hum;
        }
        rs.close();
        
        if(!Objects.equals(actHum, expHumidity)){
            fail("The humidity test has failed");
        }
    }
    
    @Test
    public void testInputOptimalConditionsOnLight() {
        int lightLevel = 600;
        ControlPi instance = new ControlPi();
        instance.inputOptimalConditonLightLevel(lightLevel);
        
        String query = "SELECT * FROM optimal_conditions WHERE Username = '"+ GetData.usr +"'";
        ResultSet rs = LinkJavaMySql.selectQuery(query);
        int actLightLevel = 0;
        while(rs.next()){
            int light = rs.getInt("Optimal_LightLevel");
            actLightLevel = light;
        }
        rs.close();
        
        if(!Objects.equals(actLightLevel, lightLevel)){
            fail("The light test has failed");
        }
    }
    
    
    @Test
    public void testInputOptimalConditionsOnWaterTime() {
        int expWaterTime = 3;
        ControlPi instance = new ControlPi();
        instance.inputOptimalConditionWaterTime(expWaterTime);
        
        String query = "SELECT * FROM optimal_conditions WHERE Username = '"+ GetData.usr +"'";
        ResultSet rs = LinkJavaMySql.selectQuery(query);
        int actWaterTime = 0;
        while(rs.next()){
            int water = rs.getInt("Optimal_WaterTime");
            actWaterTime = water;
        }
        rs.close();
        
        if(!Objects.equals(actWaterTime, expWaterTime)){
            fail("The water time test has failed");
        }
    }
    
    /**
     * Test of inputOptimalConditionWaterTimeInterval method, of class ControlPi.
     * @throws java.lang.Exception
     */
    @Test
    public void testInputOptimalConditionsOnWaterTimeInterval() {
        int timeInterval = 10;
        ControlPi instance = new ControlPi();
        instance.inputOptimalConditionWaterInterval(timeInterval);
        
        String query = "SELECT * FROM optimal_conditions WHERE Username = '"+ GetData.usr +"'";
        ResultSet rs = LinkJavaMySql.selectQuery(query);
        int actTimeInterval = 0;
        while(rs.next()){
            int interval = rs.getInt("Optimal_WaterTimeInterval");
            actTimeInterval = interval;
        }
        rs.close();
        
        if(!Objects.equals(actTimeInterval, timeInterval)){
            fail("The temp test has failed");
        }
    }
    
    @Test
    public void testLoginUsernameValid() {
        GetData instance = new GetData();
        String[] expResult = new String[2];
        expResult[0] = "natalie";
        expResult[1] = "password";
        String[] result = instance.getLoginInfo();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }
    
    @Test
    public void testLoginUsernameInvalid() {
       GetData instance = new GetData();
        String[] expResult = new String[2];
        expResult[0] = "natali";
        expResult[1] = "password";
        String[] result = instance.getLoginInfo();
        if(expResult != result){
            fail();
        }
    }
    
    @Test
    public void testLoginPasswordInvalid() {
        GetData instance = new GetData();
        String[] expResult = new String[2];
        expResult[0] = "natalie";
        expResult[1] = "passwo";
        String[] result = instance.getLoginInfo();
        if(expResult != result){
            fail();
        }
    }
    
    /**
     * Test of getLoginInfo method, of class ControlPi.
     */
    @Test
    public void testGetLoginInfo() {
        GetData instance = new GetData();
        String[] expResult = new String[2];
        expResult[0] = "natalie";
        expResult[1] = "password";
        String[] result = instance.getLoginInfo();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }
}
