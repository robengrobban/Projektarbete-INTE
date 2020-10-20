package se.su.dsv.inte.projektarbete.quest;

public class OptionalQuest {
    private int treasureToFind;

    public OptionalQuest(int treasureToFind) {
        if (treasureToFind < 1 || treasureToFind > 5) {
            throw new IllegalArgumentException("The stage must be between 1-5!");
        } else {

            this.treasureToFind = treasureToFind;
        }
    }
    public void treasureFound(){
        if (treasureToFind != 0) treasureToFind--;
    }
}
