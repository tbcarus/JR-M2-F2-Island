package org.tbcarus.model.biota.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;

@Getter
@Setter
public class Goat extends Animal {

    public Goat(BiotaDto dto) {
        super(dto);
    }

}
