package com.example.challenge.state;

import com.example.challenge.model.Game;
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

    @Override
    public void process(Optional<List<Game>> games) {


        if (games.isPresent()) {
            GameUtil.printMessage("Teams scare");
            Map<String, Integer> team1Map = GameUtil.groupByTeam1(games.get());
            Map<String, Integer> team2Map = GameUtil.groupByTeam2(games.get());
            team1Map.putAll(team2Map);

            LinkedHashMap<String, Integer> sortedMap =
                GameUtil.sortMapByValue(team1Map);

            GameUtil.printMap(sortedMap);

        } else {
            GameUtil.printMessage("There is not score for the teams");
        }

        GameUtil.printMessage("The Game has finished");

    }

}
