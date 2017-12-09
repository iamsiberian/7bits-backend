package it.sevenbits.formatter.newLexer;

import it.sevenbits.formatter.State;

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
