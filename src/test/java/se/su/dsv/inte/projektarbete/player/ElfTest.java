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
        final int CURRENT_HEALTH = 60;
        int stamina = 50;
        int staminaUsed = 30;
        final int CURRENT_STAMINA = 20;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Elf player = new Elf("test", totalHealth, maxMana, damage, stamina, staminaUsed,
                defence, attack, experience, level, null, null );

        String swordName = "Sword";
        String desc = "A sword.";
        int baseDamage = 10;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon sword = new Weapon(name, desc, baseDamage, range, canAttack);

        player.attacked(sword);
        assertEquals(50, player.getCurrentHealth());
    }
}