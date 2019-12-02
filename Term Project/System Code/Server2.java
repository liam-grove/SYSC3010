import java.io.IOException;
import java.net.*;

/**
 *
 * @author Nirda
 */
public class Server {
    
   private static InetAddress DataPiAddress;
   private static int DataPiPort;
   private static InetAddress ControlPiAddress;
   private static int ControlPiPort;
   private static InetAddress AppAddress;
   private static int AppPort;
   private static int Port = 56789;
   //private LinkJavaMySQL link;
   
   public static void main(String args[]) throws IOException, ClassNotFoundException
   {
       //initialize socket and messages
            DatagramSocket serverSocket = new DatagramSocket(Port);
            byte[] receiveData = new byte[56];
            byte[] sendData = new byte[50];
            byte[] ack = {'1',':','2',':','A', 'C', 'K',':','3'};
            
            while(true){
                 
                 //create and receive incoming packet
                 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                 System.out.println("Running...");
                 serverSocket.receive(receivePacket);
                 System.out.println("Packet received...");
                 String message = new String( receivePacket.getData());
                 System.out.println(message);
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
                     
                     System.out.println("Boot received...");
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
                 
                 //other code
                 else {
                     System.out.println("Forwarding message...");
                     //return message contents to bytearray format
                     sendData = message.getBytes();
                  
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
                                 System.out.println("Send to CPi");
                                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ControlPiAddress, ControlPiPort);
                                 System.out.println("Packet created!");
                                 serverSocket.send(sendPacket);
                                 System.out.println("Sent");
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
  
                 }
                  //send confirmation acknowledgement to source node
                    /** DatagramPacket acknowledgement = new DatagramPacket(ack, ack.length, receivePacket.getAddress(), receivePacket.getPort());
                     serverSocket.send(acknowledgement);
                     System.out.println("Ack sent...");**/
             }
   }
}
