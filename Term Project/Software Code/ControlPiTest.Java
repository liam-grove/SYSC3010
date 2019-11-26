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
    }
    
    @Test
    public void testGetCurrentStats() {
       ControlPi instance = new ControlPi();
        Object[] data = new Object[6]; //[natalie, 2019-07-09, 21:09:00, 38.0, 43.0, 680]

        String result = instance.getCurrentStats();
        //Expected last entry into the database 
        String name = "natalie";
        data[0] = name;

        String date = "2019-10-11";
        data[1] = date;

        String time = "07:05:00";
        data[2] = time;

        Float temp = (float)43.0;
        data[3] = temp;

        Float humid = (float)60.0;
        data[4] = humid;

        int light = 890;
        data[5] = light;

        assertEquals(Arrays.deepToString(data), result);
    }
    
    @Test
    public void testGetCurrentDataBad() {
    
    }
    
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
    
    }
    
    @Test
    public void testInputOptimalConditionsOnWaterTime() {
    
    }
    
    @Test
    public void testInputOptimalConditionsOnWaterTimeInterval() {
    
    }
    
    @Test
    public void testLoginUsernameValid() {}
    
    @Test
    public void testLoginUsernameInvalid() {}
    
    @Test
    public void testLoginPasswordValid() {}
    
    @Test
    public void testLoginPasswordInvalid() {}
}
