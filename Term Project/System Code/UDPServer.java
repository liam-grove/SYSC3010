/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gem;

import java.net.*;

class UDPServer
{
    
  
   private InetAddress DataPiAddress;
   private int DataPiPort;
   private InetAddress ControlPiAddress;
   private int ControlPiPort;
   private InetAddress AppAddress;
   private int AppPort;
   private int Port = 9876;
    
   public void main(String args[]) throws Exception
     {
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
                
                 String[] splitMessage = message.split(":");
                 
                 
                 //split incoming packet message into sections
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
                         case "dpi":
                             DataPiAddress = receivePacket.getAddress();
                             DataPiPort = receivePacket.getPort();
                             break;
                         case "cpi":
                             ControlPiAddress = receivePacket.getAddress();
                             ControlPiPort = receivePacket.getPort();
                             break;
                         case "app":
                             AppAddress = receivePacket.getAddress();
                             AppPort = receivePacket.getPort();
                             break;
                         default:
                             System.out.println("Error: incompatible source address.");
                     }
                     
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

