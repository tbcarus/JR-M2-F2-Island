package org.tbcarus.service;

import org.tbcarus.config.BiotaDto;
import org.tbcarus.config.Configs;
import org.tbcarus.model.Cell;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;
import org.tbcarus.model.biota.plant.Grass;
import org.tbcarus.util.Viewer;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class ReproducrionService {

    ThreadLocalRandom random = ThreadLocalRandom.current();
    BiotasFactory factory = new BiotasFactory();

    public void reproduce (Cell cell) {
        for (BiotaType type : BiotaType.values()) {
            long currentCount = cell.getCountByType(type);
            BiotaDto dto = Configs.getConfigs().getBiotaConfig().getConfig().get(type);
            for (Biota b : cell.getBiotaMap().get(type)) {
                if (currentCount >= b.getMaxPerCell()) {
                    break;
                }

                if (random.nextBoolean()) { // для упрощения модели это условие аналогично двум животным на больших выборках данных
                    if (random.nextInt(0, 100) <= 80) {
                        for (int i = 0; i < b.getOffspring(); i++) {
                            cell.addBiota(factory.getBiota(type, dto));
                            currentCount++;
                            Viewer.view("Животное " + b.getType() + " размножилось.", false);
                            if (currentCount >= b.getMaxPerCell()) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        Collections.shuffle(cell.getBiotaList());
    }
}
