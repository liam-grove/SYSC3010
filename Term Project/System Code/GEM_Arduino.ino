#include <Arduino.h>

#include <dht.h>
#include <Stepper.h>

dht DHT;
#define DHT11_PIN 7

int photocellPin = 0;                // the cell and 10K pulldown are connected to a0
int LEDpin = 5;                      // connect Red LED to pin 5 (PWM pin)

int light;                           // the analog readings from the sensors
float temperature;
float humidity;

long intervalSensors = 10000;
long intervalMotor = 15000;
long intervalLight = 5000;
unsigned long previousMillisSensors = 0;
unsigned long previousMillisMotor = 0;
unsigned long previousMillisLight = 0;

int invertedLight;                 // analog reading inverted to be used as output
int LEDbrightness;                   // intensity of LED output
const int stepsPerRevolution = 2048; // number of steps per rotation for motor:

Stepper myStepper = Stepper(stepsPerRevolution, 8, 10, 9, 11);  // Create stepper object called 'myStepper'

String data; //data string containing sensor values to be sent via Serial

void setup(void) {
  myStepper.setSpeed(15); // Set the motor speed to 15 rpm
  Serial.begin(9600); //initialize serial monitor
}

//main sensor reading function
void loop(void) {
  
  unsigned long currentMillis = millis();
  if(currentMillis - previousMillisSensors >= intervalSensors){
    light = analogRead(photocellPin);
    int chk = DHT.read11(DHT11_PIN);
    temperature = DHT.temperature;
    humidity = DHT.humidity;
    //Serial.println(light);
    String lightString = String(light, DEC);
    String tempString = String(temperature, 3);
    String humString = String(humidity, 3);
    String data = String('<');
    data.concat(lightString);
    data.concat(',');
    data.concat(tempString);
    data.concat(',');
    data.concat(humString);
    data.concat('>');
    Serial.println(data);
    previousMillisSensors = currentMillis;
  }

  //Lighting adjustment
  if(currentMillis - previousMillisLight >= intervalLight){
    if (light < 750){
      invertedLight = 1023 - light;   
      LEDbrightness = map(invertedLight, 0, 1023, 0, 255);  
      analogWrite(LEDpin, LEDbrightness);
    }
    else{
      analogWrite(LEDpin, 0);
    }
    //Serial.println("Adjusting light...");
    previousMillisLight = currentMillis;
  }
  
  //Motor adjustment based on Serial input
  if (Serial.available()) {
    char c = Serial.read();
    if (c=='1'){
      myStepper.step(stepsPerRevolution);
    }
    if (c=='0'){
      myStepper.step(-stepsPerRevolution);
    }
    //Serial.println("Motor active...");
  }
}
