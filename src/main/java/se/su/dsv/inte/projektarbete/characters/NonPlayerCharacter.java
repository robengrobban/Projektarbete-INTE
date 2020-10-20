package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class NonPlayerCharacter extends Character {
    private CharacterStateController controller;

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, StateType stateType) {
        super(name, armour, weapon);
        controller = new CharacterStateController(stateType);
    }

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, int health, int maxMana, StateType stateType) {
        super(name, armour, weapon, health, maxMana);
        controller = new CharacterStateController(stateType);
    }
}
