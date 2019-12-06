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
    //server ip address 
    private String ip = "172.17.52.4"; 
    //server port 
    private final int ServerPort = 56789; 
    int t; //variable used to get the watering time interval
    
    public static void main(String[] args){
    
    }
    
    /**
     * This method is used to sends how long till the plant is watered again i.e watering 
     * time interval to the data pi.
     */
    @Override
    public void run() {
        try{
            //Selects the water time interval from optimal conditions
            String query = "SELECT Optimal_WaterTimeInterval FROM optimal_conditions";
            ResultSet rs = LinkJavaMySQL.selectQuery(query);
            
            while(rs.next()){
                t = rs.getInt("Optimal_WaterTimeInterval");
            }
            
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress ServerAddress = InetAddress.getByName(ip);
            
            //Send Boot up message to server 
            byte[] IM = new byte[50];
            String message = "cpi:ser:WATER1:"+ String.valueOf(t);
            IM = message.getBytes();
            DatagramPacket initalMessage = new DatagramPacket(IM,IM.length,ServerAddress,ServerPort);
            clientSocket.send(initalMessage);
        }
        catch(IOException e)
        {
            Logger.getLogger(UpdateWaterInterval.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (SQLException ex) {
            Logger.getLogger(UpdateWaterInterval.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateWaterInterval.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
