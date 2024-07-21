package org.tbcarus.model.biota.plant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;

@Getter
@Setter
public class Grass extends Plant {

    public Grass(BiotaDto dto) {
        super(dto);
    }

}
