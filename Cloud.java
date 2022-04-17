// Importing Libraries
import java.util.ArrayList;

// Cloud Class
public class Cloud {

    // Private Attributes
    private ArrayList<Lamp> lamps;
    private ArrayList<Roller> rollers;
    private ArrayList<DomoticControl> lampsControl, rollersControl;

    // Constructor
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollers = new ArrayList<Roller>();
        lampsControl = new ArrayList<DomoticControl>();
        rollersControl = new ArrayList<DomoticControl>();
    };

    // Add Lamp Method
    public void addLamp(Lamp l) {
        l.setId(lamps.size());
        lamps.add(l);
    };

    // Add Roller Method
    public void addRoller(Roller r) {
        r.setId(rollers.size());
        rollers.add(r);
    };

    // Add Lamp Control Method
    public void addLampControl(DomoticControl lc) {
        lampsControl.add(lc);
    };

    // Add Roller Control Method
    public void addRollerControl(DomoticControl rc) {
        rollersControl.add(rc);
    }

    // Get Lamp At Channel Method
    public ArrayList<Lamp> getLampAtChannel(int channel) {
        ArrayList<Lamp> response = new ArrayList<Lamp>();
        for (int i=0; i<lamps.size(); i++)
            if (lamps.get(i).getChannel() == channel)
                response.add(lamps.get(i));
        return response;
    };

    // Get Roller At Channel Method
    public ArrayList<Roller> getRollerAtChannel(int channel) {
        ArrayList<Roller> response = new ArrayList<Roller>();
        for (int i=0; i<rollers.size(); i++)
            if (rollers.get(i).getChannel() == channel)
                response.add(rollers.get(i));
        return response;
    };

    // Exists Domotic Device Control At Channel Method
    public boolean existsControlAtChannel(int channel, boolean lamp) {
        boolean response = false;
        int size = lamp ? lampsControl.size() : rollers.size();
        for (int i=0; i<size; i++){
            DomoticDevice device = lamp ? lamps.get(i) : rollers.get(i);
            if (device.getChannel() == channel) {
                response = true;
                break;
            }}
        return response;
    };

    // Change Lamp Power State Method
    public void changeLampPowerState(int channel) {
        if (existsControlAtChannel(channel, true))
            for (int i=0; i<lamps.size(); i++)
                if (lamps.get(i).getChannel() == channel)
                    lamps.get(i).changePowerState();
    };

    // Change Roller Motor Status Method
    public void changeRollerMotorStatus(int channel, double time, String operator) {
        if (existsControlAtChannel(channel, false))
            for (int i=0; i<rollers.size(); i++)
                if (rollers.get(i).getChannel() == channel)
                    if (operator.equals("U")) rollers.get(i).startUp(time);
                    else if (operator.equals("D")) rollers.get(i).startDown(time);
                    else rollers.get(i).stop(time);
    }

    // Change Lamp Value Intensity
    public void changeLampValueIntensity(int channel, String color, String operator) {
        ArrayList<Lamp> lamparas = getLampAtChannel(channel);
        if (lamparas.size() > 0 && existsControlAtChannel(channel, true))
            for (int i=0; i<lamparas.size(); i++)
                lamparas.get(i).changeValueIntensity(color, operator);
    };

    // Get Headers Method
    public String getHeaders() {
        String header = "";
        for (Roller r: rollers)
            header += r.getHeader();
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    };

    // Get State Method
    public String getState(double time) {
        String state = "";
        for (Roller r: rollers)
            state += r.toString(time);
        for (Lamp l: lamps)
            state += l.toString();
        return state;
    };
};
