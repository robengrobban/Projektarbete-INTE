package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapons.Weapon;

public class NonPlayerCharacter extends Character {
    private CharacterStateController controller;

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, State state) {
        super(name, armour, weapon);
        controller = new CharacterStateController(state);
    }

    public NonPlayerCharacter(String name, Armour armour, int baseDamage, State state) {
        super(name, armour, baseDamage);
        controller = new CharacterStateController(state);
    }
}
