package it.sevenbits.formatter.statemachine.formatter.commands;

import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.IContext;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 * Class command that writes the newline separator
 *
 * @author Minyukhin Ilya
 */
public class WriteNewLine implements ICommand {
    @Override
    public void execute(final IToken token, final IContext context) throws ContextException {
        context.writeNewLine();
    }
}
