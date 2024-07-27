package org.tbcarus.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimConfig {
    int stepChance;
    int nMeetingBiotasPerStep;
    int reproduceChance;

}
