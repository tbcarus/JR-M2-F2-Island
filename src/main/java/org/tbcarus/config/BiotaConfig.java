package org.tbcarus.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tbcarus.model.biota.BiotaType;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BiotaConfig {

    Map<BiotaType, BiotaDto> config;

}
