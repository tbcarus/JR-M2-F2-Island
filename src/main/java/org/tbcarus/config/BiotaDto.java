package org.tbcarus.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.model.biota.BiotaType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiotaDto {

    private int weight;
    private int maxPerCell;
    private int speed;
    private int fullFood;
    private int hungerToDeath;
    private int offspring;
    private BiotaType type;

}
