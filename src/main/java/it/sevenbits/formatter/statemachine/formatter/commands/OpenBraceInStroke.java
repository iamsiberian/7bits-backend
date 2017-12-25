package it.sevenbits.formatter.statemachine.formatter.commands;

import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.IContext;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 * Class command that performs the necessary actions if encountered
 * opening curly brace inside a line
 *
 * @author Minyukhin Ilya
 */
public class OpenBraceInStroke implements ICommand {
    @Override
    public void execute(final IToken token, final IContext context) throws ContextException {
        context.writeLexeme(token.getLexeme());
        context.writeNewLine();
        context.increaseCountLevel();
    }
}
