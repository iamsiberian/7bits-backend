package it.sevenbits.formatter.statemachine.formatter;

import it.sevenbits.formatter.statemachine.State;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public interface IPut <T> {

    /**
     *
     *
     * @param state
     * @param tokenName
     * @param t
     */
    void put (State state, String tokenName, T t);
}
