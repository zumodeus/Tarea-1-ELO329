public class Roller extends DomoticDevice {

    // Private Attributes
    private Status status;
    private final double MaxLength;
    private static double RADIUS = .04;
    private double alfa, length, lastTime;
    
    // Constructor
    public Roller(double _alfa, double _length, int _c) {
        super(_c);
        alfa = _alfa;
        status = Status.STOPPED;
        MaxLength = length = _length;
    };

    // Start Up Motor Method
    public void startUp(double _t) {
        lastTime = _t;
        status = Status.UPWARD;
    };

    // Start Down Motor Method
    public void startDown(double _t) {
        lastTime = _t;
        status = Status.DOWNWARD;
    };

    // Stop Motor Method
    public void stop() {
        lastTime = .0;
        status = Status.STOPPED;
    };

    // Advance Time Method
    public void advanceTime(double time){
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
        if (length == .0 || length == MaxLength) stop();
        else lastTime = time;
    };

    // Roller Header String
    public String getHeader(){
        return String.format("%-8s", "RS" + id) + "\t";
    };

    // Roller Data String
    public String toString(){
        return String.format("%-8s", String.valueOf(Math.round(length/MaxLength*100))) + "\t";
    };
};