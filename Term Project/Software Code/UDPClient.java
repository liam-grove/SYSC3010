package gem;

import java.net.*;
import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author Nirda
 */
public class UDPClient implements Runnable{
    //server ip address 
    private String ip = "172.17.52.4";
    //server port 
    private final int ServerPort = 56789; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
    }
    
    /**
     * This receives messages from the data pi through the server. These 
     * messages contain the current condition of the greenhouse.
     */
    @Override
    public void run() {
        try{
            InetAddress ServerAddress = InetAddress.getByName(ip);
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
        
            while(true){
                //Create and receive incoming packet
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String incomingMessage = new String(receivePacket.getData());

                String[] splitMessage = incomingMessage.split(":");
                String code = splitMessage[2]; //put the coded word sent into an array
                String data = splitMessage[3]; //the data sent by the data pi is here

                System.out.println("data: " + data);
                //check if incoming packet is acknowledgement
                if (code.equals(ack.toString())){ 
                    //confirmation of acknowledgement
                }
                //otherwise it is going to be a automatic update for current stats 
                else{
                    String[] dataValues = data.split(",");
                    String light = dataValues[0].replace("<", "");
                    String temp = dataValues[1];
                    String humidity = dataValues[2].replace(">","");
                    
                    String humidtyStr = humidity.substring(0,humidity.length()-1);

                    float t = Float.valueOf(temp);
                    float h = Float.valueOf(humidtyStr);
                    int l = Integer.valueOf(light);

                    Date date = new Date();
                    long t1 = date.getTime();

                    Timestamp time = new Timestamp(t1);
                    inputCurrentCondition(t, time,h,l);

                    MainWindow.updateCurrent(t,h,l);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * This method is used to insert current conditions sent from the data pi into the database
     * the database
     * @param optTemp
     * @param time
     * @param optHumidity
     * @param lightLevel 
     */
    public void inputCurrentCondition(Float optTemp, Timestamp time,Float optHumidity, int lightLevel ){
        String user = Login.getUsername(); //Gets the user's username 
        try {
            String query = "INSERT INTO collected_data(Username, Temperature, DateTime,Humidity,LightLevel) VALUES('"+ user +"','"+optTemp+ "','" + time +"','"+ optHumidity +"','"+ lightLevel +"');";
            LinkJavaMySQL.insertQuery(query);
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Exception: " + ex);
        }
    }  
}  
