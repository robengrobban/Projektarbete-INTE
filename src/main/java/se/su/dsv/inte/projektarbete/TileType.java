package se.su.dsv.inte.projektarbete;

public enum TileType {
    GROUND(true);

    public boolean passable;
    private TileType(boolean passable) {
        this.passable = passable;
    }
}
