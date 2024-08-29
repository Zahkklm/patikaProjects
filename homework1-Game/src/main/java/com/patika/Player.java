package com.patika;

import java.util.Random;

public class Player {
    private int health = 100;
    private Random random = new Random();

    public int attack() {
        return random.nextInt(10) + 1; // Player's attack damage
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Player has been defeated.");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}


