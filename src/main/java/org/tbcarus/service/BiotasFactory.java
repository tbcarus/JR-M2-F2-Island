package org.tbcarus.service;

import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;
import org.tbcarus.model.biota.animal.*;
import org.tbcarus.model.biota.plant.Grass;

public class BiotasFactory {
    public Biota getBiota(BiotaType type, BiotaDto dto) {
        switch (type) {
            case WOLF -> {
                return new Wolf(dto);
            }
            case BOA -> {
                return new Boa(dto);
            }
            case FOX -> {
                return new Fox(dto);
            }
            case BEAR -> {
                return new Bear(dto);
            }
            case EAGLE -> {
                return new Eagle(dto);
            }
            case HORSE -> {
                return new Horse(dto);
            }
            case DEER -> {
                return new Deer(dto);
            }
            case RABBIT -> {
                return new Rabbit(dto);
            }
            case GOAT -> {
                return new Goat(dto);
            }
            case MOUSE -> {
                return new Mouse(dto);
            }
            case SHEEP -> {
                return new Sheep(dto);
            }
            case BOAR -> {
                return new Boar(dto);
            }
            case BUFFALO -> {
                return new Buffalo(dto);
            }
            case DUCK -> {
                return new Duck(dto);
            }
            case CATERPILLAR -> {
                return new Caterpillar(dto);
            }
            case GRASS -> {
                return new Grass(dto);
            }
        }
        return null;
    }
}
