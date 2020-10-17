package se.su.dsv.inte.projektarbete.armour;

/**
 * Enum that represents the armour type.
 */
public enum ArmourType {

    LIGHT(1),
    MEDIUM(2),
    HEAVY(3);

    private int factor;

    ArmourType(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return this.factor;
    }

}
