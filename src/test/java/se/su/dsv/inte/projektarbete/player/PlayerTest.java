package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.magic.FireSpell;
import se.su.dsv.inte.projektarbete.magic.Spell;
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
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null ) {
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
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null ) {
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
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null ) {
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
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player1 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player2 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player3 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level, null, null, null) {
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
        Weapon sword = new Weapon(swordName, desc, baseDamage, range, canAttack);

        Player player1 = new Player(name, totalHealth, maxMana, damage,
                defence, attack, experience, level, sword, null, null) {
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
                defence, attack, experience, level, sword, null, null) {
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

    @Test
    void levelUpDoesNotWorkIfLevelIs20OrAbove() {

        //Setup players
        int totalHealth = 100;
        int damage = 0;
        int maxMana = 50;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level1 = 20;
        int level2 = 21;
        int level3 = 1999956;

        Player player1 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level1, null, null, null ) {
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

        Player player2 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level2, null, null, null ) {
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

        Player player3 = new Player("test", totalHealth, maxMana, damage,
                defence, attack, experience, level3, null, null, null ) {
            @Override
            public int getTotalHealth() {
                return super.getTotalHealth();
            }
            @Override
            public int getCurrentHealth() {
                return super.getTotalAttack();
            }
            @Override
            public int getExperience() {
                return super.getTotalDefence();
            }
            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        //Try leveling up players
        player1.levelUp();
        player2.levelUp();
        player3.levelUp();

        //Assert no changes
        assertEquals(100, player1.getTotalHealth());
        assertEquals(25, player1.getTotalAttack());
        assertEquals(20, player1.getTotalDefence());
        assertEquals(20, player1.getTotalDefence());

        assertEquals(100, player2.getTotalHealth());
        assertEquals(25, player2.getTotalAttack());
        assertEquals(20, player2.getTotalDefence());
        assertEquals(20, player2.getTotalDefence());

        assertEquals(100, player3.getTotalHealth());
        assertEquals(25, player3.getTotalAttack());
        assertEquals(20, player3.getTotalDefence());
        assertEquals(20, player3.getTotalDefence());

    }

    @Test
    void addExperienceLevelUpCorrectly() {
        //Setup players
        int experience1 = 10;
        int experience2 = 10;
        int experience3 = 10;
        int level1 = 1;
        int level2 = 1;
        int level3 = 1;

        Player player1 = new Player("test", 10, 0, 10,
                10, 10, experience1, level1, null, null, null ) {
            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        Player player2 = new Player("test", 10, 0, 10,
                10, 10, experience2, level2, null, null, null ) {

            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        Player player3 = new Player("test", 10, 0, 10,
                10, 10, experience3, level3, null, null, null ) {

            @Override
            public int getLevel() {
                return super.getLevel();
            }
        };

        //Adding experience to the players
        player1.addExperience(39);
        player2.addExperience(40);
        player3.addExperience(41);

        //Check correct level up.
        assertEquals(1, player1.getLevel());
        assertEquals(2, player2.getLevel());
        assertEquals(2, player3.getLevel());
    }

    @Test
    void canOnlyAddTenSpells() {
        Player player = new Player("name") {
            @Override
            public boolean addSpell(Spell spell) {
                return super.addSpell(spell);
            }
        };

        for (int i = 1; i <= 10; i++) {
            int range = i;
            int manaCost = 10;
            int damage = 20;
            HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
            FireSpell f = new FireSpell("spellname" + i, "firespell", range, manaCost, damage, canAttack1);

            assertTrue(player.addSpell(f));
        }

        int range = 11;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell f = new FireSpell("spellname" + 11, "firespell", range, manaCost, damage, canAttack1);

        assertFalse(player.addSpell(f));
    }

    @Test
    void cannotAddDuplicateSpells() {
        Player player = new Player("name") {
            @Override
            public boolean addSpell(Spell spell) {
                return super.addSpell(spell);
            }
        };

        int range = 3;
        int manaCost = 13;
        int damage = 25;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        FireSpell f = new FireSpell("spellname", "firespell", range, manaCost, damage, canAttack1);

        assertDoesNotThrow(() -> {
            player.addSpell(f);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            player.addSpell(f);
        });

    }
}