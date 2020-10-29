package se.su.dsv.inte.projektarbete.player;

public abstract class PlayerClass {
    private final int ATTACK_MODIFIER;
    private final int MAGIC_ATTACK_MODIFIER;
    private final int DEFENCE_MODIFIER;
    private final int MAGIC_DEFENCE_MODIFIER;

    /**
     * Constructor for setting all modifier values.
     * @param attackModifier Modifier value for attack.
     * @param magicAttackModifier Modifier value for magic attack.
     * @param defenceModifier Modifier value for defence.
     * @param magicDefenceModifier Modifier value for magic defence.
     */
    public PlayerClass(int attackModifier, int magicAttackModifier, int defenceModifier, int magicDefenceModifier) {
        this.ATTACK_MODIFIER = attackModifier;
        this.MAGIC_ATTACK_MODIFIER = magicAttackModifier;
        this.DEFENCE_MODIFIER = defenceModifier;
        this.MAGIC_DEFENCE_MODIFIER = magicDefenceModifier;
    }

    /**
     * Gets the modifier for the attack.
     * @return Attack modifier
     */
    public int getATTACK_MODIFIER() {
        return ATTACK_MODIFIER;
    }

    /**
     * Gets the modifier for the defence.
     * @return Defence modifier
     */
    public int getDEFENCE_MODIFIER() {
        return DEFENCE_MODIFIER;
    }

    /**
     * Gets the modifier for the magic attack
     * @return Magic attack modifier
     */
    public int getMAGIC_ATTACK_MODIFIER() {
        return MAGIC_ATTACK_MODIFIER;
    }

    /**
     * Gets the modifier for the magic defence.
     * @return Magic defence modifier
     */
    public int getMAGIC_DEFENCE_MODIFIER() {
        return MAGIC_DEFENCE_MODIFIER;
    }

    /**
     * Returns of player with job class can use magic or not.
     * @return True if can use magic, else false.
     */
    public abstract boolean canUseMagic();
}
