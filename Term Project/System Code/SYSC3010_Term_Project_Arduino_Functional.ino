#include <dht.h>
#include <Stepper.h>
#include <Scheduler.h>

dht DHT;
#define DHT11_PIN 7

int photocellPin = 0;                // the cell and 10K pulldown are connected to a0

int light;                           // the analog readings from the sensors
float temperature;
float humidity;

int invertedLight;                 // analog reading inverted to be used as output
int LEDpin = 5;                      // connect Red LED to pin 5 (PWM pin)
int LEDbrightness;                   // intensity of LED output
const int stepsPerRevolution = 2048; // number of steps per rotation for motor:

Stepper myStepper = Stepper(stepsPerRevolution, 8, 10, 9, 11);  // Create stepper object called 'myStepper'

String data; //data string containing sensor values to be sent via Serial

void setup(void) {
  myStepper.setSpeed(10); // Set the motor speed to 10 rpm
  Serial.begin(9600); //initialize serial monitor
  Scheduler.startLoop(loop2); //schedule second function
  Scheduler.startLoop(loop3); //schedule third function
}

//main sensor reading function
void loop(void) {
  light = analogRead(photocellPin);
  int chk = DHT.read11(DHT11_PIN);
  temperature = DHT.temperature;
  humidity = DHT.humidity;
  data = String("<" + light + "," + temperature + "," + humidity + ">");
  Serial.println(data);
  delay(10000);
}

//lighting adjustment function
void loop2(void) {
  if (light < 800){
    invertedLight = 1023 - light;   
    LEDbrightness = map(invertedLight, 0, 1023, 0, 255);  
    analogWrite(LEDpin, LEDbrightness);
  }
  yield();
}

//motor activation function
void loop3(void) {
  if (Serial.available()) {
    char c = Serial.read();
    if (c=='1'){
      myStepper.step(stepsPerRevolution);
    }
    if (c=='0'){
      myStepper.step(-stepsPerRevolution);
    }
  }
  yield();
}
