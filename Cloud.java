// Importing Libraries
import java.util.ArrayList;

// Cloud Class
public class Cloud {

    // Private Attributes
    private ArrayList<Lamp> lamps;
    private ArrayList<Roller> rollers;
    private ArrayList<LampControl> lampsControl;
    private ArrayList<RollerControl> rollerControl;

    // Constructor
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollers = new ArrayList<Roller>();
        lampsControl = new ArrayList<LampControl>();
        rollerControl = new ArrayList<RollerControl>();
    };

    // Add Lamp Method
    public void addLamp(Lamp l) {
        l.setId(lamps.size());
        lamps.add(l);
    };

    // Add Roller Method
    public void addRoller() {};

    // Add Lamp Control Method
    public void addLampControl(LampControl lc) {
        lampsControl.add(lc);
    };

    // Add Roller Control Method
    public void addRollerControl() {}

    // Get Lamp At Channel Method
    public ArrayList<Lamp> getLampAtChannel(int channel) {
        ArrayList<Lamp> response = new ArrayList<Lamp>();
        for (int i=0; i<lamps.size(); i++)
            if (lamps.get(i).getChannel() == channel) {
                response.add(lamps.get(i));
                break;
            }
        return response;
    };

    // Get Lamp Control At Channel Method
    public boolean existsLampControl(int channel) {
        boolean response = false;
        for (int i=0; i<lampsControl.size(); i++){
            if (lampsControl.get(i).getChannel() == channel) {
                response = true;
                break;
            }}
        return response;
    };

    // Change Lamp Power State Method
    public void changeLampPowerState(int channel) {
        if (existsLampControl(channel))
            for (int i=0; i<lamps.size(); i++)
                if (lamps.get(i).getChannel() == channel)
                    lamps.get(i).changePowerState();
    };

    // Change Lamp Value Intensity
    public void changeLampValueIntensity(int channel, String color, String operator) {
        ArrayList<Lamp> lamparas = getLampAtChannel(channel);
        if (lamparas.size() > 0 && existsLampControl(channel))
            for (int i=0; i<lamparas.size(); i++)
                lamparas.get(i).changeValueIntensity(color, operator);
    };

    // Get Headers Method
    public String getHeaders() {
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    };

    // Get State Method
    public String getState() {
        String state = "";
        for (Lamp l: lamps)
            state += l.toString();
        return state;
    };
};
