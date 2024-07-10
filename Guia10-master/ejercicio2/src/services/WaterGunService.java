package services;

import entities.WaterGun;

import java.util.ArrayList;
import java.util.Random;

public class WaterGunService {
    public ArrayList<WaterGun> loadGun(){
        ArrayList<WaterGun> loadedGun = new ArrayList<>();
        Random ran = new Random();

        WaterGun chamber = new WaterGun(ran.nextInt(5-0+1), true);

        for(int i = 0; i < 6; i++){
            if(chamber.getCurrentChamber() == i){
                loadedGun.add(chamber);
            } else {
                WaterGun newChamber = new WaterGun(i, false);
                loadedGun.add(newChamber);
            }
        }

        return loadedGun;
    }
}
