package se.su.dsv.inte.projektarbete.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Weapons Class
 */
public class WeaponTest {

    /**
     * Test the constructor with correct values sent.
     */
    @Test
    public void testConstructorSetValues() {
        String name = "Svärd 1";
        String desc = "Det första svärdet som skapades.";
        int baseDamage = 10;
        int range = 1;
        int durability = 100;
        Weapon w = new Weapon(name, desc, baseDamage, range, durability);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(durability, w.getDurability());

    }

    /**
     * Test the constructor with minimal correct values sent.
     */
    @Test
    public void testConstructorSetMinimalValues() {
        String name = "Svärd 2";
        String desc = "Det andra svärdet som skapades.";
        int baseDamage = 12;
        int range = 2;
        Weapon w = new Weapon(name, desc, baseDamage, range);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(100, w.getDurability());
    }

    /**
     * Test the constructor with a base damage of 0.
     */
    @Test
    public void testConstructorBaseDamageEqualToZero() {
        String name = "Svärd 3";
        String desc = "Det tredje svärdet som skapades.";
        int baseDamage = 0;
        int range = 3;

        assertThrows( IllegalArgumentException.class, ()-> {
            Weapon w = new Weapon(name, desc, baseDamage, range);
        });
    }



}