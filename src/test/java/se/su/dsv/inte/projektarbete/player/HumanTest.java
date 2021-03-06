package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.magic.FireSpell;
import se.su.dsv.inte.projektarbete.magic.HealSpell;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void attackedWithWeaponDamagesCorrectly() {
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 102;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Human player = new Human("test", totalHealth, maxMana, damage,
                defence, attack, 2, 2, experience, level, null, null );

        int baseDamage = 50;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon sword = new Weapon("sword", "A sword", baseDamage, range, canAttack);

        player.damaged(sword);
        assertEquals(32, player.getCurrentHealth());
    }

    @Test
    void equippedWithArmourAttackedWithWeaponDamagesCorrectly() {
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 102;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;
        Armour armour = new Armour("Chestplate", "Rusty", ArmourType.LIGHT, 10);

        Human player = new Human("test", totalHealth, maxMana, damage,
                defence, attack, 2, 2, experience, level, armour, null );

        int baseDamage = 50;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon sword = new Weapon("sword", "A sword", baseDamage, range, canAttack);

        player.damaged(sword);
        assertEquals(43, player.getCurrentHealth());
    }

    @Test
    void attackedWithMagicDamagesCorrectly() {
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 102;
        int defence = 20;
        int magicDefence = 22;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Human player = new Human("test", totalHealth, maxMana, damage,
                defence, attack, magicDefence, 2, experience, level, null, null );

        int baseDamage = 55;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        FireSpell spell = new FireSpell("spellname", "firespell", range, 10, baseDamage, canAttack);

        Character caster = new Character("Bob", null, null, 100, 120) {};

        Map map = new Map(10, 10);
        map.placeCharacter(caster, 0, 0);
        map.placeCharacter(player, 0, 1);

        spell.use(caster, player);

        assertEquals(26, player.getCurrentHealth());
    }

    @Test
    void equippedWithArmourAttackedWithMagicDamagesCorrectly() {
        int totalHealth = 100;
        int damage = 20;
        int maxMana = 102;
        int defence = 20;
        int magicDefence = 37;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Armour armour = new Armour("Chestplate", "Rusty", ArmourType.LIGHT, 10);

        Human player = new Human("test", totalHealth, maxMana, damage,
                defence, attack, magicDefence, 2, experience, level, armour, null );

        int baseDamage = 85;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        FireSpell spell = new FireSpell("spellname", "firespell", range, 10, baseDamage, canAttack);

        Character caster = new Character("Bob", null, null, 100, 120) {};

        Map map = new Map(10, 10);
        map.placeCharacter(caster, 0, 0);
        map.placeCharacter(player, 0, 1);

        spell.use(caster, player);

        assertEquals(40, player.getCurrentHealth());
    }

    @Test
    void classLessHumanCannotUseMagic() {
        Human human = new Human("Steve");
        assertFalse(human.canUseMagic());
    }

    @Test
    void humanWithWarriorClassCannotUseMagic() {
        Human human = new Human("Steve");

        human.addPlayerClass(new WarriorClass());

        assertFalse(human.canUseMagic());
    }

    @Test
    void humanWithMagicianClassCanUseMagic() {
        Human human = new Human("Steve");
        human.addPlayerClass(new MagicianClass());
        assertTrue(human.canUseMagic());
    }

    @Test
    void humanWithNoClassCannotAddSpells() {
        //Setup
        Human human = new Human("Steve");
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell spell = new FireSpell("spellname", "firespell", 5, 10, 10, canAttack);
        HealSpell spell2 = new HealSpell("spellname", "healspell", 5, 10, 10);

        //Assert add not working
        assertFalse(human.addSpell(spell));
        assertFalse(human.addSpell(spell2));
        assertEquals(0, human.getSpellCount());
    }

    @Test
    void humanWithWarriorClassCannotAddSpells() {
        //Setup
        Human human = new Human("Steve");
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell spell = new FireSpell("spellname", "firespell", 5, 10, 10, canAttack);
        HealSpell spell2 = new HealSpell("spellname", "healspell", 5, 10, 10);

        human.addPlayerClass(new WarriorClass());

        //Assert add not working
        assertFalse(human.addSpell(spell));
        assertFalse(human.addSpell(spell2));
        assertEquals(0, human.getSpellCount());
    }

    @Test
    void humanWithMagicianClassCanAddSpells() {
        //Setup
        Human human = new Human("Steve");
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell spell = new FireSpell("spellname", "firespell", 5, 10, 10, canAttack);
        HealSpell spell2 = new HealSpell("spellname", "healspell", 5, 10, 10);

        human.addPlayerClass(new MagicianClass());

        //Assert add not working
        assertTrue(human.addSpell(spell));
        assertTrue(human.addSpell(spell2));
        assertEquals(2, human.getSpellCount());
    }

    @Test
    void humanWithMagicianClassCanAddTenSpells() {
        //Setup
        Human human = new Human("Steve");
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell spell = new FireSpell("spellname", "firespell", 5, 10, 10, canAttack);
        FireSpell spell2 = new FireSpell("spellname2", "firespell 2", 6, 11, 2, canAttack);
        FireSpell spell3 = new FireSpell("spellname3", "firespell 3", 7, 12, 14, canAttack);
        FireSpell spell4 = new FireSpell("spellname4", "firespell 4", 8, 13, 16, canAttack);
        FireSpell spell5 = new FireSpell("spellname5", "firespell 5", 9, 14, 18, canAttack);
        FireSpell spell6 = new FireSpell("spellname6", "firespell 6", 10, 15, 20, canAttack);
        FireSpell spell7 = new FireSpell("spellname7", "firespell 7", 11, 16, 22, canAttack);
        FireSpell spell8 = new FireSpell("spellname8", "firespell 8", 12, 17, 24, canAttack);
        FireSpell spell9 = new FireSpell("spellname9", "firespell 9", 13, 18, 26, canAttack);
        FireSpell spell10 = new FireSpell("spellname10", "firespell 10", 14, 19, 28, canAttack);
        FireSpell spell11 = new FireSpell("spellname11", "firespell 11", 15, 20, 30, canAttack);

        human.addPlayerClass(new MagicianClass());

        assertTrue(human.addSpell(spell));
        assertTrue(human.addSpell(spell2));
        assertTrue(human.addSpell(spell3));
        assertTrue(human.addSpell(spell4));
        assertTrue(human.addSpell(spell5));
        assertTrue(human.addSpell(spell6));
        assertTrue(human.addSpell(spell7));
        assertTrue(human.addSpell(spell8));
        assertTrue(human.addSpell(spell9));
        assertTrue(human.addSpell(spell10));
        assertFalse(human.addSpell(spell11));
        assertEquals(10, human.getSpellCount());
    }
}