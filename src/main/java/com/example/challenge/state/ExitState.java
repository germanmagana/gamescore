package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.util.ConsoleUtil;
import com.example.challenge.util.GameUtil;

import java.util.*;

/**
 * @author German Magana
 *
 * This class terminates the application execution and prints the game results
 */
public class ExitState implements State {

    private StateMachine stateMachine;

    public ExitState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    /**
     * This mehod process the state machine
     * @param games
     */
    @Override
    public void process(Optional<List<Game>> games) {

        if (games.isPresent()) {
            ConsoleUtil.print("Teams scare");
            Map<String, Integer> team1Map = GameUtil.groupByTeam1(games.get());
            Map<String, Integer> team2Map = GameUtil.groupByTeam2(games.get());
            team1Map.putAll(team2Map);

            LinkedHashMap<String, Integer> sortedMap =
                GameUtil.sortMapByValue(team1Map);

            ConsoleUtil.printMap(sortedMap);

        } else {
            ConsoleUtil.print("There is not score for the teams");
        }

        ConsoleUtil.print("The Game has finished");

    }

}
