// Enum
enum LampState {
    ON,
    OFF
};

// Class Lampara
public class Lamp {

    // Private Attributes
    private int id = 0;
    private int channel;
    private short r, g, b;
    private LampState state;

    // Constructor
    public Lamp(int _c) {
        channel = _c;
        r = g = b = 255;
    };

    // Get Channel Method
    public int getChannel() {
        return channel;
    };

    // Change Power State Method
    public void changePowerState() {
        state = LampState.ON == state ? LampState.OFF : LampState.ON;
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
        return "L" + id + "R\t" + "L" + id + "G\t" + "L" + id + "B\t";
    };

    // To String Method
    public String toString() {
        if (state==LampState.ON)
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

    // Set Id Method
    public void setId(int _id) {
        id = _id;
    };
}
