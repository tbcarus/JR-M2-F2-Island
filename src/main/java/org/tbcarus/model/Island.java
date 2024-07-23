package org.tbcarus.model;

import lombok.Getter;
import lombok.Setter;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class Island {

    Cell[][] cells;
    public Island(int m, int n) {
        cells = new Cell[m][n];
    }

    public Map<BiotaType, Long> getAllBiotaCount() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .flatMap(b -> b.biotaList.stream())
                .collect(Collectors.groupingBy(Biota::getType, Collectors.counting()));
    }

    public Long getBiotaCountByType(BiotaType type) {
        return getAllBiotaCount().get(type);
    }
}
