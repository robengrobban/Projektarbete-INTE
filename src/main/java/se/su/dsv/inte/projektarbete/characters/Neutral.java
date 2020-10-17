package se.su.dsv.inte.projektarbete.characters;

public class Neutral extends Character {
    public Neutral(String name) {
        super(name, ThreatLevel.NEUTRAL);
    }

    private void switchThreatLevel() {
        if(getThreatLevel() == ThreatLevel.NEUTRAL) {
            setThreatLevel(ThreatLevel.HOSTILE);
        }

        else {
            setThreatLevel(ThreatLevel.NEUTRAL);
        }
    }
}
