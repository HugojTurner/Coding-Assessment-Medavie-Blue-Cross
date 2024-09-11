package medavie.bluecrossappliance.entities;

public class AirConditioner {

    private boolean state;

    public AirConditioner(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
