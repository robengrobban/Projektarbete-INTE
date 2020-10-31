package se.su.dsv.inte.projektarbete;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.map.Chest;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.map.MapPoint;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.player.Elf;
import se.su.dsv.inte.projektarbete.quest.MainQuest;
import se.su.dsv.inte.projektarbete.quest.Quest;
import se.su.dsv.inte.projektarbete.quest.QuestManager;
import se.su.dsv.inte.projektarbete.weapon.SimpleDamageModifier;
import se.su.dsv.inte.projektarbete.weapon.Weapon;
import se.su.dsv.inte.projektarbete.characters.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ProfilerTest {

    // Class Variables
    private static final int MAP_SIZE = 5000;
    private static final int PLAYER_CREATE_COUNT = 10000;
    private static final int PLAYER_WEAPON_SWAP = 10000;
    private static final int ATTACK_TIMES = 10000;
    private static final int QUEST_MANAGER_CREATE_COUNT = 2000;
    private static final int QUEST_ASSIGN_COUNT = 5000;
    private static final int QUEST_SIMULATE_KILL_COUNT = 10000;
    private static final int QUEST_SIMULATE_OPEN_CHEST_COUNT = 2000;

    // Instance Variables
    private Map map;
    private Elf player;
    private QuestManager questManager;
    private Quest[] quests = new Quest[QUEST_ASSIGN_COUNT];

    public static void main(String[] args) {
        new ProfilerTest();
    }

    // Constructor
    public ProfilerTest() {

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        createMap();
        createPlayers();
        swapWeapons();
        performAttacks();
        createQuestManager();
        acceptQuests();
        questSimulateKill();
        questSimulateOpenChest();
        questSimulateReceiveReward();
    }

    // Methods
    private void createMap() {
        map = new Map(MAP_SIZE, MAP_SIZE);
    }

    private void createPlayers() {
        for (int i = 0; i < PLAYER_CREATE_COUNT; i++) {
            player = new Elf("Player");
        }
    }

    private void swapWeapons() {
        for (int i = 0; i < PLAYER_WEAPON_SWAP; i++) {
            Weapon sword = new Weapon("Sword", "Bad Sword", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
            player.setWeapon(sword);
        }
    }

    private void performAttacks() {
        map.placeCharacter(player, 0, 0);
        Character target = new Character("Target", new Armour("Helmet", "Bad Helmet", ArmourType.LIGHT, 10), null);
        map.placeCharacter(target, 1, 1);

        for (int i = 0; i < ATTACK_TIMES; i++) {
            player.attack(target);

            target.changeCurrentHealth(target.getMaxHealth());
        }
    }

    private void createQuestManager() {
        for (int i = 0; i < QUEST_MANAGER_CREATE_COUNT; i++) {
            questManager = new QuestManager(new ArrayList<>());
        }
    }

    private void acceptQuests() {
        for (int i = 0; i < QUEST_ASSIGN_COUNT; i++) {
            MainQuest mq = new MainQuest("Quest", "A nice Quest", 2, new SimpleDamageModifier("Damage", 10, 20));
            quests[i] = mq;
            questManager.addQuest(mq);
        }
    }

    private void questSimulateKill() {
        for (int i = 0; i < QUEST_SIMULATE_KILL_COUNT; i++) {
            questManager.reportKillsToQuests();
        }
    }

    private void questSimulateOpenChest() {
        for (int i = 0; i < QUEST_SIMULATE_OPEN_CHEST_COUNT; i++) {
            questManager.reportIntractableObject(new Chest(new Item[1], "Chest", new MapPoint(new Ground(), 2, 2)));
        }
    }

    private void questSimulateReceiveReward() {
        for (int i = 0; i < QUEST_ASSIGN_COUNT; i++) {
            questManager.receiveReward(quests[i], player);
        }
    }

}
