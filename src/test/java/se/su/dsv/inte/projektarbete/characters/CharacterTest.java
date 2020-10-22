package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.*;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;


import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private static final String NAME = "Bob";
    private static final Armour ARMOUR = new Armour("helmet", "shiny", ArmourType.HEAVY, 2);
    private static final Weapon WEAPON = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
    private static final int CUSTOM_HEALTH = 120;
    private static final int MAX_MANA = 150;
    private static final Character CHARACTER_1 = new NonPlayerCharacter(NAME, ARMOUR, WEAPON, null);
    private static final Character CHARACTER_2 = new NonPlayerCharacter(NAME, ARMOUR, WEAPON, CUSTOM_HEALTH, MAX_MANA, null);
    private static final Character CHARACTER_3 = new NonPlayerCharacter(NAME, ARMOUR, null, null);

    private static final Map MAP = new Map(10, 10);
    private static final int RANGE = 5;

    @Test
    public void constructorsSetCorrectValues() {
        assertEquals(NAME, CHARACTER_1.getName());
        assertEquals(NAME, CHARACTER_2.getName());
        assertEquals(ARMOUR, CHARACTER_1.getArmour());
        assertEquals(ARMOUR, CHARACTER_2.getArmour());
        assertEquals(WEAPON, CHARACTER_1.getWeapon());
        assertEquals(WEAPON, CHARACTER_2.getWeapon());
        assertEquals(100, CHARACTER_1.getMaxHealth());
        assertEquals(CUSTOM_HEALTH, CHARACTER_2.getMaxHealth());
        assertEquals(WEAPON.getTotalDamage(), CHARACTER_1.getBaseDamage());
        assertEquals(WEAPON.getTotalDamage(), CHARACTER_2.getBaseDamage());
        assertEquals(5, CHARACTER_3.getBaseDamage());
    }

    @Test
    public void damageIsCalculatedCorrectly(){
        String name = "Bob";
        Armour armour = new Armour("helmet", "shiny", ArmourType.HEAVY, 2);
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        Character c1 = new NonPlayerCharacter(name, armour, weapon, null);
        int minValue = c1.getBaseDamage();
        int maxValue = minValue + 5;
        System.out.println("base damage: " + minValue);
        int damage = c1.CalculateDamage();

        assertTrue(damage < maxValue && damage >= minValue);
    }

    @Test
    public void changeCurrentManaCorrectly() {
        Character character = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};

        assertTrue(character.changeCurrentMana(-50));
        assertEquals(50, character.getCurrentMana());

    }

    @Test
    public void changeCurrentManaTooMuch() {
        Character character = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};

        assertTrue(character.changeCurrentMana(100));
        assertEquals(100, character.getCurrentMana());

    }

    @Test
    public void changeCurrentManaTooLittle() {
        Character character = new Character("Bob", new Armour("Helmet", "Shiny", ArmourType.HEAVY, 2), new Weapon("Sword", "Rusty", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND))), 100, 100) {};

        assertTrue(character.changeCurrentMana(-50));
        assertEquals(50, character.getCurrentMana());

        assertFalse(character.changeCurrentMana(-51));
        assertEquals(50, character.getCurrentMana());

    }

    @Test
    public void constructorSetElementTypeMin() {
        String name = "bob";
        ElementType elementType = ElementType.LAND;

        Character c = new Character(name, elementType, null, null) {};

        assertEquals(name, c.getName());
        assertEquals(ElementType.valueOf(elementType.name()), c.getElementType());
        assertNull(c.getWeapon());
        assertNull(c.getArmour());
    }

    @Test
    public void constructorSetElementTypeMax() {
        String name = "bob";
        ElementType elementType = ElementType.LAND;
        int health = 100;
        int mana = 120;

        Character c = new Character(name, elementType, null, null, health, mana) {};

        assertEquals(name, c.getName());
        assertEquals(ElementType.valueOf(elementType.name()), c.getElementType());
        assertNull(c.getWeapon());
        assertNull(c.getArmour());
        assertEquals(100, c.getMaxHealth());
        assertEquals(120, c.getMaxMana());
    }

    @Test
    void characterIsInRange() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 1, 1);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    @Test
    void characterNotInRange() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 7, 7);
        assertFalse(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    @Test
    void preciselyInRange() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 5, 0);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    @Test
    void exceptionThrownWhenPointNotFound() {
        assertThrows(IllegalStateException.class, () -> {
            MAP.placeCharacter(CHARACTER_1, 11, 11);
        });
    }
}