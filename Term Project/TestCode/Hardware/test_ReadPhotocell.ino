int photocellPin = 0;
int analogReading;

void setup() {
  Serial.begin(9600);
}

void loop() {
  analogReading = analogRead(photocellPin);
  Serial.print("Reading is: ");
  Serial.println(analogReading);
  delay(3000);

}
