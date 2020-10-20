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
        int maxMana = 50;
        final int CURRENT_HEALTH = 60;
        int stamina = 50;
        int staminaUsed = 30;
        final int CURRENT_STAMINA = 20;
        int defence = 20;
        int attack = 25;
        int experience = 200;
        int level = 5;

        Player player = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
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

        Player player = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
                defence, attack, experience, level, null, null ) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
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

        Player player = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
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

        Player player1 = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player2 = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        Player player3 = new Player("test", totalHealth, maxMana, damage, stamina, staminaUsed,
                defence, attack, experience, level, null, null) {
            @Override
            public boolean damaged(int damage) {
                return super.damaged(damage);
            }
        };

        assertTrue(player1.damaged(60));
        assertTrue(player2.damaged(61));
        assertTrue(player3.damaged(1000000));
    }
}