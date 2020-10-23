package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class Elf extends Player{

    private RaceModifier raceModifier;

    public Elf(String name) {
        super(name);
        setRaceModifier();
    }

    public Elf(String name, int health, int maxMana, int damage,
               int defence, int attack, int magicDefence, int magicAttack, int experience, int level, Armour armour, Weapon weapon) {
        super(name, health, maxMana, damage, defence, attack, magicDefence, magicAttack, experience, level, weapon, armour, null, null);
        setRaceModifier();
    }

    private void setRaceModifier() {
        raceModifier = new RaceModifier(-5, 10, -15, 10);
    }

    public int getTotalDefence(int damage) {
        int baseDefence = super.getTotalDefence(damage);
        return raceModifier.modifyDefence(baseDefence);
    }

    public int getTotalMagicDefence(int damage) {
        int baseDefence = super.getTotalDefence(damage);
        return raceModifier.modifyMagicDefence(baseDefence);
    }

    public boolean canUseMagic() {
        return true;
    }
}
