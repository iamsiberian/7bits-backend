package it.sevenbits.formatter.statemachine.formatter.commands;

import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.IContext;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 * A class command that does not do anything.
 *
 * @author Minyukhin Ilya
 */
public class Empty implements ICommand {
    @Override
    public void execute(final IToken token, final IContext context) throws ContextException {
    }
}
