package org.example;
public class Mage extends GameCharacter {
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    @Override
    public void attack(GameCharacter target) {
        if (!isAlive()) {
            throw new IllegalStateException(
                    getName() + " is defeated and cannot attack."
            );
        }
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }
        if (!target.isAlive()) {
            throw new IllegalStateException(
                    target.getName() + " is already defeated."
            );
        }
        System.out.println(
                getName() + " casts a spell at " + target.getName() + "!"
        );
        target.takeDamage(getAttackPower());
    }
}
