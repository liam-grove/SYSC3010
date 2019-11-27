package gem;

import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Nirda
 */
public class UDPClient 
{
    //client ip address 
    private InetAddress ip;
    //server port 
    private static final int ServerPort = 9876; 
    //server ip address 
    

     public static void main(String args[]) throws Exception
    {
        InetAddress ServerAddress = InetAddress.getByName("172.17.61.82");
        
        //DatagramSocket controlPiSocket;
        
        DatagramSocket clientSocket = new DatagramSocket(ServerPort);
        byte[] receiveData = new byte[56];
        byte[] sendData = new byte[50];
        byte[] ack = {'A', 'C', 'K'};
        
        //Send Boot up message to server 
        byte[] IM = new byte[50];
        String bootMessage = "cpi:ser:BOOT:test";
        IM = bootMessage.getBytes();
        DatagramPacket initalMessage = new DatagramPacket(IM,IM.length,ServerAddress,ServerPort);
        clientSocket.send(initalMessage);
        
        while(true)
        {
            //Create and receive incoming packet
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String incomingMessage = new String(receivePacket.getData());
            
            String[] splitMessage = incomingMessage.split(":");
            String source = splitMessage[0];
            String destination = splitMessage[1];
            String code = splitMessage[2];
            String data = splitMessage[3];
            
            //check if incoming packet is acknowledgement
            if (code.equals(ack.toString()))
            {
                     
                    //confirmation of acknowledgement
                     
            }
            //otherwise it is going to be a automatic update for current stats 
            else
            {
                String[] dataValues = data.split(",");
                String light = dataValues[0];
                String temp = dataValues[1];
                String humidity = dataValues[2];
                
                String lightStr = light.substring(1);
                String humidtyStr = humidity.substring(0,humidity.length()-1);
                
                float t = Float.valueOf(temp);
                float h = Float.valueOf(humidtyStr);
                int l = Integer.valueOf(light);
                
                System.out.println("temp: " + t + " humidity: " + h + " light: " + l + " .");
            
            }
        }
    }
    
}  
