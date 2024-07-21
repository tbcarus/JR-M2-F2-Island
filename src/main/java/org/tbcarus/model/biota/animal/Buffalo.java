package org.tbcarus.model.biota.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.config.BiotaDto;
import org.tbcarus.model.biota.Biota;

@Getter
@Setter
public class Buffalo extends Animal {

    public Buffalo(BiotaDto dto) {
        super(dto);
    }

}
