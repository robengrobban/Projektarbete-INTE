package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.characters.Character;

import java.util.ArrayList;

public abstract class TileType {
    protected boolean isPassable;
    protected final ArrayList<String> NOT_ALLOWED_CHARACTERS = new ArrayList<>();

    protected TileType(boolean isPassable) {
        this.isPassable = isPassable;
    }

    public boolean isPassable() {
        return isPassable;
    }

    /**
     * @param character, The Character getting checked.
     * @return if the type of Character is allowed or not.
     */
    public boolean isAllowedCharacter(Character character) {
        String characterSuperName = character.getClass().getSuperclass().getSimpleName();

        for (String s : NOT_ALLOWED_CHARACTERS) {
            if (s.equals(characterSuperName)) {
                return false;
            }
        }

        return true;
    }
}