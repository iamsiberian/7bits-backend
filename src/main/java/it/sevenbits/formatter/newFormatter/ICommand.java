package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.token.IToken;

/**
 * Interface for executing commands
 *
 * @author Minyukhin Ilya
 */
public interface ICommand {

    /**
     * The method passes token to an instance of the IContext class
     *
     * @param token the token that was read
     * @param context an instance of a class that implements an IContext interface
     */
    void execute(IToken token, IContext context) throws ContextException;
}
