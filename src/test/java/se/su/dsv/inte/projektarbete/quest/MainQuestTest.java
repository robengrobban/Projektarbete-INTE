package se.su.dsv.inte.projektarbete.quest;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.weapon.SimpleDamageModifier;

import static org.junit.jupiter.api.Assertions.*;

class MainQuestTest {

    MainQuest mainQuest = new MainQuest("Test Quest","Test",2,new SimpleDamageModifier("Test Damage Modifier",1,5));

    @Test
    void getMaxStages() {
        assertEquals(2,mainQuest.getMaxStages());

    }

    @Test
    void maxStageLessThanOne(){
        assertThrows(IllegalArgumentException.class, () -> new MainQuest("Test Quest","Test",0,new SimpleDamageModifier("Test Damage Modifier",1,5)));

    }
    @Test
    void maxStageGreaterThanTen(){
        assertThrows(IllegalArgumentException.class, () -> new MainQuest("Test Quest","Test",11,new SimpleDamageModifier("Test Damage Modifier",1,5)));

    }




    @Test
    void getName() {
        assertEquals("Test Quest",mainQuest.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Test",mainQuest.getDescription());

    }

    @Test
    void getEnemiesKilled() {
    }

    @Test
    void getCurrentStage() {
    }

    @Test
    void reportKill() {
    }

    @Test
    void reportIntractableObject() {
    }

    @Test
    void receiveReward() {
    }

    @Test
    void advanceToNextStage() {
    }
}