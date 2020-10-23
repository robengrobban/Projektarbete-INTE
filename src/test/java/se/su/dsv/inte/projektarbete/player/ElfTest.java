package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {

    @Test
    void attackedDamagesCorrectly() {
        String name = "test";
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 102;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Elf player = new Elf("test", totalHealth, maxMana, damage,
                defence, attack, 2, 2, experience, level, null, null );

        int baseDamage = 30;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon sword = new Weapon("sword", "A sword", baseDamage, range, canAttack);

        player.damaged(sword);
        assertEquals(47, player.getCurrentHealth());
    }
}