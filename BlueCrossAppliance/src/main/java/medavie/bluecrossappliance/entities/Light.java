package medavie.bluecrossappliance.entities;

public class Light {

    private boolean state;

    public Light(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
