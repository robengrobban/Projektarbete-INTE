package se.su.dsv.inte.projektarbete.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the ArmourModifier Class
 */
public class ArmourModifierTest {

    /**
     * Test so that the constructor sets correct values
     */
    @Test
    public void testConstructorSetCorrectValues() {
        String name = "A modifier";
        int cost = 10;

        ArmourModifier am = new ArmourModifier(name, cost) {
            @Override
            public int calculateBaseDefenceModification(int baseDefence) {
                return 0;
            }
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertEquals(name, am.getName());
        assertEquals(cost, am.getCost());
    }

    /**
     * Test the constructor with null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        int cost = 12;

        assertThrows( IllegalArgumentException.class, () -> {
            new ArmourModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDefenceModification(int baseDefence) {
                    return 0;
                }
            };
        } );
    }

    /**
     * Test the constructor with empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        int cost = 12;

        assertThrows( IllegalArgumentException.class, () -> {
            new ArmourModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDefenceModification(int baseDefence) {
                    return 0;
                }
            };
        } );
    }

    /**
     * Test the constructor with zero cost
     */
    @Test
    public void testConstructorZeroCost() {
        String name = "A very expensive modifier";
        int cost = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new ArmourModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDefenceModification(int baseDefence) {
                    return 0;
                }
            };
        } );
    }

    /**
     * Test the constructor with negative cost
     */
    @Test
    public void testConstructorNegativeCost() {
        String name = "A very expensive modifier";
        int cost = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new ArmourModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDefenceModification(int baseDefence) {
                    return 0;
                }
            };
        } );
    }

}