package se.su.dsv.inte.projektarbete.map;

//TODO: Tiles that can only hold certain monsters

/**
 * Enum to represent the type of a tile.
 */
public enum TileType {
    GROUND(true),
    DOOR(true);

    public boolean passable;

    TileType(boolean passable) {
        this.passable = passable;
    }
}
