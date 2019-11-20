int analogReading = 800;
int invertedReading;
int LEDbrightness;

void setup() {
  Serial.begin(9600);

}

void loop() {
  invertedReading = 1023 - analogReading;
  LEDbrightness = map(invertedReading, 0, 1023, 0, 255);
  Serial.print("Processed reading is: ");
  Serial.println(LEDbrightness);
  delay(3000);

}
