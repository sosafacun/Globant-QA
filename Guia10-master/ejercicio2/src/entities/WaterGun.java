package entities;

public class WaterGun {
    private int currentChamber;
    private boolean isLoaded;

    public WaterGun(int currentChamber, boolean isLoaded) {
        this.currentChamber = currentChamber;
        this.isLoaded = isLoaded;
    }

    public int getCurrentChamber() {
        return currentChamber;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

}
