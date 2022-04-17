public class DomoticDevice {
    
    // Private Attributes
    protected int id = 0, channel;

    // Constructor
    public DomoticDevice(int _c) {
        channel = _c;
    }

    // Get Channel Method
    public int getChannel() {
        return channel;
    };

    // Set Id Method
    public void setId(int _id) {
        id = _id;
    };
}
