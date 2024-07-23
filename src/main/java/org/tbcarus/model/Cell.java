package org.tbcarus.model;


import lombok.Getter;
import lombok.Setter;
import org.tbcarus.model.biota.Biota;
import org.tbcarus.model.biota.BiotaType;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public long getCountByType(BiotaType type) {
        return biotaList.stream().filter(b -> b.getType().equals(type)).count();
    }
}
