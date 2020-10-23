package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;

public abstract class Quest {

    private final String name;
    private final String description;
    private final int maxStages;

    public Quest(String name, String description, int maxStages) {
        this.name = name;
        this.description = description;
        if (maxStages < 1 || maxStages > 10) {
            throw new IllegalArgumentException("The max stage must be between 1-10");
        } else {

            this.maxStages = maxStages;
        }
    }

    public int getMaxStages() {
        return maxStages;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    abstract void reportKill();

    abstract void reportIntractableObject(InteractableObject interactableObject);

    abstract void receiveReward(Player player);

    abstract void advanceToNextStage();


}
