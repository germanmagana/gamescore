package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.util.GameUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author German Magana
 *
 * This class read the games scores from the console in the next format: Lions 3, Snakes 3
 */
public class StdinState implements State {

    private List<Game>   games = new ArrayList<>();
    private StateMachine stateMachine;

    public StdinState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void process(Optional<List<Game>> games) {
        Scanner scan = new Scanner(System.in);

        GameUtil.printMessage("Selected option: 1");

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            if (StringUtils.hasText(line)) {

                GameUtil.exit(line,stateMachine,games.get());

                Optional<Game> game = GameUtil.createGame(line);

                if (game.isPresent()) {
                    games.get().add(game.get());
                } else {
                    GameUtil.printMessage("Unable to read the entry, please try again");
                }
            }
        }
    }

}
