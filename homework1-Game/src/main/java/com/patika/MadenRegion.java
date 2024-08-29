package com.patika;

import java.util.Random;

public class MadenRegion {
    private Random random = new Random();

    public void enterMaden(Player player) {
        int numberOfSnakes = random.nextInt(5) + 1; // 1 to 5 snakes
        System.out.println("You encounter " + numberOfSnakes + " snakes in the Maden region.");

        // Assuming the player wins the combat
        System.out.println("You've defeated the snakes!");
        lootDrop();
    }

    private void lootDrop() {
        int lootChance = random.nextInt(100) + 1;
        if (lootChance <= 15) {
            System.out.println("You find a Weapon!");
        } else if (lootChance <= 35) {
            System.out.println("You find a Rifle!");
        } else if (lootChance <= 65) {
            System.out.println("You find a Sword!");
        } else if (lootChance <= 100) {
            System.out.println("You find a Pistol!");
        } else if (lootChance <= 15) {
            System.out.println("You find Armor!");
        } else if (lootChance <= 35) {
            System.out.println("You find Heavy Armor!");
        } else if (lootChance <= 65) {
            System.out.println("You find Medium Armor!");
        } else if (lootChance <= 100) {
            System.out.println("You find Light Armor!");
        } else if (lootChance <= 25) {
            System.out.println("You find 10 Coins!");
        } else if (lootChance <= 55) {
            System.out.println("You find 5 Coins!");
        } else if (lootChance <= 100) {
            System.out.println("You find 1 Coin!");
        } else {
            System.out.println("You find nothing.");
        }
    }
}
