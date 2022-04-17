// Class Lampara
public class Lamp extends DomoticDevice {

    // Private Attributes
    private short r, g, b;
    private State state;

    // Constructor
    public Lamp(int _c) {
        super(_c);
        r = g = b = 255;
    };

    // Change Power State Method
    public void changePowerState() {
        state = State.ON == state ? State.OFF : State.ON;
    };

    // Change Value Intensity Method
    public void changeValueIntensity(String _c, String _d) {
        int auxiliar = !_c.equals("R") ? (_c.equals("G") ? g : b) : r;
        if (_d.equals("D"))
            if (auxiliar-- >= 0)
                if (_c.equals("R")) r -= 1;
                else if (_c.equals("G")) g -= 1;
                else b -= 1;
        else
            if (auxiliar++ <= 255)
                if (_c.equals("R")) r += 1;
                else if (_c.equals("G")) g += 1;
                else b += 1;
    };

    // Get Header Method
    public String getHeader() {
        return  String.format("%-4s", "L" + id + "R") + "\t" +
                String.format("%-4s", "L" + id + "G") + "\t" +
                String.format("%-4s", "L" + id + "B") + "\t";
    };

    // To String Method
    public String toString() {
        if (state==State.ON)
            return  "" + 
                    String.format("%-4s", r) + 
                    "\t" + 
                    String.format("%-4s", g) + 
                    "\t" + 
                    String.format("%-4s", b) + 
                    "\t";
        else
            return  "0   \t0   \t0   \t";
    };
}
