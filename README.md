# SYSC3010 Project Setup Guide
 Shared files for SYSC3010
 
 All project code is stored in the SYSC3010/Term Project/ directory. Inside that directory, there will be 3 folders and a ZIP file: Software Code, System Code, Test Code, and GEMapp.zip. The Software Code directory contains all the files required for the Control Pi. The System Code directory contains all the files required for the Server, Data Pi, and Arduino. The Test Code directory contains files used for testing the system, primarily related to hardware testing with the Arduino. The GEMapp.zip folder contains a copy of the Android Studio project required to run the Monitoring App.

Setup Procedures:

For the Data Pi:

   - First download the GEM_Data_Pi.py Python file from the repository and place it on the desktop. 

   - Download the Timeloop python module using ‘pip install timeloop’ in the terminal, then navigate to the Python3 dist-packages directory and copy the downloaded module to desktop. 

   - To run the Pi in headless mode, go to the Raspberry Pi Preferences, Interface tab, and enable SSH. Using ‘hostname -I’ in the terminal, take note of the Pi’s IP address. Then connect to the Pi from another computer using SSH by typing ssh @”Pi’s IP” in the CMD window. Enter the Pi’s password (“raspberry” by default”). Once connected to the Pi, the user must simply navigate to the Desktop directory using ‘cd ~/Desktop/’, then enter ‘python GEM_Data_Pi.py’ to run the file.

   - To run the Pi in standalone mode, simply use connected interface devices to access the terminal, navigate to the Desktop directory and run the file using the process in Step 3.

For the Control Pi:
   
   Note: This project is best to be set up using NetBeans 8.0 and later.

   - Download mysql-connector-java-8.0.18.jar file.

   - Download the Oracle JDK 8(jdk-8u231-linux-arm32-vfp-hflt.tar.gz or jdk-8u231-linux-arm64-vfp-hflt.tar.gz ) file and install it
(Watch the following youtube video to install this as it shows how to do it properly: youtube.com/watch?v=rrwRSAU_Zgl. If link does not work, search up ‘Install Oracle JDK 8 on Raspberry Pi Andr.oid Eric’)

   - Make sure the java version on the Control Pi is the correct version(java version '1.8.0' or any matching this format including  1.8.0)

   - Download all the files in the SYSC3010/Term Project/Software Code/Github directory and add them to a Java project.

   - Add the downloaded mysql-connector-java-8.0.18.jar file to the java project library.

   - Change the IP addresses in the LinkJavaMySQL.java file to the current database IP address. 



Setting up the server:
 - To set up the server, download the GEM_UDP_Server.java file under the System Code folder

 - Simply run it in an IDE (preferably Netbeans)

 - The IP addresses and ports were hardcoded for a personal laptop and so will have to be changed manually. 


NOTE: All IP addresses need to be configured to the user’s specific WLAN in the following files:

- Control Pi: UDPClient.java, LinkJavaMySQL.java, UpdateWaterTime.java, UpdateWaterTimeInterval.java

- Server Computer: GEM_UDP_Server.java

- Data Pi: GEM_Data_Pi.py


Run Sequence:

1. Start up the server

2. Run the Control Pi project.

3. Create an account if this is the first use of the system. If existing user, skip to step 5.

4. Input optimal conditions.

5. Log into the system.

6. Run the Data Pi file.


 If the user wants to change their optimal conditions:
 
- Click the change optimal conditions button.

- A new window will pop up where the user may change optimal conditions.



 If the user wants to view a report:
 
- Click the create a report button.

- Click the display button. 


