package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

/**
 * Represents a point on a map.
 */
public class MapPoint {
    /**
     * The tile type of the point.
     */
    private final TileType type;

    /**
     * Position on the map.
     */
    private final int[] coordinates = new int[2];

    /**
     * @param type  value.
     * @param x value.
     * @param y value.
     * @throws NullPointerException when type is null.
     */
    public MapPoint(TileType type, int x, int y) {
        if (type == null)
            throw new NullPointerException("Type may not be null");

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
        return coordinates.clone();
    }
}
