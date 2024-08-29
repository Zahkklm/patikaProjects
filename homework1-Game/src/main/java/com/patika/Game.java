package com.patika;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Set<String> visitedRegions = new HashSet<>();
    private Set<String> rewards = new HashSet<>();
    private boolean gameWon = false;

    public void visitRegion(String region) {
        if (visitedRegions.contains(region)) {
            System.out.println("You have already visited this region.");
            return;
        }
        visitedRegions.add(region);
        if (region.equals("Cave")) {
            rewards.add("Food");
        } else if (region.equals("Forest")) {
            rewards.add("Firewood");
        } else if (region.equals("River")) {
            rewards.add("Water");
        }
        System.out.println("Reward from " + region + ": " + rewards);
        checkVictory();
    }

    private void checkVictory() {
        if (rewards.contains("Food") && rewards.contains("Firewood") && rewards.contains("Water")) {
            gameWon = true;
            System.out.println("Congratulations! You've collected all rewards and won the game.");
        }
    }

    public boolean isGameWon() {
        return gameWon;
    }
}
