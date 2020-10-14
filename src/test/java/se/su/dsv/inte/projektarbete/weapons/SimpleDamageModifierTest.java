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

}