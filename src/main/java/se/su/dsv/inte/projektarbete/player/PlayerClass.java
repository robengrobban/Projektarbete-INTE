package se.su.dsv.inte.projektarbete.player;

public abstract class PlayerClass {
    int attackModifier;
    int defenceModifier;

    public PlayerClass(int attackModifier, int defenceModifier) {
        this.attackModifier = attackModifier;
        this.defenceModifier = defenceModifier;
    }
}
