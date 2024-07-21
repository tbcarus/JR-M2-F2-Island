package org.tbcarus.model.biota.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;

@Getter
@Setter
public class Horse extends Animal {

    public Horse(BiotaDto dto) {
        super(dto);
    }

}
