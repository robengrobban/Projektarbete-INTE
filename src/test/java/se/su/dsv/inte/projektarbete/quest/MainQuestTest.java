package se.su.dsv.inte.projektarbete.quest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainQuestTest {

    @Test
    void CharacterToKillForFirstStage() {
        MainQuest hundredCharacterToKill = new MainQuest(1);
        assertEquals(100, hundredCharacterToKill.getCharacterToKill());
    }

    @Test
    void CharacterToKillForSecondStage() {
        MainQuest hundredTenCharacterToKill = new MainQuest(2);
        assertEquals(110, hundredTenCharacterToKill.getCharacterToKill());
    }

    @Test
    void CharacterToKillForThirdStage() {
        MainQuest hundredTwentyCharacterToKill = new MainQuest(3);
        assertEquals(120, hundredTwentyCharacterToKill.getCharacterToKill());
    }

    @Test
    void CharacterToKillForForthStage() {
        MainQuest hundredThirtyCharacterToKill = new MainQuest(4);
        assertEquals(130, hundredThirtyCharacterToKill.getCharacterToKill());
    }

    @Test
    void CharacterToKillForFifthStage() {
        MainQuest hundredFortyCharacterToKill = new MainQuest(5);
        assertEquals(140, hundredFortyCharacterToKill.getCharacterToKill());
    }

    @Test
    void stageLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new MainQuest(-1));

    }

    @Test
    void stageMoreThanFive() {
        assertThrows(IllegalArgumentException.class, () -> new MainQuest(6));


    }

}