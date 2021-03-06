package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
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
        int damage = c1.calculateDamage();

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
    public void constructorSetManaNegative() {
        String name = "Bob";
        int health = 100;
        int mana = -2;

        assertThrows(IllegalArgumentException.class, () -> {
            Character c = new Character(name, null, null, health, mana);
        });
    }

    /**
     * Checks that placing a null Character throws null pointer exception.
     */
    @Test
    void placingNullCharacterThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            MAP.placeCharacter(null, 0, 0);
        });
    }
    /**
     * Checks that isWithinRange returns true when within range.
     */
    @Test
    void characterIsInRange() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 1, 1);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    /**
     * Checks that the pythagoras calculations of isWithinRange is correct (Not in range).
     */
    @Test
    void characterNotInRangePythagoras() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 7, 7);
        assertFalse(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    /**
     * Checks that the pythagoras calculations of isWithinRange is correct (In range).
     */
    @Test
    void characterInRangePythagoras() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 2, 4);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    /**
     * Checks that true is still returned when precisely in range.
     */
    @Test
    void preciselyInRange() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 5, 0);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    /**
     * Checks that the simple calculation of isWithInRange works.
     */
    @Test
    void isWithInRangeSameXCoordinate() {
        MAP.placeCharacter(CHARACTER_1, 0, 0);
        MAP.placeCharacter(CHARACTER_2, 0, 5);
        assertTrue(CHARACTER_1.isWithinRange(CHARACTER_2, RANGE));
    }

    /**
     * If no point is found (ex: an x value of 10 when max is 8) an exception should be thrown.
     */
    @Test
    void exceptionThrownWhenPointNotFound() {
        assertThrows(IllegalStateException.class, () -> {
            MAP.placeCharacter(CHARACTER_1, 11, 11);
        });
    }

    @Test
    void getPointReturnsPoint() {
        Character c = new Character("Bob", null, null);
        Map map = new Map(10, 10);
        int x = 1;
        int y = 5;
        map.placeCharacter(c, x, y);
        assertEquals(x, c.getPoint().getCoordinates()[0]);
        assertEquals(y, c.getPoint().getCoordinates()[1]);
    }

    @Test
    void setElementTypeChangesCurrent() {
        String name = "bob";
        int health = 100;
        int mana = 120;

        Character c = new Character(name, ElementType.LAND, null, null, health, mana) {};
        c.setElementType(ElementType.AIR);

        assertEquals(ElementType.AIR, c.getElementType());
    }

    @Test
    void hurtWithNegativeValue() {
        Character c = new Character("Bob", null, null);

        int startingHealth = c.getCurrentHealth();

        c.hurt(-2);

        int currentHealth = c.getCurrentHealth();

        assertEquals(startingHealth, currentHealth);
    }

    @Test
    void hurtWithMagicWithNegativeValue() {
        Character c = new Character("Bob", null, null);

        int startingHealth = c.getCurrentHealth();

        c.hurtWithMagic(-2);

        int currentHealth = c.getCurrentHealth();

        assertEquals(startingHealth, currentHealth);
    }

    @Test
    void isAliveDetectsHealth() {
        Character c = new Character("Bob", null, null);
        int startingHealth = c.getCurrentHealth();
        c.hurt(100);
        assertEquals(false, c.isAlive());
    }
}