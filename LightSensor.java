public class LightSensor {
    
    // Private Attribute
    private Cloud cloud;

    // Constructor
    public LightSensor(Cloud _c) {
        cloud = _c;
    };

    // Check Channel
    public void checkChannel(int channel) {
        int cantidad = 0;
        for (Lamp l: cloud.getLampAtChannel(channel)) cantidad += (l.getStatus() && l.getTotalValue() > 512 ? 1 : 0);
        if (cantidad == cloud.getLampAtChannel(channel).size() && cloud.getRollerAtChannel(channel).size() > 0) closeRoller(channel);
    };

    // Close Roller
    private void closeRoller(int channel) {
        for (Roller r: cloud.getRollerAtChannel(channel))
            r.close();
    };
};