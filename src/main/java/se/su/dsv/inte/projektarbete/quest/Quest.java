package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;

public abstract class Quest {

    private QuestManager questManager;
    private String name;
    private String description;
    private int stages;

    abstract void reportKill();

    abstract void reportIntractableObject(InteractableObject interactableObject);

    abstract void receiveReward(Player player);

    abstract void advanceToNextStage();
}
