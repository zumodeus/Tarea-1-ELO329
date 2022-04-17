public class Roller extends DomoticDevice {

    // Private Attributes
    private float delta, length;
    
    // Constructor
    public Roller(float _delta, float _length, int _c) {
        super(_c);
        delta = _delta;
        length = _length;
    };
};