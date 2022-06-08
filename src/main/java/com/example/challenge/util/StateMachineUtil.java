package com.example.challenge.util;

import com.example.challenge.model.Game;
import com.example.challenge.model.Team;
import com.example.challenge.state.StateMachine;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author German Magana
 *
 * This class has general methods for the state machine
 */
final public class StateMachineUtil {

    private StateMachineUtil() {

    }

    /**
     * This method selects the state machine from the option selected
     * @param scan
     * @param stateMachine
     * @param games
     */
    public static void selectStateMachine(Scanner scan, StateMachine stateMachine,
        Optional<List<Game>> games) {
        boolean stateSelected = false;

        while (scan.hasNext() && !stateSelected) {
            int option = scan.nextInt();
            if (option == 1) {
                stateMachine.setState(stateMachine.getStdinState());
                stateMachine.getState().process(games);
                stateSelected = true;
            } else if (option == 2) {
                stateMachine.setState(stateMachine.getFileNameState());
                stateMachine.getState().process(games);
                stateSelected = true;

            } else if (option == 3) {
                stateMachine.setState(stateMachine.getExitState());
                stateMachine.getState().process(games);
                stateSelected = true;

            } else {
                stateMachine.setState(stateMachine.getInvalidState());
                stateSelected = true;

            }
        }
    }


}
