package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class NonPlayerCharacter extends Character {
    private CharacterStateController controller;
    //TO-DO loot

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, StateType stateType) {
        super(name, armour, weapon);
    }

    public NonPlayerCharacter(String name, Armour armour, Weapon weapon, int health, int maxMana, StateType stateType) {
        super(name, armour, weapon, health, maxMana);
        controller = new CharacterStateController(stateType);
    }

    @Override
    public void damaged(int damage) {
        super.damaged(damage);

        if(getCurrentHealth() <= 0) {
            controller.setCurrentState(StateType.DEAD);
        }
    }
}
