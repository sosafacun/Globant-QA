package entities;

public class Chain {

    private String chain;
    private int longitude;

    public Chain(String chain, int longitude) {
        this.chain = chain;
        this.longitude = longitude;
    }

    public Chain() {
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
