package se.su.dsv.inte.projektarbete;

public enum TileType {
    GROUND(true);

    public boolean passable;
    TileType(boolean passable) {
        this.passable = passable;
    }
}
