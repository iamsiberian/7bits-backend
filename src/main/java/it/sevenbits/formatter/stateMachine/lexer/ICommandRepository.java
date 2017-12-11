package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.State;

/**
 * Interface for receiving commands
 *
 * @author Minyukhin Ilya
 */
public interface ICommandRepository {

    /**
     * The method will return the command derived from the current state and the read symbol
     *
     * @param state current state
     * @param c the character that was read
     * @return ICommand command
     */
    ICommand getCommand(State state, char c);
}
