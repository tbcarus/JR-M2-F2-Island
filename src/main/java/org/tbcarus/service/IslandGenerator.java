package org.tbcarus.service;

import org.tbcarus.config.BiotaDto;
import org.tbcarus.config.Configs;
import org.tbcarus.model.Cell;
import org.tbcarus.model.Island;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IslandGenerator {
    int x = Configs.getConfigs().getIslandConfig().getX();
    int y = Configs.getConfigs().getIslandConfig().getY();

    public Island generate() {
        Island island = new Island(x, y);
        initIslandField(island);
        initIslandBiotas(island);

        return island;
    }

    private void initIslandField(Island island) {
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                island.getCells()[yi][xi] = new Cell(xi, yi);
            }
        }
    }

    private void initIslandBiotas(Island island) {
        BiotasFactory factory = new BiotasFactory();
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                List<Biota> list = new ArrayList<>();
                for(BiotaType type : BiotaType.values()) {
                    BiotaDto dto = Configs.getConfigs().getBiotaConfig().getConfig().get(type);
                    int maxPerCell = Configs.getConfigs().getBiotaConfig().getConfig().get(type).getMaxPerCell();
                    int randomPerCell = RandomService.getRandomService().getRandom().nextInt(0, maxPerCell);
                    for (int i = 0; i < randomPerCell; i++) {
                        list.add(factory.getBiota(type, dto));
                    }
                }
                Collections.shuffle(list);
                island.getCells()[yi][xi].getBiotaList().addAll(list);
            }
        }
    }
}
