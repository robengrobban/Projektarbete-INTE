package se.su.dsv.inte.projektarbete.magic;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

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
        int healing = 2;

        HealSpell healSpell = new HealSpell(name, description, range, manaCost, healing);

        assertEquals(name, healSpell.getName());
        assertEquals(description, healSpell.getDescription());
        assertEquals(range, healSpell.getRange());
        assertEquals(manaCost, healSpell.getManaCost());
        assertEquals(healing, healSpell.getHealing());
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
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
        int healing = 2;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
        } );
    }

    /**
     * Test the constructor with zero healing
     */
    @Test
    public void testConstructorZeroHealing() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;
        int healing = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
        } );
    }

    /**
     * Test the constructor with negative healing
     */
    @Test
    public void testConstructorNegativeHealing() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;
        int healing = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new HealSpell(name, description, range, manaCost, healing);
        } );
    }

    /**
     * Test healing between two characters successfully
     */
    @Test
    public void testHealingSuccessful() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 20;
        int healing = 10;

        HealSpell healingSpell = new HealSpell(name, description, range, manaCost, healing);

        Character c1 = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};
        Character c2 = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};

        c2.changeCurrentHealth(-50);

        assertTrue(healingSpell.use(c1, c2));

        assertEquals(80, c1.getCurrentMana());
        assertEquals(60, c2.getCurrentHealth());
    }

    /**
     * Test healing between two characters too little mana
     */
    @Test
    public void testHealingTooLittleMana() {
        String name = "Healing";
        String description = "This spell heals you, or targeted NPC... I think...";
        int range = 1;
        int manaCost = 10;
        int healing = 10;

        HealSpell healingSpell = new HealSpell(name, description, range, manaCost, healing);

        Character c1 = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 9) {};
        Character c2 = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};

        c2.changeCurrentHealth(-50);

        assertFalse(healingSpell.use(c1, c2));

        assertEquals(9, c1.getCurrentMana());
        assertEquals(50, c2.getCurrentHealth());
    }

    /**
     * Test healing between two characters already max health
     */

}