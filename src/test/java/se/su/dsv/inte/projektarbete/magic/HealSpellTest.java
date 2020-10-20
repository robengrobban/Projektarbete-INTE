package se.su.dsv.inte.projektarbete.magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the HealSpell Class
 */
public class HealSpellTest {

    /**
     * Test the constructor set correct values
     */
    @Test
    public void testConstructorSetCorrectValues() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;

        HealSpell healSpell = new HealSpell(name, description, range, manaCost);

        assertEquals(name, healSpell.getName());
        assertEquals(description, healSpell.getDescription());
        assertEquals(range, healSpell.getRange());
        assertEquals(manaCost, healSpell.getManaCost());
    }

    /**
     * Test constructor with null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with null description
     */
    @Test
    public void testConstructorNullDescription() {
        String name = "Healing";
        String description = null;
        int range = 1;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with empty description
     */
    @Test
    public void testConstructorEmptyDescription() {
        String name = "Healing";
        String description = "";
        int range = 1;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with zero range
     */
    @Test
    public void testConstructorZeroRange() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 0;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with negative range
     */
    @Test
    public void testConstructorNegativeRange() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = -1;
        int manaCost = 20;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with zero mana cost
     */
    @Test
    public void testConstructorZeroManaCost() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

    /**
     * Test the constructor with negative mana cost
     */
    @Test
    public void testConstructorNegativeManaCost() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost);
        } );
    }

}