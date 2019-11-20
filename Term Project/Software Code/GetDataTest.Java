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

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalie
 */
public class GetDataTest {
    
    public GetDataTest() {
    }

    /**
     * Test of getName method, of class GetData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetName() throws Exception {
        GetData instance = new GetData();
        try {
            instance.getConnection();
            String expResult = "natalie";
            String result = instance.getName();
            assertEquals(expResult, result);
        }catch (Exception e){
            System.out.println("Exception Caught: "+e);
        }
    }

    /**
     * Test of getPassword method
     */
    @Test
    public void testGetPassword() {
        GetData instance = new GetData();
        try {
            instance.getConnection();
            String expResult = "password";
            String result = instance.getPassword();
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e);
        }
    }

    /**
     * Test of getCurrentData method 
     */
    @Test
    public void testGetCurrentData(){
        GetData instance = new GetData();
        Object[] data = new Object[6]; //[natalie, 2019-07-09, 21:09:00, 38.0, 43.0, 680]
        //Object[] dataReceived = new Object[6];
        String name = "natalie";
        data[0] = name;
        
        String date = "2019-07-09";
        data[1] = date;
        
        String time = "21:09:00";
        data[2] = time;
        
        Float temp = (float)38.0;
        data[3] = temp;
        
        Float humid = (float)43.0;
        data[4] = humid;
        
        int light = 680;
        data[5] = 680;

        assertEquals(Arrays.deepToString(data), Arrays.deepToString(instance.getCurrentData()));
    }

    /**
     * Test of sendMessageToServer method
     */
    @Test
    public void testSendMessageToServer() {
        GetData instance = new GetData();
        String query = "SELECT Username, Date, Time, Temperature, Humidity, LightLevel FROM collected_data";
        byte[] expResult = query.getBytes();
        byte[] result = instance.sendMessageToServer(query);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of receiveMessageFromServer method which is testing how the control pi receives
     */
    @Test
    public void testReceiveMessageFromServer() {
        GetData instance = new GetData();
        byte[] message = null;
        String expResult = "SELECT Username, Date, Time, Temperature, Humidity, LightLevel FROM collected_data";
        String result = GetData.receiveMessageFromServer(message);
        assertEquals(expResult, result);
    }
}
