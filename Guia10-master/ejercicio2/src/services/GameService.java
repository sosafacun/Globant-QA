package services;

import entities.Player;
import entities.WaterGun;

import java.util.ArrayList;
import java.util.Scanner;

public class GameService {
    public static WaterGunService waterGunService = new WaterGunService();
    public static PlayerService playerService = new PlayerService();
    public static ArrayList<WaterGun> loadedGun = waterGunService.loadGun();
    public static ArrayList<Player> playerList = playerService.loadPlayers();
    Scanner read = new Scanner(System.in);
    public void createNewGame(){
        System.out.println("The bullet's been loaded.");
        for(int i = 0; i<loadedGun.size(); i++){
            System.out.println(playerList.get(i).getPlayerName() + "'s turn. Press any key, then 'enter' to fire!");
            waitForInput();
            if(loadedGun.get(i).isLoaded()){
                playerList.get(i).setSoaked(true);
                System.out.println(playerList.get(i).getPlayerName() + " lost. They are soaked.");
                break;
            }
            else {
                System.out.println(playerList.get(i).getPlayerName() + "'s still dry...");
            }
        }
    }

    private void waitForInput(){
        String conti = read.nextLine();
    }
}
