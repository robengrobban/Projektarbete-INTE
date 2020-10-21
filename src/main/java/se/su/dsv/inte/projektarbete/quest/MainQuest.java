package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;
import se.su.dsv.inte.projektarbete.weapon.WeaponModifier;

public class MainQuest extends Quest {

    private int currentStage;
    private int enemiesKilled;
    private int enemiesKilledToNextStage;
    private boolean foundChest;
    private WeaponModifier reward;
    private boolean rewardReceived;



    @Override
    void reportKill() {
        enemiesKilled++;

    }

    @Override
    void reportIntractableObject(InteractableObject interactableObject) {

    }

    @Override
    void receiveReward(Player player) {

    }

    @Override
    void advanceToNextStage() {

    }
}
