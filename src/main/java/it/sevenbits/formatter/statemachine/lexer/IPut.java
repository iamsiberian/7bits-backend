package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public interface IPut<T> {

    /**
     *
     *
     * @param state
     * @param character
     * @param t
     */
    void put (State state, Character character, T t);
}
