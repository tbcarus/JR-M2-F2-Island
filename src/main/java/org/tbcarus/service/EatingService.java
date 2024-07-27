package org.tbcarus.service;

import org.tbcarus.config.BiotaConfig;
import org.tbcarus.config.Configs;
import org.tbcarus.config.EatingConfig;
import org.tbcarus.model.Cell;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.animal.Animal;
import org.tbcarus.util.Viewer;

import java.util.concurrent.ThreadLocalRandom;

public class EatingService {

    EatingConfig eatingConfig = Configs.getConfigs().getEatingConfig();
    BiotaConfig biotaConfig = Configs.getConfigs().getBiotaConfig();

    public void eating(Cell cell, Animal hunter) {
        int food = 0;
        for (int i = 0; i < 10; i++) {
            Biota prey = cell.getRandomBiota();
            if (prey != null) {
                if (isEaten(hunter, prey)) {
                    food += prey.getWeight();
                    cell.removeBiota(prey);
                    Viewer.view("Животное " + hunter.getType() + " съело добычу " + prey.getType(), false);
                }
                if (food >= hunter.getFullFood()) {
                    hunter.setHungerToDeath(biotaConfig.getConfig().get(hunter.getType()).getHungerToDeath());
                    Viewer.view("Животное " + hunter.getType() + " сыто.", false);
                    return;
                }
            }
        }
    }

    private boolean isEaten(Animal hunter, Biota prey) {
        if (hunter.getType().equals(prey.getType())) {
            return false;
        }
        Integer eatingChance = eatingConfig.getConfig().get(hunter.getType()).get(prey.getType());
        return ThreadLocalRandom.current().nextInt(0, 100) <= eatingChance;
    }

}
