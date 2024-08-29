package com.patika;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class FixtureGenerator {

    private List<String> teams;
    private List<String> rounds;

    public FixtureGenerator(List<String> teams) {
        this.teams = new ArrayList<>(teams);
        if (this.teams.size() % 2 != 0) {
            this.teams.add("Bay");
        }
        this.rounds = new ArrayList<>();
        generateFixtures();
    }

    private void generateFixtures() {
        int numTeams = teams.size();
        int numRounds = (numTeams - 1) * 2;

        for (int round = 0; round < numRounds; round++) {
            List<String> roundMatches = new ArrayList<>();
            for (int i = 0; i < numTeams / 2; i++) {
                String home = teams.get(i);
                String away = teams.get(numTeams - 1 - i);
                if (round % 2 == 0) {
                    roundMatches.add(home + " vs " + away);
                } else {
                    roundMatches.add(away + " vs " + home);
                }
            }
            rounds.add("Round " + (round + 1) + "\n" + String.join("\n", roundMatches));
            rotateTeams();
        }
    }

    private void rotateTeams() {
        String last = teams.remove(teams.size() - 1);
        teams.add(1, last);
    }

    public void printFixtures() {
        for (String round : rounds) {
            System.out.println(round + "\n");
        }
    }

    public static void main(String[] args) {
        List<String> teams = Arrays.asList("Galatasaray", "Bursaspor", "Fenerbahçe", "Beşiktaş", "Başakşehir", "Trabzonspor");
        FixtureGenerator fixtureGenerator = new FixtureGenerator(teams);
        fixtureGenerator.printFixtures();
    }
}
