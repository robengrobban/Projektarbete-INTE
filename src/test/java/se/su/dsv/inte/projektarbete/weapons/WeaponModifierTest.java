package se.su.dsv.inte.projektarbete.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the WeaponModifier class
 */
public class WeaponModifierTest {

    /**
     * Test so that the constructor sets correct values
     */
    @Test
    public void testConstructorSetCorrectValues() {
        String name = "A modifier";
        int cost = 10;

        WeaponModifier wm = new WeaponModifier(name, cost) {
            @Override
            public int calculateBaseDamageModification(int baseDamage) {
                return 0;
            }
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertEquals(name, wm.getName());
        assertEquals(cost, wm.getCost());
    }

    /**
     * Test the constructor with null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        int cost = 12;

        assertThrows( IllegalArgumentException.class, () -> {
            new WeaponModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDamageModification(int baseDamage) {
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
            new WeaponModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDamageModification(int baseDamage) {
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
            new WeaponModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDamageModification(int baseDamage) {
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
            new WeaponModifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
                @Override
                public int calculateBaseDamageModification(int baseDamage) {
                    return 0;
                }
            };
        } );
    }

}