package org.tbcarus.model;


import lombok.Getter;
import lombok.Setter;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Getter
@Setter
public class Cell {

    int x;
    int y;
    List<Biota> biotaList = new CopyOnWriteArrayList<>();

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void addBiota(Biota b) {
        biotaList.add(b);
    }

    public void removeBiota(Biota b) {
        biotaList.remove(b);
    }

    public Map<BiotaType, List<Biota>> getBiotaMap() {
        Map<BiotaType, List<Biota>> map = new HashMap<>();
        for (BiotaType type : BiotaType.values()) {
            List<Biota> list = biotaList.stream().filter(b -> b.getType() == type).toList();
            map.put(type, new ArrayList<>(list));
        }
        return map;
//        return biotaList.stream().collect(Collectors.groupingBy(Biota::getType, Collectors.toList()));
    }

    public long getCountByType(BiotaType type) {
        return biotaList.stream().filter(b -> b.getType().equals(type)).count();
    }

    public Biota getRandomBiota() {
        if (biotaList.isEmpty()) {
            return null;
        }
        if (biotaList.size() == 1) {
            return biotaList.get(0);
        }
        return biotaList.get(ThreadLocalRandom.current().nextInt(biotaList.size() - 1));
    }
}
