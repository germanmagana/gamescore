package com.example.challenge.state;

import com.example.challenge.model.Game;
import com.example.challenge.util.GameUtil;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author German magana
 *
 * This class is the entry point to select the opionts for the game
 */
public class SelectState implements State {

    private StateMachine stateMachine;

    public SelectState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void process(Optional<List<Game>> games) {
        Scanner scan = new Scanner(System.in);

        GameUtil.printMessage("Select option:");

        GameUtil.selectStateMachine(scan, stateMachine, games);
    }

}
