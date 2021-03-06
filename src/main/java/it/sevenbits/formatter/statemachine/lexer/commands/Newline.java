package it.sevenbits.formatter.statemachine.lexer.commands;

import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.IContext;

/**
 * The class command that adds the current character to the lexeme
 * and specifies the name of the token "newline"
 *
 * @author Minyukhin Ilya
 */
public class Newline implements ICommand {

    @Override
    public void execute(final char c, final IContext context) {
        context.appendLexeme(c);
        context.setTokenName("newline");
    }
}
