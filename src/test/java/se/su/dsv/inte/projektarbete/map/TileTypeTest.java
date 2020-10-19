package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.su.dsv.inte.projektarbete.map.Tiles.Door;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.Rock;
import se.su.dsv.inte.projektarbete.map.Tiles.Toxic;

public class TileTypeTest {
    private static final Map MAP = new Map();

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

    /*@Test
    void playerNotAllowedInToxicTile() {
        assertFalse(new Toxic().isPassable(new Player())); //Waiting for implementation
    }*/
}
