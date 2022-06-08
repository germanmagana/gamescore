package com.example.challenge.util;

import com.example.challenge.model.Game;
import com.example.challenge.model.Team;
import com.example.challenge.state.StateMachine;
import org.apache.commons.lang.StringUtils;

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

    /**
     * This method gets the team name from this data format Lions 3
     * @param slot1
     * @return
     */
    public static String getName(String slot1) {
        return StringUtils.trimToEmpty(slot1.substring(0, slot1.length() - 1));
    }

    /**
     * This method gets the team score from this data format Lions 3
     * @param slot1
     * @return
     */
    public static Integer getScore(String slot1) {
        return Integer.valueOf(slot1.substring(slot1.length() - 1, slot1.length()));
    }


    /**
     * This method exist from the app when the user enters -exist
     * @param line
     * @param stateMachine
     * @param games
     */
    public static void exit(String line, StateMachine stateMachine, List<Game> games) {
        if (line.equalsIgnoreCase("-exit")) {
            stateMachine.setState(stateMachine.getExitState());
            stateMachine.getState().process(Optional.of(games));
            System.exit(0);
        }
    }

    /**
     * This method creates a game object from the format data Lions 3, Snakes 3
     * @param line
     * @return
     */
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

    /**
     * This method calculates the points win for the team
     * @param team1
     * @param team2
     * @return
     */
    public static int calculatePoints(Team team1, Team team2) {
        return team1.getScore() > team2.getScore() ?
            3 :
            team1.getScore() == team2.getScore() ? 1 : 0;
    }

    /**
     * This method sum the points of the games for the team1
     * @param games
     * @return
     */
    public static Map<String, Integer> groupByTeam1(List<Game> games) {

        List<Team> collect = games.stream().map(Game::getTeam1).collect(Collectors.toList());

        return collect.stream()
            .collect(Collectors.groupingBy(Team::getName, Collectors.summingInt(Team::getPoints)));

    }

    /**
     * This method sum the points of the games for the team2
     * @param games
     * @return
     */
    public static Map<String, Integer> groupByTeam2(List<Game> games) {

        List<Team> collect = games.stream().map(Game::getTeam2).collect(Collectors.toList());

        return collect.stream()
            .collect(Collectors.groupingBy(Team::getName, Collectors.summingInt(Team::getPoints)));

    }

    /**
     * This method sorts the team that has more points
     * @param team1Map
     * @return
     */
    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> team1Map) {
        return team1Map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new));
    }


}
