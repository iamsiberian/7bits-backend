package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;

/**
 * Interface for generating the next state based on the current state and the character that was read
 *
 * @author Minyukhin Ilya
 */
public interface IStateTransitions {

    /**
     * The method returns the next state based on the current state and the character that was read
     *
     * @param state current state
     * @param c the character that was read
     * @return State next state
     */
    State nextState(State state, char c);
}
