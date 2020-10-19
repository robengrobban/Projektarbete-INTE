package se.su.dsv.inte.projektarbete.map.Tiles;

public abstract class TileType {
    protected boolean isPassable;
    protected static final Character[] NOT_ALLOWED_CHARACTERS = {};

    protected TileType(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public boolean isAllowedCharacter(Character character) {
        for (Character c : NOT_ALLOWED_CHARACTERS) {
            if (character.getClass().equals(c.getClass())) {
                return false;
            }
        }

        return true;
    }
}