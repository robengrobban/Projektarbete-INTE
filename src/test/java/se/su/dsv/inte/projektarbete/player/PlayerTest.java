package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void newPlayerConstructorSetValuesCorrectly() {
        String name = "test";
        int expectedLevel = 1;
        int expectedExperience = 0;
        Player player = new Player("test") {

            @Override
            public String getName() {
                return super.getName();
            }
            @Override
            public int getTotalHealth() {
                return super.getTotalHealth();
            }
            @Override
            public int getCurrentHealth() {
                return super.getCurrentHealth();
            }
            @Override
            public int getExperience() {
                return super.getExperience();
            }
            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        assertEquals(name, player.getName());
        assertEquals(expectedLevel, player.getLevel());
        assertEquals(expectedExperience, player.getExperience());
    }

    @Test
    void emptyNameNotAccepted() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player("") {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player("   ") {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player(null) {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
        });
    }

    @Test
    void playerConstructorSetValuesCorrectly() {
        String name = "test";
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 50;
        final int CURRENT_HEALTH = 60;
        int stamina = 50;
        int staminaUsed = 30;
        final int CURRENT_STAMINA = 20;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null ) {
            @Override
            public String getName() {
                return super.getName();
            }
            @Override
            public int getTotalHealth() {
                return super.getTotalHealth();
            }
            @Override
            public int getCurrentHealth() {
                return super.getCurrentHealth();
            }
            @Override
            public int getExperience() {
                return super.getExperience();
            }
            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        assertEquals(name, player.getName());
        assertEquals(level, player.getLevel());
        assertEquals(experience, player.getExperience());
        assertEquals(totalHealth, player.getTotalHealth());
        assertEquals(maxMana, player.getMaxMana());
        assertEquals(CURRENT_HEALTH, player.getCurrentHealth());
    }

    @Test
    void playerHPLeftAfterDamageCorrect() {
        String name = "test";
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 30;
        int stamina = 50;
        int staminaUsed = 30;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null ) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
            @Override
            public int getCurrentHealth() {
                return super.getCurrentHealth();
            }
        };

        player.damaged(50);
        assertEquals(10, player.getCurrentHealth());
    }

    @Test
    void playerAliveAfterDamagedLessThanHPLeft() {
        String name = "test";
        int totalHealth = 100;
        int damage = 40;
        int maxMana = 40;
        int stamina = 50;
        int staminaUsed = 30;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null ) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        assertTrue(player.damaged(1));
        assertTrue(player.damaged(10));
        assertTrue(player.damaged(48));
    }

    @Test
    void playerDeadAfterDamagedMorOrSameAsHPLeft() {
        String name = "test";
        int totalHealth = 100;
        int maxMana = 50;
        int damage = 40;
        int stamina = 50;
        int staminaUsed = 30;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player1 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player2 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player3 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        //False means dead
        assertFalse(player1.damaged(60));
        assertFalse(player2.damaged(61));
        assertFalse(player3.damaged(1000000));
    }

    @Test
    void enemyDamagedCorrectlyAfterAttack() {

        //Setup player
        String name = "test";
        int totalHealth = 100;
        int maxMana = 50;
        int damage = 40;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        //Setup weapon used by player
        String swordName = "Sword";
        String desc = "A sword.";
        int baseDamage = 10;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        Weapon sword = new Weapon(name, desc, baseDamage, range, canAttack);

        Player player1 = new Player(name, totalHealth, maxMana, damage,
                defence, attack, experience, level, sword, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        //Setup enemy
        String enemyName = "test";
        int enemyTotalHealth = 100;
        int enemyMaxMana = 50;
        Character enemy = new Character(enemyName, null, null, enemyTotalHealth, enemyMaxMana) {
            @Override
            public int getCurrentHealth() {
                return super.getCurrentHealth();
            }
        };

        //Player damaging enemy
        player1.attack(enemy);

        //Asserting correct damage done.
        assertEquals(65, enemy.getCurrentHealth());
    }

    @Test
    void enemyWithArmourDamagedCorrectlyAfterAttack() {

        //Setup player
        String name = "test";
        int totalHealth = 100;
        int maxMana = 50;
        int damage = 40;
        int defence = 20;
        int attack = 40;
        int experience = 200;
        int level = 5;

        //Setup weapon used by player
        String swordName = "Sword";
        String desc = "A sword.";
        int baseDamage = 20;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        Weapon sword = new Weapon(name, desc, baseDamage, range, canAttack);

        Player player1 = new Player(name, totalHealth, maxMana, damage,
                defence, attack, experience, level, sword, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        //Setup enemy
        String enemyName = "test";
        int enemyTotalHealth = 95;
        int enemyMaxMana = 50;
        Armour enemyArmour = new Armour("armour", "bad armour", ArmourType.LIGHT, 3);
        Character enemy = new Character(enemyName, enemyArmour, null, enemyTotalHealth, enemyMaxMana) {
            @Override
            public int getCurrentHealth() {
                return super.getCurrentHealth();
            }
        };

        //Player damaging enemy
        player1.attack(enemy);

        //Asserting correct damage done.
        assertEquals(38, enemy.getCurrentHealth());
    }
}