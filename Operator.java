// Importing Libraries
import java.util.Scanner;
import java.io.PrintStream;

// Operator Class
public class Operator {

    // Private Attributes
    private Cloud cloud;
    private double time=0;

    // Constructor
    public Operator(Cloud c){
        cloud = c;
    }

    // Execute Commands Method
    public void executeCommands(Scanner in, PrintStream out) {
        out.println("Time\t" + cloud.getHeaders());
        out.println(String.format("%-4s", time + "") + "\t" + cloud.getState());
        while(in.hasNextInt()){

            // Obteniendo tiempo & device
            time=in.nextInt();
            String string=in.next();

            // Obteniendo Channel & Instruction
            int channel = in.nextInt();
            String instruction = in.next();

            // Lamparas
            if (string.equals("L"))
                if (instruction.equals("R") || instruction.equals("G") || instruction.equals("B"))
                    cloud.changeLampValueIntensity(channel, instruction, in.next());
                else
                    cloud.changeLampPowerState(channel);
            
            // Cortinas
            if (string.equals("C")) {
                
            };

            // Printeo de Status
            out.println(String.format("%-4s", time + "") + "\t" + cloud.getState());
        };
    }
};