public class Roller extends DomoticDevice {

    // Private Attributes
    private Status status;
    private final double MaxLength;
    private static double RADIUS = .04;
    private double alfa, length, lastTime = .0;
    
    // Constructor
    public Roller(double _alfa, double _length, int _c) {
        super(_c);
        length = .0;
        alfa = _alfa;
        MaxLength = _length;
        status = Status.STOPPED;
    };

    // Start Up Motor Method
    public void startUp(double _t) {
        if (lastTime != .0) advanceTime(_t);
        lastTime = _t;
        status = Status.UPWARD;
    };

    // Start Down Motor Method
    public void startDown(double _t) {
        if (lastTime != .0) advanceTime(_t);
        lastTime = _t;
        status = Status.DOWNWARD;
    };

    // Stop Motor Method
    public void stop(double _t) {
        if (_t != .0) advanceTime(_t);
        lastTime = .0;
        status = Status.STOPPED;
    };

    // Advance Time Method
    public void advanceTime(double time) {
        if (time > .0) {
            double total, increment = (time - lastTime)*alfa*RADIUS;
            switch (status) {
                case STOPPED: break;
                case DOWNWARD:
                    total = length + increment;
                    length = total <= MaxLength ? total : MaxLength;
                    break;
                case UPWARD:
                    total = length - increment;
                    length = total >= 0 ? total : 0;
                    break;
            };
            if (length == .0 || length == MaxLength) stop(.0);
            else lastTime = time;
        }
    };

    // Roller Header String
    public String getHeader() {
        return String.format("%-8s", "RS" + id) + "\t";
    };

    // Roller Data String
    public String toString(double time) {
        if (time != lastTime) advanceTime(time);
        return String.format("%-8s", String.valueOf(Math.round((length/MaxLength)*100))) + "\t";
    };
};