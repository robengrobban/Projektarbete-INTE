package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.su.dsv.inte.projektarbete.map.Tiles.Door;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.Rock;
import se.su.dsv.inte.projektarbete.map.Tiles.Toxic;
import se.su.dsv.inte.projektarbete.player.Elf;

public class TileTypeTest {
    private static final Map MAP = new Map();
    private static final Elf ELF = new Elf("This String is irrelevant to the test");
    private static final Toxic TOXIC = new Toxic();
    private static final Ground GROUND = new Ground();

    @Test
    void mapPointsTowardsCorrectMap() {
        Door door = new Door(MAP);
        assertEquals(MAP, door.getMap());
    }

    @Test
    void passableArePassable() {
        assertTrue(new Ground().isPassable());
        assertTrue(new Door(MAP).isPassable());
        assertTrue(new Toxic().isPassable());
    }

    @Test
    void unPassableAreUnpassable() {
        assertFalse(new Rock().isPassable());
    }

    @Test
    void playerNotAllowedInToxicTile() {
        assertFalse(TOXIC.isAllowedCharacter(ELF));
    }

    @Test
    void playerAllowedInGroundTile() {
        assertTrue(GROUND.isAllowedCharacter(ELF));
    }
}
