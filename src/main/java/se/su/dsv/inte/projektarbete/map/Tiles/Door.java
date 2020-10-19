package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.map.Map;

public class Door extends TileType {
    private final Map map;

    public Door(Map map) {
        super(true);
        this.map = map;
    }

    public Map getMap() {
        return map;
    }
}
