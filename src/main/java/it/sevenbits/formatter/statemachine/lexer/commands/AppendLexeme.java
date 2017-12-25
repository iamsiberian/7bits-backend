package it.sevenbits.formatter.statemachine.lexer.commands;

import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.IContext;

/**
 * The class command that adds the current character to the lexeme
 *
 * @author Minyukhin Ilya
 */
public class AppendLexeme implements ICommand {

    @Override
    public void execute(final char c, final IContext context) {
        context.appendLexeme(c);
    }
}
