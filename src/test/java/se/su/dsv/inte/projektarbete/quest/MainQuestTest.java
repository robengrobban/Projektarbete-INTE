package se.su.dsv.inte.projektarbete.quest;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.map.Chest;
import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Human;
import se.su.dsv.inte.projektarbete.weapon.SimpleDamageModifier;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainQuestTest {

    private final MainQuest mainQuest = new MainQuest("Test Quest", "Test", 2, new SimpleDamageModifier("Test Damage Modifier", 1, 5));

    @Test
    void getMaxStages() {
        assertEquals(2, mainQuest.getMaxStages());

    }

    @Test
    void maxStageLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new MainQuest("Test Quest", "Test", 0, new SimpleDamageModifier("Test Damage Modifier", 1, 5)));

    }

    @Test
    void maxStageGreaterThanTen() {
        assertThrows(IllegalArgumentException.class, () -> new MainQuest("Test Quest", "Test", 11, new SimpleDamageModifier("Test Damage Modifier", 1, 5)));

    }

    @Test
    void rewardNull() {
        assertThrows(IllegalArgumentException.class, () -> new MainQuest("Test Quest", "Test", 1, null));

    }


    @Test
    void getName() {
        assertEquals("Test Quest", mainQuest.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Test", mainQuest.getDescription());

    }

    @Test
    void getEnemiesKilled() {
    }


    @Test
    void reportKillOneTime() {
        mainQuest.reportKill();
        assertEquals(1, mainQuest.getEnemiesKilled());
    }

    @Test
    void reportKillMoreThanTenTimes() {
        for (int i = 0; i < 12; i++) {
            mainQuest.reportKill();
        }
        assertEquals(10, mainQuest.getEnemiesKilled());
    }

    @Test
    void nextStageAfterTenKill() {
        for (int i = 0; i < 11; i++) {
            mainQuest.reportKill();
        }
        assertEquals(2, mainQuest.getCurrentStage());
    }

    @Test
    void reportIntractableObjectNull() {
        assertThrows(IllegalArgumentException.class, () -> mainQuest.reportIntractableObject(null));


    }

    @Test
    void reportIntractableObjectNotInstantsOfChest() {
        mainQuest.reportIntractableObject(new InteractableObject("Test") {
        });
        assertFalse(mainQuest.isFoundChest());


    }

    @Test
    void reportIntractableObjectInstantsOfChest() {
        Item[] items = new Item[0];
        mainQuest.reportIntractableObject(new Chest(items, "Test"));
        assertTrue(mainQuest.isFoundChest());


    }


    @Test
    void receiveRewardNoWeapon() {
        Item[] items = new Item[5];

        Human human = new Human("human");
        for (int i = 0; i < 11; i++) {
            mainQuest.reportKill();
        }
        mainQuest.reportIntractableObject(new Chest(items, "Test"));
        mainQuest.receiveReward(human);
        assertFalse(mainQuest.isRewardReceived());
    }


    @Test
    void receiveRewardHasWeaponWithModifier() {
        Item[] items = new Item[5];
        Set<ElementType> canAttack = new HashSet<>();
        canAttack.add(ElementType.AIR);
        canAttack.add(ElementType.WATER);


        Weapon weapon= new Weapon("name","description",3,2,canAttack);
        weapon.setModifier(new SimpleDamageModifier("name",1,2));

        Human human = new Human("human",2,3,4,9,2,1,4,new Armour("name","description", ArmourType.HEAVY,2),weapon);
        for (int i = 0; i < 11; i++) {
            mainQuest.reportKill();
        }
        mainQuest.reportIntractableObject(new Chest(items, "Test"));
        mainQuest.receiveReward(human);
        assertFalse(mainQuest.isRewardReceived());
    }

    @Test
    void receiveRewardHasWeaponNoModifier() {
        Item[] items = new Item[5];
        Set<ElementType> canAttack = new HashSet<>();
        canAttack.add(ElementType.AIR);
        canAttack.add(ElementType.WATER);


        Weapon weapon= new Weapon("name","description",3,2,canAttack);

        Human human = new Human("human",2,3,4,9,2,1,4,new Armour("name","description", ArmourType.HEAVY,2),weapon);
        for (int i = 0; i < 11; i++) {
            mainQuest.reportKill();
        }
        mainQuest.reportIntractableObject(new Chest(items, "Test"));


        assertNull(weapon.getModifier());
        mainQuest.receiveReward(human);
        assertTrue(mainQuest.isRewardReceived());
    }


}