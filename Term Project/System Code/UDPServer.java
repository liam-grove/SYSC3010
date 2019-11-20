package gem;

import java.net.*;
import java.sql.ResultSet;

class UDPServer
{
    
  
   private InetAddress DataPiAddress;
   private int DataPiPort;
   private InetAddress ControlPiAddress;
   private int ControlPiPort;
   private InetAddress AppAddress;
   private int AppPort;
   private int Port = 9876;
   private LinkJavaMySQL link;
    
   public void main(String args[]) throws Exception
     {
            //initialize socket and messages
            DatagramSocket serverSocket = new DatagramSocket(Port);
            byte[] receiveData = new byte[56];
            byte[] sendData = new byte[50];
            byte[] ack = {'A', 'C', 'K'};
            
            while(true){
                 
                 //create and receive incoming packet
                 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                 serverSocket.receive(receivePacket);
                 String message = new String( receivePacket.getData());
                 
                 /**messages sent to server have format "source:destination:opcode:data"
                 where source and destination are a 3-char name (dpi, cpi, app), opcode is a 4-byte code
                 representing a specific function, and data is the remaining 40 bytes making up the core
                 of the message**
                 **/
                 
                //split incoming packet message into sections
                 String[] splitMessage = message.split(":");
                 String source = splitMessage[0];
                 String destination = splitMessage[1];
                 String code = splitMessage[2];
                 String data = splitMessage[3];
                  
                 //check if incoming packet is acknowledgement
                 if (code.equals(ack.toString())){
                     
                    //confirmation of acknowledgement
                     
                 }
                 //check if incoming packet is initial connection
                 else if (code.equals("BOOT")){
                     
                     //assign received packet data to source node
                     switch (source) {
                         case "dpi": //if source is data pi, assign origin address to data pi
                             DataPiAddress = receivePacket.getAddress();
                             DataPiPort = receivePacket.getPort();
                             break;
                         case "cpi": //if source is control pi, assign origin address to control pi
                             ControlPiAddress = receivePacket.getAddress();
                             ControlPiPort = receivePacket.getPort();
                             break;
                         case "app": //if source is app, assign origin address to app
                             AppAddress = receivePacket.getAddress();
                             AppPort = receivePacket.getPort();
                             break;
                         default: //if source does not match data pi, control pi or app, output error
                             System.out.println("Error: incompatible source address.");
                     }
                     
                 }
                 //code is to insert data to database
                 else if (code.equals("DB01")){
                     
                     link.insertQuery(data);
                     
                 }
                 //code is to select data from database
                 else if (code.equals("DB02")){
                     
                    ResultSet result = link.selectQuery(data);
                    
                     
                 }
                 //other code
                 else {
                     
                     //return message contents to bytearray format
                     sendData = code.getBytes();
                  
                     //determine destination node and send packet
                     switch (destination) {
                         case "dpi":
                             {
                                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, DataPiAddress, DataPiPort);
                                 serverSocket.send(sendPacket);
                                 break;
                             }
                         case "cpi":
                             {
                                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ControlPiAddress, ControlPiPort);
                                 serverSocket.send(sendPacket);
                                 break;
                             }
                         case "app":
                             {
                                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, AppAddress, AppPort);
                                 serverSocket.send(sendPacket);
                                 break;
                             }
                         default:
                             System.out.println("Error: incompatible destination address.");
                             continue;
                     }
                  
                     //send confirmation acknowledgement to source node
                     DatagramPacket acknowledgement = new DatagramPacket(ack, ack.length, receivePacket.getAddress(), receivePacket.getPort());
                     serverSocket.send(acknowledgement);
                     
                 }
                  
             }
     }
   
}

