package se.su.dsv.inte.projektarbete.map;

public class Point {
    private final TileType type;
    //TODO: private INSERT MONSTER / PLAYER TYPE HERE //Can only hold 1 at a time
    //TODO: structures like chests? - private Structure structure

    /**
     * @param type type value.
     */
    public Point(TileType type) {
        this.type = type;
    }

    /**
     * @return TileType, type
     */
    public TileType getType() {
        return type;
    }
}
