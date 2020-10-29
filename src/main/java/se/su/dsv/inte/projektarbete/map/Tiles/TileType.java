package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.characters.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a type of tile.
 */
public abstract class TileType {
    /**
     * Whether the tile is passable or not for Characters.
     */
    protected boolean isPassable;

    /**
     * A List of non allowed Characters on a tile.
     */
    protected final List<String> notAllowedCharacters = new ArrayList<>();

    /**
     * @param isPassable if this tile can be entered.
     */
    protected TileType(boolean isPassable) {
        this.isPassable = isPassable;
    }

    /**
     * @return if the tile is passable or not.
     */
    public boolean isPassable() {
        return isPassable;
    }

    /**
     * @param character, The Character getting checked.
     * @return if the type of Character is allowed or not.
     * @throws NullPointerException if the character is null.
     */
    public boolean isAllowedCharacter(Character character) {
        if (character == null)
            throw new NullPointerException("Character may not be null");

        String characterSuperName = character.getClass().getSuperclass().getSimpleName();

        for (String s : notAllowedCharacters) {
            if (s.equals(characterSuperName)) {
                return false;
            }
        }

        return true;
    }
}