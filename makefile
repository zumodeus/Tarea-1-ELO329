main: Main.java Operator.java Cloud.java Lamp.java LampControl.java Roller.java RollerControl.java
	javac Main.java Operator.java Cloud.java State.java Lamp.java LampControl.java Roller.java RollerControl.java
run: Main.class
	java Main
clean:
	rm *.class *.csv
