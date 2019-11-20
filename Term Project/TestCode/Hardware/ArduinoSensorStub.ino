int light = 800;
float temperature = 27.5;
float humidity = 40.3;

void setup() {
  Serial.begin(9600);
}

void loop() {
  Serial.print("<");
  Serial.print(light);
  Serial.print(",");
  Serial.print(temperature);
  Serial.print(",");
  Serial.print(humidity);
  Serial.println(">");
  delay(3000);
}
