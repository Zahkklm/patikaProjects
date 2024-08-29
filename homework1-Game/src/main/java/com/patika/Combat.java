package com.patika;

import java.util.Random;

public class Combat {
    private Random random = new Random();

    public void engageCombat(Player player, Monster monster) {
        if (random.nextBoolean()) {
            playerAttack(player, monster);
            if (monster.isAlive()) {
                monsterAttack(player, monster);
            }
        } else {
            monsterAttack(player, monster);
            if (player.isAlive()) {
                playerAttack(player, monster);
            }
        }
    }

    private void playerAttack(Player player, Monster monster) {
        int damage = player.attack();
        monster.takeDamage(damage);
        System.out.println("Player attacks monster for " + damage + " damage.");
    }

    private void monsterAttack(Player player, Monster monster) {
        int damage = monster.attack();
        player.takeDamage(damage);
        System.out.println("Monster attacks player for " + damage + " damage.");
    }
}
