package com.example.challenge;

import com.example.challenge.model.Game;
import com.example.challenge.reader.FileReader;
import com.example.challenge.state.StateMachine;
import com.example.challenge.util.ConsoleUtil;
import com.example.challenge.util.GameUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication public class ChallengeApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(ChallengeApplication.class, args);

        List<String> intiScreenMsg = FileReader.read(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "init-screen.txt");

        ConsoleUtil.print(intiScreenMsg);

        List<String> menu = FileReader.read(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "game-menu.txt");

        ConsoleUtil.print(menu);

        StateMachine stateMachine = new StateMachine();
        stateMachine.getState().process(Optional.of(new ArrayList<Game>()));

    }

}
