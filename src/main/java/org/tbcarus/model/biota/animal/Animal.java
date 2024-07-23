package org.tbcarus.model.biota.animal;

import lombok.Getter;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;

@Getter
@Setter
public abstract class Animal extends Biota {

    private int speed;
    private int fullFood;

    public Animal(BiotaDto dto) {
        super(dto);
        this.speed = dto.getSpeed();
        this.fullFood = dto.getFullFood();
    }

}
