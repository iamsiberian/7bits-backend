package it.sevenbits.formatter.statemachine.formatter.commands;

import it.sevenbits.formatter.statemachine.formatter.ContextException;
import it.sevenbits.formatter.statemachine.formatter.ICommand;
import it.sevenbits.formatter.statemachine.formatter.IContext;
import it.sevenbits.formatter.statemachine.token.IToken;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public class CloseBraceInStartLine implements ICommand {
    @Override
    public void execute(IToken token, IContext context) throws ContextException {
        context.decreaseCountLevel();
        context.writeIndent();
        context.writeLexeme(token.getLexeme());
        context.writeNewLine();
    }
}
