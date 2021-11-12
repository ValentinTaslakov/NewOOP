package TrafficLights;

public enum Lights {
    RED (0),
    GREEN (1),
    YELLOW (2);

    private int index;

    Lights(int index){
        this.index = index;
    }
}
