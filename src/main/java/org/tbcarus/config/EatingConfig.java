package org.tbcarus.config;

import lombok.Getter;
import lombok.Setter;
import org.tbcarus.model.biota.BiotaType;

import java.util.Map;

@Getter
@Setter
public class EatingConfig {

    Map<BiotaType, Map<BiotaType, Integer>> config;

}
