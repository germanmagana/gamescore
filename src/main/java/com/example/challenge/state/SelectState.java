package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.reader.ConsoleReader;
import com.example.challenge.reader.ConsoleReaderImpl;
import com.example.challenge.util.ConsoleUtil;
import com.example.challenge.util.StateMachineUtil;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author German magana
 *
 * This class is the entry point to select the opionts for the game
 */
public class SelectState implements State {

    private StateMachine  stateMachine;
    private ConsoleReader consoleReader;

    public SelectState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.consoleReader = new ConsoleReaderImpl();
    }

    @Override
    public void process(Optional<List<Game>> games) {
        Scanner scan = consoleReader.createScanner();

        ConsoleUtil.print("Select option:");

        StateMachineUtil.selectStateMachine(scan, stateMachine, games);
    }

}
