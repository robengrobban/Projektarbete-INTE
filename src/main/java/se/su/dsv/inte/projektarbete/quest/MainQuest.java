package se.su.dsv.inte.projektarbete.quest;

public class MainQuest extends Quest {

    private int characterToKill;
    //5 stages with 10 more Character to kill in the next Stage;
    private int stage;

    public MainQuest(int stage) {
        if (stage < 1 || stage > 5) {
            throw new IllegalArgumentException("The stage must be between 1-5!");
        } else {

            this.stage = stage;
            this.characterToKill = 90 + 10 * stage;
        }
    }

    public int getCharacterToKill() {
        return characterToKill;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return "MainQuest{" +
                "characterToKill=" + characterToKill +
                ", stage=" + stage +
                '}';
    }
}
