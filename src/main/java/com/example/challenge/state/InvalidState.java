package com.example.challenge.state;

import com.example.challenge.model.Game;

import java.util.List;
import java.util.Optional;

/**
 * @author German Magana
 *
 * This class is excuted when the user entered an invalid option
 */
public class InvalidState implements State{

    private StateMachine stateMachine;

    public InvalidState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void process(Optional<List<Game>> games) {

    }

}
