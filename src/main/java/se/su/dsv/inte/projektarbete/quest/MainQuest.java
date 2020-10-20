package se.su.dsv.inte.projektarbete.quest;

public class MainQuest  {

    private final int characterToKill;
    private final int stage;

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
