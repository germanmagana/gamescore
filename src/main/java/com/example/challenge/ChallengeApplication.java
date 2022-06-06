package com.example.challenge;

import com.example.challenge.model.Game;
import com.example.challenge.reader.FileReader;
import com.example.challenge.state.StateMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);

        FileReader.printWelcome(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "init-screen.txt");

        FileReader.printWelcome(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "game-menu.txt");

        StateMachine stateMachine = new StateMachine();
        stateMachine.getState().process(Optional.of(new ArrayList<Game>()));

    }

}
