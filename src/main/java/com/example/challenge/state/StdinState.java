package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.reader.ConsoleReader;
import com.example.challenge.reader.ConsoleReaderImpl;
import com.example.challenge.util.ConsoleUtil;
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
    private ConsoleReader consoleReader;

    public StdinState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.consoleReader = new ConsoleReaderImpl();
    }

    @Override
    public void process(Optional<List<Game>> games) {
        Scanner scan = consoleReader.createScanner();

        ConsoleUtil.print("Selected option: 1");

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            if (StringUtils.hasText(line)) {

                GameUtil.exit(line,stateMachine,games.get());

                Optional<Game> game = GameUtil.createGame(line);

                if (game.isPresent()) {
                    games.get().add(game.get());
                } else {
                    ConsoleUtil.print("Unable to read the entry, please try again");
                }
            }
        }
    }

}
