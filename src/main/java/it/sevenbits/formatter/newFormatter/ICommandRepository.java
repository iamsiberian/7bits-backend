package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.State;
import it.sevenbits.formatter.token.IToken;

/**
 * Interface for receiving commands
 *
 * @author Minyukhin Ilya
 */
public interface ICommandRepository {

    /**
     * The method will return the command derived from the current state and the token that was read
     *
     * @param state current state
     * @param token the token that was read
     * @return ICommand command
     */
    ICommand getCommand(State state, IToken token);
}
