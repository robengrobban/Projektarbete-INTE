package se.su.dsv.inte.projektarbete.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing IncreasedDamageModifier
 */
public class SimpleDamageModifierTest {

    /**
     * Test the standard constructor with positive values.
     */
    @Test
    public void testConstructorSetValuesPositive() {
        String name = "MORE DAMAGE, MOO HA HA";
        int cost = 10;
        int damageModifier = 3;

        SimpleDamageModifier sdm = new SimpleDamageModifier(name, cost, damageModifier);

        assertEquals(name, sdm.getName());
        assertEquals(cost, sdm.getCost());
        assertEquals(damageModifier, sdm.getBaseDamageModifier());
    }

    /**
     * Test the standard constructor with negative values.
     */
    @Test
    public void testConstructorSetValuesNegative() {
        String name = "LESS DAMAGE, BOO HU HU";
        int cost = 10;
        int damageModifier = -2;

        SimpleDamageModifier sdm = new SimpleDamageModifier(name, cost, damageModifier);

        assertEquals(name, sdm.getName());
        assertEquals(cost, sdm.getCost());
        assertEquals(damageModifier, sdm.getBaseDamageModifier());
    }

    /**
     * Test constructor with an illegal argument of damage modifier being zero.
     */
    @Test
    public void testConstructorDamageModifierZero() {
        String name = "Zero damage addded";
        int cost = 1000000;
        int damageModifier = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new SimpleDamageModifier(name, cost, damageModifier);
        } );
    }

    /**
     * Test constructor with an illegal argument of name null
     */
    @Test
    public void testConstructorNameNull() {
        String name = null;
        int cost = 12;
        int damageModifier = 1;

        assertThrows( IllegalArgumentException.class, () -> {
            new SimpleDamageModifier(name, cost, damageModifier);
        } );
    }

    /**
     * Test constructor with an illegal argument of an empty name
     */
    @Test
    public void testConstructorNameEmpty() {
        String name = "";
        int cost = 1;
        int damageModifier = 1;

        assertThrows( IllegalArgumentException.class, () -> {
            new SimpleDamageModifier(name, cost, damageModifier);
        } );
    }

    /**
     * Test constructor with an illegal argument of a cost of zero.
     */
    @Test
    public void testConstructorCostZero() {
        String name = "Bad modifier";
        int cost = 0;
        int damageModifier = 1;

        assertThrows( IllegalArgumentException.class, () -> {
            new SimpleDamageModifier(name, cost, damageModifier);
        } );
    }

    /**
     * Test constructor with an illegal argument of a negative cost.
     */
    @Test
    public void testConstructorCostNegative() {
        String name = "Bad modifier";
        int cost = -1;
        int damageModifier = 1;

        assertThrows( IllegalArgumentException.class, () -> {
            new SimpleDamageModifier(name, cost, damageModifier);
        } );
    }


    /**
     * Test the equals method
     */
    @Test
    public void testEqualSimpleDamageModifer() {
        String name = "More damage...";
        int cost = 5;
        int damageModifier = 2;

        SimpleDamageModifier sdm1 = new SimpleDamageModifier(name, cost, damageModifier);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier(name, cost, damageModifier);

        assertTrue(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different WeaponModifier
     */
    @Test
    public void testEqualDifferentName() {
        String name1 = "More damage?";
        String name2 = "I do not know...";
        int cost = 5;
        int damageModifier = 2;

        SimpleDamageModifier sdm1 = new SimpleDamageModifier(name1, cost, damageModifier);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier(name2, cost, damageModifier);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different WeaponModifier
     */
    @Test
    public void testEqualDifferentCost() {
        String name = "More damage!";
        int cost1 = 5;
        int cost2 = 10;
        int damageModifier = 2;

        SimpleDamageModifier sdm1 = new SimpleDamageModifier(name, cost1, damageModifier);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier(name, cost2, damageModifier);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different WeaponModifier
     */
    @Test
    public void testEqualDifferentDamageModifier() {
        String name = "More damage?!?!?!";
        int cost = 5;
        int damageModifier1 = 2;
        int damageModifier2 = 3;

        SimpleDamageModifier sdm1 = new SimpleDamageModifier(name, cost, damageModifier1);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier(name, cost, damageModifier2);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method with wrong class
     */
    @Test
    public void testEqualWrongClass() {
        String name = "More damage?!?!?!";
        int cost = 5;
        int damageModifier = 2;

        SimpleDamageModifier sdm = new SimpleDamageModifier(name, cost, damageModifier);

        assertFalse(sdm.equals(new Object()));
    }


}