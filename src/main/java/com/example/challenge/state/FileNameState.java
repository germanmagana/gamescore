package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.util.GameUtil;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author German Magana
 *
 * This class reads the file to process the game results in this: format Lions 3, Snakes 3
 */
public class FileNameState implements State {

    private StateMachine stateMachine;

    public FileNameState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void process(Optional<List<Game>> games) {
        Scanner scan = new Scanner(System.in);

        GameUtil.printMessage("Selected option: 2");

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            GameUtil.exit(line, stateMachine, games.get());

            if (StringUtils.hasText(line)) {
                File file = new File(line);
                if (!file.exists()) {
                    GameUtil.printMessage("File does not exist");
                    stateMachine.setState(stateMachine.getSelectOptionState());
                    stateMachine.getState().process(games);
                } else {

                    try {
                        Scanner myReader = new Scanner(file);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            Optional<Game> game = GameUtil.createGame(data);
                            if(game.isPresent()){
                                games.get().add(game.get());
                            }
                        }
                        myReader.close();
                        GameUtil.exit(line,stateMachine,games.get());
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


