package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

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
            public int getStamina() {
                return super.getStamina();
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
        final int CURRENT_HEALTH = 60;
        int stamina = 50;
        int staminaUsed = 30;
        final int CURRENT_STAMINA = 20;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, damage, stamina, staminaUsed, defence, attack, experience, level) {
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
            public int getStamina() {
                return super.getStamina();
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
        assertEquals(CURRENT_STAMINA, player.getStamina());
        assertEquals(totalHealth, player.getTotalHealth());
        assertEquals(CURRENT_HEALTH, player.getCurrentHealth());
    }
}