package se.su.dsv.inte.projektarbete.player;

/**
 * Class used to give warrior job functionality to a player.
 */
public class WarriorClass extends PlayerClass {

    /**
     * Constructs the warrior class by calling constructor in PlayerClass with specific values.
     */
    public WarriorClass() {
        super(10, 0,10, 0);
    }

    /**
     * Warriors cannot use magic.
     * @return False, always.
     */
    public boolean canUseMagic() { return false; }
}
