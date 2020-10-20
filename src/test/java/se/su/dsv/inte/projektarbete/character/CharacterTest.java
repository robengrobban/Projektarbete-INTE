package se.su.dsv.inte.projektarbete.character;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.*;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.weapon.Weapon;


import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    public void constructorsSetCorrectValues() {
        String name = "Bob";
        Armour armour = new Armour("helmet", "shiny", ArmourType.HEAVY, 2);
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        int customHealth = 120;
        int maxMana = 150;
        Character c1 = new NonPlayerCharacter(name, armour, weapon, null);
        Character c2 = new NonPlayerCharacter(name, armour, weapon, customHealth, maxMana, null);
        Character c3 = new NonPlayerCharacter(name, armour, null, null);

        assertEquals(name, c1.getName());
        assertEquals(name, c2.getName());
        assertEquals(armour, c1.getArmour());
        assertEquals(armour, c2.getArmour());
        assertEquals(weapon, c1.getWeapon());
        assertEquals(weapon, c2.getWeapon());
        assertEquals(100, c1.getMaxHealth());
        assertEquals(customHealth, c2.getMaxHealth());
        assertEquals(weapon.getTotalDamage(), c1.getBaseDamage());
        assertEquals(weapon.getTotalDamage(), c2.getBaseDamage());
        assertEquals(5, c3.getBaseDamage());
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
}