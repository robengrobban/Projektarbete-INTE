package se.su.dsv.inte.projektarbete.player;

public abstract class PlayerClass {
    private int attackModifier;
    private int magicAttackModifier;
    private int defenceModifier;
    private int magicDefenceModifier;

    /**
     * Constructor for only setting attack and defence.
     * @param attackModifier
     * @param defenceModifier
     */
    public PlayerClass(int attackModifier, int defenceModifier) {
        this.attackModifier = attackModifier;
        this.defenceModifier = defenceModifier;
    }

    /**
     * Construcor for setting all modifier values.
     * @param attackModifier
     * @param magicAttackModifier
     * @param defenceModifier
     * @param magicDefenceModifier
     */
    public PlayerClass(int attackModifier, int magicAttackModifier, int defenceModifier, int magicDefenceModifier) {
        this.attackModifier = attackModifier;
        this.magicAttackModifier = magicAttackModifier;
        this.defenceModifier = defenceModifier;
        this.magicDefenceModifier = magicDefenceModifier;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public int getMagicAttackModifier() {
        return magicAttackModifier;
    }

    public int getMagicDefenceModifier() {
        return magicDefenceModifier;
    }

    public abstract boolean canUseMagic();
}
