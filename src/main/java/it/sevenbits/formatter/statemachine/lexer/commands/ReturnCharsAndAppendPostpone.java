package it.sevenbits.formatter.statemachine.lexer.commands;

import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.IContext;

/**
 * The class command adds:
 * 1) specifies the name of the token "spaces"
 * 2) the current character to the pre-read buffer
 *
 * @author Minyukhin Ilya
 */
public class ReturnCharsAndAppendPostpone implements ICommand {
    @Override
    public void execute(final char c, final IContext context) {
        context.setTokenName("chars");
        context.appendPostpone(c);
    }
}
