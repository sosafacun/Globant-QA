package entities;

import java.util.ArrayList;

public class Game {
    private ArrayList<WaterGun> chamberList;
    private ArrayList<Player> playerList;

    public Game() {
    }

    public Game(ArrayList<WaterGun> chamberList, ArrayList<Player> playerList) {
        this.chamberList = chamberList;
        this.playerList = playerList;
    }

    public ArrayList<WaterGun> getChamberList() {
        return chamberList;
    }

    public void setChamberList(ArrayList<WaterGun> chamberList) {
        this.chamberList = chamberList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
