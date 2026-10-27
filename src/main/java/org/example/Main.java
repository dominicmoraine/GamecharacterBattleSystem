package org.example;
public class Main {
    public static void main(String[] args) {
        System.out.println("Game character battle system");
        System.out.println("-------------------------\n");
        Warrior warrior = new Warrior("Dominic", 100, 20);
        Mage mage = new Mage("Mage", 80, 25);
        Archer archer = new Archer("Archer", 90, 15);
        System.out.println("Starting Characters:");
        warrior.displayInfo();
        mage.displayInfo();
        archer.displayInfo();

        System.out.println("Battle Begins!\n");

        runBattleAction(() -> warrior.attack(mage));
        System.out.println();
        runBattleAction(() -> mage.attack(archer));
        System.out.println();

        runBattleAction(() -> archer.attack(warrior));

        System.out.println("\nUpdated Characters:");
        warrior.displayInfo();
        mage.displayInfo();
        archer.displayInfo();

        System.out.println("Testing Invalid Actions:");

        runBattleAction(() -> new Warrior(" ", 100, 20));
        runBattleAction(() -> new Mage("Invalid Mage", 0, 25));
        runBattleAction(() -> warrior.takeDamage(-5));
    }

    private static void runBattleAction(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
