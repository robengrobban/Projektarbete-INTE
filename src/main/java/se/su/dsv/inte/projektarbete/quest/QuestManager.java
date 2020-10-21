package se.su.dsv.inte.projektarbete.quest;

import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;

import java.util.List;

public class QuestManager {
    private List<Quest> questList;


    private void reportKillsToQuests() {
        questList.forEach(Quest::reportKill);
    }

    private void reportIntractableObject(InteractableObject interactableObject) {


        for (Quest quest : questList) {
            quest.reportIntractableObject(interactableObject);
        }


    }

    private void addQuest(Quest quest) {
        questList.add(quest);
    }

    private void cancelQuest(Quest quest) {
        questList.remove(quest);
    }

    private void receiveReward(Quest quest, Player player) {

    }

}
