package org.tbcarus;

import org.tbcarus.config.Configs;
import org.tbcarus.model.Island;
import org.tbcarus.service.IslandGenerator;

public class IslandSimulator {

    Configs configs = Configs.getConfigs();
    IslandGenerator islandGenerator = new IslandGenerator();

    public void simulate() {
        Island island = islandGenerator.generate(configs);
    }


    int x = 5;

}
