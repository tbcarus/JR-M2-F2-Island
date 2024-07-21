package org.tbcarus.model.biota;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Biota {

    private int weight;
    private int maxPerCell;
    private int speed;
    private int fullFood;
    private int hungerToDeath;
    private int offspring;
    private BiotaType type;

    public Biota(BiotaDto dto) {
        this.weight = dto.getWeight();
        this.maxPerCell = dto.getMaxPerCell();
        this.speed = dto.getSpeed();
        this.fullFood = dto.getFullFood();
        this.hungerToDeath = dto.getHungerToDeath();
        this.offspring = dto.getOffspring();
        this.type = dto.getType();
    }

}
