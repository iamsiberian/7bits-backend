package it.sevenbits.formatter.statemachine.formatter.commands;

import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.IContext;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 * Class command that writes a lexeme
 *
 * @author Minyukhin Ilya
 */
public class WriteLexeme implements ICommand {
    @Override
    public void execute(final IToken token, final IContext context) throws ContextException {
        context.writeLexeme(token.getLexeme());
    }
}
