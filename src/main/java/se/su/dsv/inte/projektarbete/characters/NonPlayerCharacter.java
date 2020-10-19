package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapons.Weapon;

public class NonPlayerCharacter extends Character {
    private CharacterStateController controller;

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, StateType stateType) {
        super(name, armour, weapon);
        controller = new CharacterStateController(stateType);
    }

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, int health, StateType stateType) {
        super(name, armour, weapon, health);
        controller = new CharacterStateController(stateType);
    }
}
