package org.tbcarus.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.tbcarus.service.ConfigReader;
import org.tbcarus.util.Constants;

@Getter
@Setter
@AllArgsConstructor
public class Configs {

    private static Configs configs;

    BiotaConfig biotaConfig;
    EatingConfig eatingConfig;
    IslandConfig islandConfig;
    SimConfig simConfig;

    private Configs() {}

    public static Configs getConfigs() {
        if (configs == null) {
            configs = new Configs(ConfigReader.readConfig(Constants.BIOTA_CONFIG_FILE, BiotaConfig.class),
                    ConfigReader.readConfig(Constants.EATING_CONFIG_FILE, EatingConfig.class),
                    ConfigReader.readConfig(Constants.ISLAND_CONFIG_FILE, IslandConfig.class),
                    ConfigReader.readConfig(Constants.SIMULATION_CONFIG_FILE, SimConfig.class));
        }
        return configs;
    }

}
