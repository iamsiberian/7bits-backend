package it.sevenbits.formatter.statemachine.lexer.commands;

import it.sevenbits.formatter.statemachine.lexer.ICommand;
import it.sevenbits.formatter.statemachine.lexer.IContext;

/**
 *
 *
 * @author Minyukhin Ilya
 */
public class AppendPostpone implements ICommand {
    @Override
    public void execute(char c, IContext context) {
        context.appendPostpone(c);
    }
}
