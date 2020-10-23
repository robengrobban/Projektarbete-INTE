package se.su.dsv.inte.projektarbete.player;

/**
 * Class for modifying attack and defence values for different player races.
 */
public class RaceModifier {

    //Final instance variables.
    private final int PERCENT_ATTACK_MODIFIER;
    private final int PERCENT_MAGIC_ATTACK_MODIFIER;
    private final int PERCENT_DEFENCE_MODIFIER;
    private final int PERCENT_MAGIC_DEFENCE_MODIFIER;

    /**
     * Constructs the modifier with values for the physical and magical attack and defence values.
     * @param attackMod attack modifier in percent.
     * @param magicAttackMod Magic attack modifier in percent.
     * @param defenceMod Defence modifier in percent.
     * @param magicDefenceMod Magic defence modifier in percent.
     */
    public RaceModifier(int attackMod, int magicAttackMod, int defenceMod, int magicDefenceMod) {
        PERCENT_ATTACK_MODIFIER = attackMod;
        PERCENT_MAGIC_ATTACK_MODIFIER = magicAttackMod;
        PERCENT_DEFENCE_MODIFIER = defenceMod;
        PERCENT_MAGIC_DEFENCE_MODIFIER = magicDefenceMod;
    }

    /**
     * Gets the attack modifier (percent value).
     * @return The attack modifier.
     */
    public int getAttackModifier() { return PERCENT_ATTACK_MODIFIER; }

    /**
     * Gets the magic attack modifier (percent value).
     * @return The magic attack modifier.
     */
    public int getMagicAttackModifier() { return PERCENT_MAGIC_ATTACK_MODIFIER; }

    /**
     * Gets the defence modifier (percent value).
     * @return The defence modifier.
     */
    public int getDefenceModifier() { return PERCENT_DEFENCE_MODIFIER; }

    /**
     * Gets the magic defence modifier (percent value).
     * @return The magic defence modifier.
     */
    public int getMagicDefenceModifier() { return PERCENT_MAGIC_DEFENCE_MODIFIER; }

    /**
     * Modifies an attack with a percent of increase or decrease-modifier.
     * @param baseAttack Base attack value to be modified.
     * @return The modified attack.
     */
    public int modifyAttack(int baseAttack) {
        return baseAttack + baseAttack * PERCENT_ATTACK_MODIFIER / 100;
    }

    /**
     * Modifies an attack with a percent of increase or decrease-modifier.
     * @param baseAttack Base attack value to be modified.
     * @return The modified attack.
     */
    public int modifyMagicAttack(int baseAttack) {
        return baseAttack + baseAttack * PERCENT_MAGIC_ATTACK_MODIFIER / 100;
    }

    /**
     * Modifies an defence with a percent of increase or decrease-modifier.
     * @param baseDefence defence value to be modified.
     * @return The modified attack.
     */
    public int modifyDefence(int baseDefence) {
        return baseDefence + baseDefence * PERCENT_DEFENCE_MODIFIER / 100;
    }

    /**
     * Modifies a magic attack with a percent of increase or decrease-modifier.
     * @param baseDefence Base magic defence value to be modified.
     * @return The modified attack.
     */
    public int modifyMagicDefence(int baseDefence) {
        return baseDefence + baseDefence * PERCENT_MAGIC_DEFENCE_MODIFIER / 100;
    }
}
