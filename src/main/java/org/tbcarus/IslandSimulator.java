package org.tbcarus;

import org.tbcarus.config.Configs;
import org.tbcarus.model.Cell;
import org.tbcarus.model.Island;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;
import org.tbcarus.model.biota.animal.Animal;
import org.tbcarus.service.EatingService;
import org.tbcarus.service.IslandGenerator;
import org.tbcarus.service.MovementService;
import org.tbcarus.service.ReproducrionService;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandSimulator {

    Configs configs = Configs.getConfigs();
    IslandGenerator islandGenerator = new IslandGenerator();
    MovementService movementService = new MovementService();
    EatingService eatingService = new EatingService();
    ReproducrionService reproducrionService = new ReproducrionService();

    public void simulate() {
        Island island = islandGenerator.generate();

        Runnable viewTask = () -> {
            for (Map.Entry<BiotaType, Long> entry : island.getAllBiotaCount().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
        };
        ScheduledExecutorService viewExecutorService = Executors.newSingleThreadScheduledExecutor();
        viewExecutorService.scheduleWithFixedDelay(viewTask, 0, 5, TimeUnit.SECONDS);

        ScheduledExecutorService actionExecutorService = Executors.newScheduledThreadPool(Math.max(Runtime.getRuntime().availableProcessors() / 2, 2));
        for (Cell[] cells : island.getCells()) {
            Runnable actionTask = () -> {
                for (Cell cell : cells) {
                    for (Biota biota : cell.getBiotaList()) {
                        if (biota instanceof Animal animal) {
                            movementService.move(island, cell, animal);
                            eatingService.eating(cell, animal);
                        }
                    }
                    reproducrionService.reproduce(cell);
                }
            };
            actionExecutorService.scheduleWithFixedDelay(actionTask, 0, 1, TimeUnit.SECONDS);
        }
    }
}
