int LEDpin = 5;
int LEDbrightness = 130;

void setup() {
  
}

void loop() {
  LEDbrightness = 200;
  analogWrite(LEDpin, LEDbrightness);
  delay(3000);
}
