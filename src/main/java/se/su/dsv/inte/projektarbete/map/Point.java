package se.su.dsv.inte.projektarbete.map;

public class Point {
    private final TileType type;
    //TODO: private INSERT MONSTER / PLAYER TYPE HERE

    public Point(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
}
