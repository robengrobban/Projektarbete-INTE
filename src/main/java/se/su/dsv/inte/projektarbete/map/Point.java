package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

public class Point {
    private final TileType type;
    private final int[] coordinates = new int[2];

    /**
     * @param type type value.
     */
    public Point(TileType type) {
        this.type = type;
    }

    /**
     * @param type type value.
     */
    public Point(TileType type, int x, int y) {
        //this.interactableObject = interactableObject;
        this.type = type;
        coordinates[0] = x;
        coordinates[1] = y;
    }

    /**
     * @return TileType, type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @return coordinates
     */
    public int[] getCoordinates() {
        return coordinates;
    }
}
