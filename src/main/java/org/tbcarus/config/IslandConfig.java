package org.tbcarus.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IslandConfig {
    int x, y;

    public IslandConfig(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
