package com.patika;

import java.util.Random;

public class Monster {
    private int health = 50;
    private Random random = new Random();

    public int attack() {
        return random.nextInt(6) + 3; // Monster's attack damage
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Monster has been defeated.");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}