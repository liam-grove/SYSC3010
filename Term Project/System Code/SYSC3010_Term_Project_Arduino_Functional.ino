#include <dht.h>
#include <Stepper.h>
dht DHT;
#define DHT11_PIN 7

int photocellPin = 0;                // the cell and 10K pulldown are connected to a0
int light;                           // the analog reading from the sensor divider
int invertedReading;                 // analog reading inverted to be used as output
int LEDpin = 5;                      // connect Red LED to pin 5 (PWM pin)
int LEDbrightness;                   // intensity of LED output
const int stepsPerRevolution = 2048; // number of steps per rotation for motor:
int state;

Stepper myStepper = Stepper(stepsPerRevolution, 8, 10, 9, 11);  // Create stepper object called 'myStepper'

const byte numChars = 32;
char receivedChars[numChars]; // an array to store received data
boolean newData = false;

void setup(void) {
  myStepper.setSpeed(5); // Set the speed to 5 rpm
  Serial.begin(9600);    // view debugging information via the Serial monitor
  state = 0;
}
 
void loop(void) {

  recvWithEndMarker(); //Receive incoming data via Serial

  //Lighting Adjustment
  light = analogRead(photocellPin); //read value from specified photocell pin 
  invertedReading = 1023 - light;   // LED gets brighter the darker it is at the sensor so must invert the reading from 0-1023 back to 1023-0
  LEDbrightness = map(invertedReading, 0, 1023, 0, 255);  //now map 0-1023 to 0-255 since thats the range analogWrite uses
  analogWrite(LEDpin, LEDbrightness);          //tell LED to output at corresponding brightness

  //DHT11 Read
  int chk = DHT.read11(DHT11_PIN);      //read value from DHT11 specified pin
  float temperature = DHT.temperature;  //assign sensor data to variables
  float humidity = DHT.humidity;

  //Print data to serial
  Serial.print("<");
  Serial.print(light);
  Serial.print(",");
  Serial.print(temperature);
  Serial.print(",");
  Serial.print(humidity);
  Serial.println(">");
  
  
  //Step Motor Adjustment
  if (receivedChars[0] == 1){
    int delayInt = atoi(&receivedChars[1]);
    myStepper.step(stepsPerRevolution);   //rotate motor clockwise
    delay(delayInt);                        //wait for desired interval
    myStepper.step(-stepsPerRevolution);   //rotate motor counterclockwise
  }
  

  //Delay Before Restart
  delay(4000);
}

void recvWithEndMarker() {
  static byte ndx = 0;  //index of receieved character array
  char endMarker = '\n'; //define end of message char
  char rc;
 
  if (Serial.available() > 0) {
     while (Serial.available() > 0 && newData == false) {
        rc = Serial.read();

        if (rc != endMarker) {  //add received char to array
          receivedChars[ndx] = rc;
          ndx++;
          if (ndx >= numChars) {
            ndx = numChars - 1;
          }
        }
        else {
            receivedChars[ndx] = '\0'; // terminate the string if end character reached
            ndx = 0;
            newData = true;
        }
     }
  }
