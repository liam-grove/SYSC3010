package gem;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nirda
 */
public class UpdateWaterInterval implements Runnable{
    
    //client ip address 
    private InetAddress ip;
    //server port 
    private final int ServerPort = 56789; 
    int t; 
    
    public static void main(String[] args)
    {
    
    }
    
    @Override
    public void run() {
        try
        {
            String query = "SELECT Optimal_WaterTimeInterval FROM optimal_conditions";
            ResultSet rs = LinkJavaMySQL.selectQuery(query);
            while(rs.next())
            {
                t = rs.getInt("Optimal_WaterTimeInterval");
            }
            
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress ServerAddress = InetAddress.getByName("172.20.10.3");
            //Send Boot up message to server 
            byte[] IM = new byte[50];
            String message = "cpi:ser:WATER1:"+ String.valueOf(t);
            IM = message.getBytes();
            DatagramPacket initalMessage = new DatagramPacket(IM,IM.length,ServerAddress,ServerPort);
            clientSocket.send(initalMessage);
        }
        catch(IOException e)
        {} catch (SQLException ex) {
            Logger.getLogger(UpdateWaterInterval.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateWaterInterval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
