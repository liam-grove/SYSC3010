package gem;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Nirda
 */
public class UDPClient implements Runnable
{
     //client ip address 
    private InetAddress ip;
    //server port 
    private static final int ServerPort = 56789; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        /*InetAddress ServerAddress = InetAddress.getByName("172.20.10.3");
        
        //DatagramSocket controlPiSocket;
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[56];
        byte[] sendData = new byte[50];
        //byte[] ack = {'A', 'C', 'K'};
        String ack = "ACK";
        
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
            System.out.println("here");
            clientSocket.receive(receivePacket);
            
            String incomingMessage = new String(receivePacket.getData());
            System.out.println("incoming message: " + incomingMessage);
            
            String[] splitMessage = incomingMessage.split(":");
            //System.out.println(splitMessage);
            String source = splitMessage[0];
            String destination = splitMessage[1];
            String code = splitMessage[2];
            String data = splitMessage[3];
            
            System.out.println("data: " + data);
            //System.out.println(ack.toString());
            //check if incoming packet is acknowledgement
            if (code.equals(ack.toString()))
            {
                   System.out.println("yay");  
                    //confirmation of acknowledgement
                     
            }
            //otherwise it is going to be a automatic update for current stats 
            else
            {
                String[] dataValues = data.split(",");
                String light = dataValues[0].replace("<", "");
                String temp = dataValues[1];
                String humidity = dataValues[2].replace(">","");
                
                String lightStr = light.substring(1);
                String humidtyStr = humidity.substring(0,humidity.length()-1);
                
                float t = Float.valueOf(temp);
                float h = Float.valueOf(humidtyStr);
                int l = Integer.valueOf(light);
                
                System.out.println("temp: " + t + " humidity: " + h + " light: " + l );
            
            }
        }*/
    }

    @Override
    public void run() {
        
        
        
        try{
            
        
        
        InetAddress ServerAddress = InetAddress.getByName("172.20.10.3");
        
        //DatagramSocket controlPiSocket;
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[56];
        byte[] sendData = new byte[50];
        //byte[] ack = {'A', 'C', 'K'};
        String ack = "ACK";
        
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
            System.out.println("here");
            clientSocket.receive(receivePacket);
            
            String incomingMessage = new String(receivePacket.getData());
            System.out.println("incoming message: " + incomingMessage);
            
            String[] splitMessage = incomingMessage.split(":");
            //System.out.println(splitMessage);
            String source = splitMessage[0];
            String destination = splitMessage[1];
            String code = splitMessage[2];
            String data = splitMessage[3];
            
            System.out.println("data: " + data);
            //System.out.println(ack.toString());
            //check if incoming packet is acknowledgement
            if (code.equals(ack.toString()))
            {
                   System.out.println("yay");  
                    //confirmation of acknowledgement
                     
            }
            //otherwise it is going to be a automatic update for current stats 
            else
            {
                

                String[] dataValues = data.split(",");
                String light = dataValues[0].replace("<", "");
                String temp = dataValues[1];
                String humidity = dataValues[2].replace(">","");
                
                String lightStr = light.substring(1);
                String humidtyStr = humidity.substring(0,humidity.length()-1);
                
                float t = Float.valueOf(temp);
                float h = Float.valueOf(humidtyStr);
                int l = Integer.valueOf(light);
                
                MainWindow m = new MainWindow(t,h,l);
                m.updateLabels(t, h, l);
            
                System.out.println("temp: " + t + " humidity: " + h + " light: " + l );
            
            }
        }
    }catch(Exception e)
     {
         System.out.println(e);
     }
    }
    
     
}  
