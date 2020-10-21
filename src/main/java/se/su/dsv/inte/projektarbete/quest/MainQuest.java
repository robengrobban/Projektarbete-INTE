package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.Chest;
import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;
import se.su.dsv.inte.projektarbete.weapon.Weapon;
import se.su.dsv.inte.projektarbete.weapon.WeaponModifier;

public class MainQuest extends Quest {

    private int currentStage;
    private int enemiesKilled;
    private final int enemiesKilledToNextStage;
    private boolean foundChest;
    private final WeaponModifier reward;
    private boolean rewardReceived;

    /**
     *
     * @param maxStages how many stages the Quest have.
     * @param reward in case of finishing the quest.
     */
    public MainQuest(String name, String description, int maxStages, WeaponModifier reward) {
        super(name, description, maxStages);
        this.currentStage = 1;
        this.enemiesKilledToNextStage = 10;
        this.reward = reward;


    }



    @Override
    void reportKill() {
        if (currentStage == 1) {
            enemiesKilled++;
            if (enemiesKilled == enemiesKilledToNextStage) {
                advanceToNextStage();
            }
        }



    }

    @Override
    void reportIntractableObject(InteractableObject interactableObject) {
        if (interactableObject instanceof Chest)
            foundChest = true;
    }

    @Override
    void receiveReward(Player player) {
        if (!rewardReceived &&  currentStage == 2 && foundChest) {
            Weapon weapon = player.getWeapon();
            if (weapon != null && weapon.getModifier() == null) {
                weapon.setModifier(reward);
                rewardReceived = true;
            }
        }


    }

    @Override
    void advanceToNextStage() {

        if (currentStage < getMaxStages()) {
            currentStage++;
        }

    }
}
