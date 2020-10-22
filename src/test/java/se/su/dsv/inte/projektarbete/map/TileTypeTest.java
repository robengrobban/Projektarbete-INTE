package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.map.Tiles.*;
import se.su.dsv.inte.projektarbete.player.Elf;

public class TileTypeTest {
    private static final Elf ELF = new Elf("This String is irrelevant to the test");
    private static final Toxic TOXIC = new Toxic();
    private static final Ground GROUND = new Ground();

    /**
     * Checks that all passable tiles are passable.
     */
    @Test
    void passableArePassable() {
        assertTrue(new Ground().isPassable());
        assertTrue(new Door().isPassable());
        assertTrue(new Toxic().isPassable());
    }

    /**
     * Checks that all unpassable tiles are unpassable.
     */
    @Test
    void unPassableAreUnpassable() {
        assertFalse(new Rock().isPassable());
    }

    /**
     * Checks that isAllowedCharacter() returns false when a character is checked on a tile which has that character type in its not allowed list.
     */
    @Test
    void playerNotAllowedInToxicTile() {
        assertFalse(TOXIC.isAllowedCharacter(ELF));
    }

    /**
     * Checks that isAllowedCharacter() returns true when a character is checked on a tile which does not have that character type in its not allowed list.
     */
    @Test
    void playerAllowedInGroundTile() {
        assertTrue(GROUND.isAllowedCharacter(ELF));
    }

    /**
     * Get that last STATEMENT to run
     */
    @Test
    public void testTheLastStatement() {

        boolean isAllowed = TOXIC.isAllowedCharacter(new Character("Lol", null, null) {});

        assertTrue( isAllowed );

    }
}
