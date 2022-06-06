package com.example.challenge.util;

import com.example.challenge.model.Game;
import com.example.challenge.model.Team;
import com.example.challenge.state.StateMachine;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author German Magana
 * <p>
 * This class has all the generic methods to be used throught the application
 */
public class GameUtil {

    private GameUtil() {
    }

    public static String getName(String slot1) {
        return slot1.substring(0, slot1.length() - 1);
    }

    public static Integer getScore(String slot1) {
        return Integer.valueOf(slot1.substring(slot1.length() - 1, slot1.length()));
    }

    public static void printMessage(String s) {
        System.out.println(s);
    }

    public static void selectStateMachine(Scanner scan, StateMachine stateMachine,
        Optional<List<Game>> games) {
        boolean stateSelected = false;

        while (scan.hasNext() && !stateSelected) {
            int option = scan.nextInt();
            if (option == 1) {
                stateMachine.setState(stateMachine.getStdinState());
                stateMachine.getState().process(games);
                stateSelected = true;
            } else if (option == 2) {
                stateMachine.setState(stateMachine.getFileNameState());
                stateMachine.getState().process(games);
                stateSelected = true;

            } else if (option == 3) {
                stateMachine.setState(stateMachine.getExitState());
                stateMachine.getState().process(games);
                stateSelected = true;

            } else {
                stateMachine.setState(stateMachine.getInvalidState());
                stateSelected = true;

            }
        }
    }


    public static void exit(String line, StateMachine stateMachine, List<Game> games) {
        if (line.equalsIgnoreCase("-exit")) {
            stateMachine.setState(stateMachine.getExitState());
            stateMachine.getState().process(Optional.of(games));
            System.exit(0);
        }
    }

    public static Optional<Game> createGame(String line) {
        String[] split = line.split(",");

        if (split.length > 1) {
            String slot1 = split[0];
            String slot2 = split[1];
            Team team1 = new Team(GameUtil.getName(slot1), GameUtil.getScore(slot1));
            Team team2 = new Team(GameUtil.getName(slot2), GameUtil.getScore(slot2));

            team1.setPoints(GameUtil.calculatePoints(team1, team2));
            team2.setPoints(GameUtil.calculatePoints(team2, team1));

            return Optional.of(new Game(team1, team2));

        }
        return Optional.empty();
    }

    public static int calculatePoints(Team team1, Team team2) {
        return team1.getScore() > team2.getScore() ?
            3 :
            team1.getScore() == team2.getScore() ? 1 : 0;
    }

    public static Map<String, Integer> groupByTeam1(List<Game> games) {

        List<Team> collect = games.stream().map(Game::getTeam1).collect(Collectors.toList());

        return collect.stream()
            .collect(Collectors.groupingBy(Team::getName, Collectors.summingInt(Team::getPoints)));

    }

    public static Map<String, Integer> groupByTeam2(List<Game> games) {

        List<Team> collect = games.stream().map(Game::getTeam2).collect(Collectors.toList());

        return collect.stream()
            .collect(Collectors.groupingBy(Team::getName, Collectors.summingInt(Team::getPoints)));

    }

    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> team1Map) {
        return team1Map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new));
    }

    public static void printMap(Map<String, Integer> map) {
        int index = 1;
        for (String key : map.keySet()) {

            System.out.println(index + ". " + key + ", " + map.get(key) + " pts");
            index++;
        }
    }
}
