package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;

import java.util.List;

public class QuestManager {
    private final List<Quest> questList;

    public QuestManager(List<Quest> questList) {
        if (questList == null) {
            throw new IllegalArgumentException("The questList can not be null");
        } else {
            this.questList = questList;
        }

    }

    public void reportKillsToQuests() {
        questList.forEach(Quest::reportKill);
    }

    public void reportIntractableObject(InteractableObject interactableObject) {

        for (Quest quest : questList) {
            quest.reportIntractableObject(interactableObject);
        }

    }

    public void addQuest(Quest quest) {
        if (quest == null) {
            throw new IllegalArgumentException("The quest can not be null");
        } else {

            questList.add(quest);
        }

    }

    public void cancelQuest(Quest quest) {
        if (quest == null) {
            throw new IllegalArgumentException("The quest can not be null");
        } else {

            questList.remove(quest);
        }
    }

    public void receiveReward(Quest quest, Player player) {
        if (quest == null || player == null) {
            throw new IllegalArgumentException("The quest or player can not be null");
        } else {

            if (questList.contains(quest)) {
                quest.receiveReward(player);
            }
        }
    }

}
