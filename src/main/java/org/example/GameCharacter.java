package org.example;

public class GameCharacter {
    private final String name;
    private int health;
    private final int attackPower;
    public GameCharacter(String name, int health, int attackPower) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Character name cannot be blank.");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Starting health must be greater than zero.");
        }
        if (attackPower <= 0) {
            throw new IllegalArgumentException("Attack power must be greater than zero");
        }

        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative.");
        }
        if (!isAlive()) {
            throw new IllegalStateException(name + " is already defeated");
        }
        health = Math.max(0, health - damage);
        System.out.println(name + " takes " + damage + " damage.");
        System.out.println(name + "'s health is now " + health + ".");
        if (!isAlive()) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void attack(GameCharacter target) {
        if (!isAlive()) {
            throw new IllegalStateException(name + " is defeated and cannot attack.");
        }
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }
        if (!target.isAlive()) {
            throw new IllegalStateException(target.getName() + " is already defeated.");
        }
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attackPower);
    }
    public void displayInfo() {
        System.out.println(getClass().getSimpleName() + ": " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println();
    }
}
