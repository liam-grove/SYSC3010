import java.net.*;
import java.util.Scanner;

public class UDPSender {
    
        private final static int PACKETSIZE = 100 ;

	public static void main(String[] args) 
   {
	     // Check the arguments
	     if( args.length != 3 )
	     {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	     }
	     DatagramSocket socket = null ;
	     try
	     {
	         // Convert the arguments first, to ensure that they are valid
                 InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
                 int messageCount = Integer.parseInt( args[2] ) ;
	         socket = new DatagramSocket() ;
     
	         
                 //Auto-generate messages and wait for response
                 for(int i = 1; i <= messageCount; i++){
                     String str = "Message" + i;
                     byte [] data = str.getBytes() ;
                     DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
                     socket.send( packet ) ;
                     DatagramPacket packetReply = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	             socket.receive( packetReply ) ;
                     String received = new String(packetReply.getData(), 0, packetReply.getLength());
                     System.out.println(received);
                 }
	        		 
	         
	         System.out.println ("Closing down");
	     }
	     catch( Exception e )
	     {
	         System.out.println( e ) ;
	     }
	     finally
	     {
	         if( socket != null )
	             socket.close() ;
             }
   }
}

