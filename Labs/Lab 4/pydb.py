#!/usr/bin/evn python3
import sqlite3
#connect to database file
id = 1;
dbconnect = sqlite3.connect("my.db");
dbconnect.row_factory = sqlite3.Row;
cursor = dbconnect.cursor();
cursor.execute('CREATE TABLE sensor2 (sensorID INTEGER, type TEXT, zone TEXT)');
cursor.execute('''insert into sensor values (6, 2.1, 145, '2013-10-09', '14:55:05')''');
cursor.execute('''insert into sensor2 values (1 ,'door', 'kitchen')''');
cursor.execute('''insert into sensor2 values(2, 'temperature', 'kitchen')''');
cursor.execute('''insert into sensor2 values(3, 'door', 'garage')''');
cursor.execute('''insert into sensor2 values(4, 'motion', 'garage')''');
cursor.execute('''insert into sensor2 values(5, 'temperature', 'garage')''');
dbconnect.commit();
cursor.execute('SELECT * FROM sensor');
for row in cursor:
	print (row['id'], row['temperature'], row['pressure'], row['currentdate'], row['currenttime']);
cursor.execute('SELECT * FROM sensor2 WHERE zone="kitchen"');
for row in cursor:
	print (row['sensorID'], row['type'], row['zone']);
cursor.execute('SELECT * FROM sensor2 WHERE type="door"');
for row in cursor:
	print (row['sensorID'], row['type'], row['zone']);
dbconnect.close();

