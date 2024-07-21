package org.tbcarus.model;


import lombok.Data;
import org.tbcarus.model.biota.Biota;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class Cell {

    int x;
    int y;
    List<Biota> biotaList = new CopyOnWriteArrayList<Biota>();

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void addBiota(Biota b) {
        biotaList.add(b);
    }
}
