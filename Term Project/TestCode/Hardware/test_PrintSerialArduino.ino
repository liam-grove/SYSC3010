int analogReading = 800;

void setup() {
  Serial.begin(9600);

}

void loop() {
  Serial.print("<");
  Serial.print(analogReading);
  Serial.println(">");
  delay(3000);
}
