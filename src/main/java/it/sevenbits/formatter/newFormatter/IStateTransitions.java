package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.State;
import it.sevenbits.formatter.token.IToken;

/**
 * Interface for generating the next state based on the current state and the token that was read
 *
 * @author Minyukhin Ilya
 */
public interface IStateTransitions {

    /**
     * The method returns the next state based on the current state and the token that was read
     *
     * @param state current state
     * @param token the token that was read
     * @return State next state
     */
    State getNextState(State state, IToken token);
}
