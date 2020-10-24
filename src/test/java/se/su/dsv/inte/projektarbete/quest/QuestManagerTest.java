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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuestManagerTest {

    @Test
    void questListNull() {
        assertThrows(IllegalArgumentException.class, () -> new QuestManager(null));
    }

    @Test
    void reportKillNoQuestAdded() {
        List<Quest> questList = new ArrayList<>();
        QuestManager questManager = new QuestManager(questList);
        questManager.reportKillsToQuests();

    }

    @Test
    void reportKillOneQuestAdded() {
        List<Quest> questList = new ArrayList<>();
        MainQuest quest = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        questList.add(quest);
        QuestManager questManager = new QuestManager(questList);
        questManager.reportKillsToQuests();
        questManager.reportKillsToQuests();

        assertEquals(2, quest.getEnemiesKilled());
    }

    @Test
    void reportKillTwoQuestAdded() {
        List<Quest> questList = new ArrayList<>();
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        MainQuest questTwo = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));

        questList.add(questOne);
        questList.add(questTwo);
        QuestManager questManager = new QuestManager(questList);
        questManager.reportKillsToQuests();
        questManager.reportKillsToQuests();

        assertEquals(2, questOne.getEnemiesKilled());
        assertEquals(2, questTwo.getEnemiesKilled());

    }



    @Test
    void reportIntractableObjectChest() {
        List<Quest> questList = new ArrayList<>();
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));

        questList.add(questOne);
        QuestManager questManager = new QuestManager(questList);
        Item[] items = new Item[5];
        questManager.reportIntractableObject(new Chest(items, "test"));

        assertTrue(questOne.isFoundChest());

    }

    @Test
    void reportIntractableObjectChestForTwoQuest() {
        List<Quest> questList = new ArrayList<>();
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        MainQuest questTwo = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));

        questList.add(questOne);
        questList.add(questTwo);

        QuestManager questManager = new QuestManager(questList);
        Item[] items = new Item[5];
        questManager.reportIntractableObject(new Chest(items, "test"));

        assertTrue(questOne.isFoundChest());
        assertTrue(questTwo.isFoundChest());


    }

    @Test
    void reportIntractableObjectNoChestForTwoQuest() {
        List<Quest> questList = new ArrayList<>();
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        MainQuest questTwo = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));

        questList.add(questOne);
        questList.add(questTwo);

        QuestManager questManager = new QuestManager(questList);
        Item[] items = new Item[5];
        questManager.reportIntractableObject(new InteractableObject("test") {
        });

        assertFalse(questOne.isFoundChest());
        assertFalse(questTwo.isFoundChest());


    }

    @Test
    void addQuestNull() {
        List<Quest> questList = new ArrayList<>();


        QuestManager questManager = new QuestManager(questList);

        assertThrows(IllegalArgumentException.class, () -> questManager.addQuest(null));

    }

    @Test
    void addQuest() {
        List<Quest> questList = new ArrayList<>();
        QuestManager questManager = new QuestManager(questList);
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        questManager.addQuest(questOne);
        questManager.reportKillsToQuests();
        assertEquals(1, questOne.getEnemiesKilled());

    }

    @Test
    void cancelQuestNull() {
        List<Quest> questList = new ArrayList<>();


        QuestManager questManager = new QuestManager(questList);

        assertThrows(IllegalArgumentException.class, () -> questManager.cancelQuest(null));
    }

    @Test
    void cancelQuest() {
        List<Quest> questList = new ArrayList<>();
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));

        QuestManager questManager = new QuestManager(questList);
        questManager.addQuest(questOne);
        questManager.cancelQuest(questOne);
        questManager.reportKillsToQuests();


        assertEquals(0, questOne.getEnemiesKilled());
    }

    @Test
    void receiveRewardQuestAndPlayerNull() {
        List<Quest> questList = new ArrayList<>();
        QuestManager questManager = new QuestManager(questList);
        assertThrows(IllegalArgumentException.class, () -> questManager.receiveReward(null, null));

    }

    @Test
    void receiveReward() {
        List<Quest> questList = new ArrayList<>();
        QuestManager questManager = new QuestManager(questList);
        MainQuest questOne = new MainQuest("name", "description", 2, new SimpleDamageModifier("test", 1, 1));
        questManager.addQuest(questOne);
        for (int i = 0; i < 11; i++) {

            questManager.reportKillsToQuests();
        }
        Item[] items = new Item[5];

        questManager.reportIntractableObject(new Chest(items, "test"));

        Set<ElementType> canAttack = new HashSet<>();
        canAttack.add(ElementType.AIR);
        canAttack.add(ElementType.WATER);

        Weapon weapon = new Weapon("name", "description", 3, 2, canAttack);

        Human human = new Human("human", 2, 3, 4, 9, 2, 1, 4, 1, 1, new Armour("name", "description", ArmourType.HEAVY, 2), weapon);
        questManager.receiveReward(questOne, human);
        Weapon humanWeapon = human.getWeapon();
        assertEquals(new SimpleDamageModifier("test", 1, 1), humanWeapon.getModifier());


    }


}