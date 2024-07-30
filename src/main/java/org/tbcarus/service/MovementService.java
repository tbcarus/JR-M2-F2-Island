package org.tbcarus.service;

import org.tbcarus.config.Configs;
import org.tbcarus.config.IslandConfig;
import org.tbcarus.config.SimConfig;
import org.tbcarus.model.Cell;
import org.tbcarus.model.DirectionType;
import org.tbcarus.model.Island;
import org.tbcarus.model.biota.animal.Animal;
import org.tbcarus.util.Viewer;

import java.util.concurrent.ThreadLocalRandom;

public class MovementService {
    private final IslandConfig islandConfig = Configs.getConfigs().getIslandConfig();
    private final SimConfig simConfig = Configs.getConfigs().getSimConfig();

    public void move(Island island, Cell cell, Animal animal) {
        if (animal.getHungerToDeath() == 0) {
            cell.removeBiota(animal);
            Viewer.view("Животное " + animal.getType() + " в {"
                    + cell.getX() + "," + cell.getY() + "} умерло от голода.", false);
            return;
        }
        Cell cellTo = runToCell(island, cell, animal);
        moveAnimal(cell, cellTo, animal);
        animal.setHungerToDeath(animal.getHungerToDeath() - 1);
        Viewer.view("Животное " + animal.getType() + " переместилось из {"
                + cell.getX() + "," + cell.getY() + "} в {"
                + cellTo.getX() + "," + cellTo.getY() + "}", false);
    }

    private boolean shouldTakeStep() {
        return ThreadLocalRandom.current().nextInt(0, 100) <= simConfig.getStepChance();
    }

    private Cell runToCell(Island island, Cell cell, Animal animal) {
        Cell currentCell = cell;
        for (int i = 0; i < animal.getSpeed(); i++) {
            if (shouldTakeStep()) {
                DirectionType direction = chooseDirection();
                currentCell = doStep(island, currentCell, direction);
            }
        }
        return currentCell;
    }

    private DirectionType chooseDirection() {
        return DirectionType.values()[ThreadLocalRandom.current().nextInt(DirectionType.values().length)];
    }

    private Cell doStep(Island island, Cell cell, DirectionType direction) {
        switch (direction) {
            case UP -> {
                if (cell.getY() >= 1) {
                    return island.getCells()[cell.getY() - 1][cell.getX()];
                }
            }
            case DOWN -> {
                if (cell.getY() < islandConfig.getY() - 1) {
                    return island.getCells()[cell.getY() + 1][cell.getX()];
                }
            }
            case LEFT -> {
                if (cell.getX() >= 1) {
                    return island.getCells()[cell.getY()][cell.getX() - 1];
                }
            }
            case RIGHT -> {
                if (cell.getX() < islandConfig.getX() - 1) {
                    return island.getCells()[cell.getY()][cell.getX() + 1];
                }
            }
        }
        return cell;
    }

    private void moveAnimal(Cell cellFrom, Cell cellTo, Animal animal) {
        if (cellTo.getCountByType(animal.getType()) < animal.getHungerToDeath()) {
            cellFrom.removeBiota(animal);
            cellTo.addBiota(animal);
        }
    }
}
