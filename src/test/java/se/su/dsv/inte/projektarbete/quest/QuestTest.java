package se.su.dsv.inte.projektarbete.quest;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.map.InteractableObject;
import se.su.dsv.inte.projektarbete.player.Player;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {

    @Test
    void maxStageBiggerThanTen(){
        assertThrows(IllegalArgumentException.class,()-> new Quest("t", "d", 20) {
            @Override
            void reportKill() {

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
        });
    }

    @Test
    void getName() {
        Quest quest = new Quest("t", "d", 6) {
            @Override
            void reportKill() {

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
        };
        assertEquals("t",quest.getName());
    }

    @Test
    void getDescription() {
        Quest quest = new Quest("t", "d", 6) {
            @Override
            void reportKill() {

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
        };
        assertEquals("d",quest.getDescription());
    }
}