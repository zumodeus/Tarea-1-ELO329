main: Main.java Operator.java Cloud.java Status.java LightSensor.java DomoticDevice.java DomoticControl.java Lamp.java Roller.java
	javac Main.java Operator.java Cloud.java Status.java LightSensor.java DomoticDevice.java DomoticControl.java Lamp.java Roller.java
run: Main.class
	java Main
clean:
	rm *.class
