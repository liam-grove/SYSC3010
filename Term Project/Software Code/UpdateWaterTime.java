package gem;

import java.io.IOException;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nirda
 */
public class UpdateWaterTime implements Runnable{
    
    //client ip address 
    private InetAddress ip;
    //server port 
    private final int ServerPort = 56789; 
    
    int t; 
    
    public static void main(String[] args)
    {}
    
    @Override
    public void run() 
    {
        try
        {
            System.out.println("in try");
            String query = "SELECT Optimal_WaterTime FROM optimal_conditions";
            
            try {
                System.out.println("in try 2");
                ResultSet rs;
                rs = LinkJavaMySQL.selectQuery(query);
                while(rs.next())
                {
                    t = rs.getInt("Optimal_WaterTime");
                    System.out.println(t);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateWaterTime.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateWaterTime.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("out of try 2");
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress ServerAddress = InetAddress.getByName("172.20.10.3");
            //Send Boot up message to server 
            byte[] IM = new byte[50];
            System.out.println(String.valueOf(t));
            String message = "cpi:ser:WATER2:"+ String.valueOf(t);
            System.out.println(message);
            IM = message.getBytes();
            System.out.println(IM);
            DatagramPacket initalMessage = new DatagramPacket(IM,IM.length,ServerAddress,ServerPort);
            clientSocket.send(initalMessage);
        }
        catch(IOException e)
        {}
    }

    
}
