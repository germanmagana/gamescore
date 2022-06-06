package com.example.challenge.state;

/**
 * @author German magana
 *
 * This class is the state machine that has all the states for the game
 */
public class StateMachine {

    private State selectOptionState;
    private State stdinState;
    private State fileNameState;
    private State exitState;
    private State invalidState;
    private State state;

    public StateMachine() {

        selectOptionState = new SelectState(this);
        stdinState = new StdinState(this);
        fileNameState = new FileNameState(this);
        exitState = new ExitState(this);
        invalidState = new InvalidState(this);

        state = selectOptionState;
    }

    public State getSelectOptionState() {
        return selectOptionState;
    }

    public void setSelectOptionState(State selectOptionState) {
        this.selectOptionState = selectOptionState;
    }

    public State getStdinState() {
        return stdinState;
    }

    public void setStdinState(State stdinState) {
        this.stdinState = stdinState;
    }

    public State getFileNameState() {
        return fileNameState;
    }

    public void setFileNameState(State fileNameState) {
        this.fileNameState = fileNameState;
    }

    public State getExitState() {
        return exitState;
    }

    public void setExitState(State exitState) {
        this.exitState = exitState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getInvalidState() {
        return invalidState;
    }

    public void setInvalidState(State invalidState) {
        this.invalidState = invalidState;
    }
}
