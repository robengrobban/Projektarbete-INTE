package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.player.Player;

/**
 * Represents a toxic tile.
 */
public class Toxic extends TileType {
    /**
     * It is passable but not for the player.
     */
    public Toxic() {
        super(true);
        notAllowedCharacters.add(Player.class.getSimpleName());
    }
}
