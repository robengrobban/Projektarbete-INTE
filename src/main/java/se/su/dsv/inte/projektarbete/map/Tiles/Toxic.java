package se.su.dsv.inte.projektarbete.map.Tiles;

import se.su.dsv.inte.projektarbete.player.Player;

public class Toxic extends TileType {
    public Toxic() {
        super(true);
        NOT_ALLOWED_CHARACTERS.add(Player.class.getSimpleName());
    }
}
