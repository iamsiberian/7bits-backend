package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public interface IInitialize<T, U> {
    /**
     *
     *
     * @param state
     * @param character
     * @param t
     */
    void initCommandRepository(State state, Character character, T t);

    /**
     *
     *
     * @param state
     * @param character
     * @param u
     */
    void initStateTransitions(State state, Character character, U u);

}
