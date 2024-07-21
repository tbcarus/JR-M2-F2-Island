package org.tbcarus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {

    Cell[][] cells;
    public Island(int m, int n) {
        cells = new Cell[m][n];
    }

}
