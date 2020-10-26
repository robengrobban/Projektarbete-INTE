package se.su.dsv.inte.projektarbete.player;

/**
 * Class used to give magician job functionality to a player.
 */
public class MagicianClass extends PlayerClass {

    /**
     * Constructs the magician class by calling constructor in PlayerClass with specific values.
     */
    public MagicianClass() {
        super(-5, 15, -5, 15);
    }

    /**
     * Used to tell that the player can use magic if they have this class even if the player race cannot.
     * @return
     */
    public boolean canUseMagic() { return true; }
}
