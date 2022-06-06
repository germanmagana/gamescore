package com.example.challenge.state;

import com.example.challenge.model.Game;

import java.util.List;
import java.util.Optional;

/**
 * @author German magana
 *
 * This an interface to establish the contract for the state machine
 */
public interface State {

    public void process(Optional<List<Game>> games);
}
