package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.map.Map;

public class Door extends TileType {
    private Map map;

    /**
     * Sets passable to true.
     */
    public Door() {
        super(true);
    }

    /**
     * @return Map, the map this door points to.
     */
    public Map getMap() {
        return map;
    }

    /**
     * @param currentMap Map, the current map the door is placed on.
     * @return Map, the new Map the door leads to.
     */
    public Map goThrough(Map currentMap) {
        if (map == null) {
            map = currentMap;
            return new Map();
        }
        else {
            Map tmp = map;
            map = currentMap;
            return tmp;
        }
    }
}
