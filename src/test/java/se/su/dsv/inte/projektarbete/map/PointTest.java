package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    private static final TileType ground = TileType.GROUND;

    @Test
    void correctTileIsSet() {
        Point point = new Point(ground);
        assertEquals(ground, point.getType());
    }
}
